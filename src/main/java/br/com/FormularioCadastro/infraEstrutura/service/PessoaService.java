package br.com.FormularioCadastro.infraEstrutura.service;

import br.com.FormularioCadastro.core.domain.Pessoa;
import br.com.FormularioCadastro.core.gateways.PessoaGateway;
import br.com.FormularioCadastro.infraEstrutura.mapper.PessoaMapper;
import br.com.FormularioCadastro.infraEstrutura.persistence.pessoaEntity.PessoaEntity;
import br.com.FormularioCadastro.infraEstrutura.persistence.pessoaEntity.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService implements PessoaGateway {

    private final PessoaRepository repository;
    private final PessoaMapper pessoaMapper;

    @Override
    public Pessoa createPessoa(Pessoa pessoa) {
        PessoaEntity entity = pessoaMapper.toPessoaEntity(pessoa);
        PessoaEntity novaPessoa = repository.save(entity);
        return pessoaMapper.toPessoa(novaPessoa);
    }

    @Override
    public Pessoa findByCpfCnpj(String cpfCnpj) {
        PessoaEntity entity = repository.findByCpfCnpj(cpfCnpj);
        if (entity == null) {
            return null;
        }
        return pessoaMapper.toPessoa(entity);
    }

    @Override
    public List<Pessoa> obtenAllPessoas() {
        return repository.findAll().stream().map(entity -> pessoaMapper.toPessoa(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        Optional<PessoaEntity> entityOptional = repository.findById(id);
        if (entityOptional.isPresent()) {
            PessoaEntity entity = entityOptional.get();
            return Optional.of(pessoaMapper.toPessoa(entity));
        }
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        Optional<PessoaEntity> entityOptional = repository.findById(id);
        if (entityOptional.isPresent()) {
            entityOptional.ifPresent(entity -> repository.deleteById(id));
        }

    }
}
