package br.com.FormularioCadastro.infraEstrutura.service;

import br.com.FormularioCadastro.core.domain.Pessoa;
import br.com.FormularioCadastro.core.gateways.PessoaGateway;
import br.com.FormularioCadastro.infraEstrutura.converters.PessoaEntityMapper;
import br.com.FormularioCadastro.infraEstrutura.exceptions.NullExcecptions;
import br.com.FormularioCadastro.infraEstrutura.persistence.PessoaEntity;
import br.com.FormularioCadastro.infraEstrutura.persistence.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PessoaRepositoryGatway implements PessoaGateway {

    private final PessoaRepository repository;
    private final PessoaEntityMapper entityMapper;

    @Override
    public Pessoa createPessoa(Pessoa pessoa) {
     PessoaEntity entity = entityMapper.DomaintoEntity(pessoa);
     PessoaEntity novaPessoa = repository.save(entity);
         return entityMapper.EntityToDomain(novaPessoa);
    }

	@Override
	public Pessoa findByCpfCnpj(String cpfCnpj) {
	 PessoaEntity entity = repository.findByCpfCnpj(cpfCnpj);
	 if (entity == null) {
		//throw new NullExcecptions("O campo cpf/cnpj esta vazio!");
		 return null;
	}
		return entityMapper.EntityToDomain(entity);
	}

	@Override
	public List<Pessoa> obtenAllPessoas() {
		return repository.findAll()
		.stream()
		.map(entity -> entityMapper.EntityToDomain(entity))
		.collect(Collectors.toList());
	}
}
