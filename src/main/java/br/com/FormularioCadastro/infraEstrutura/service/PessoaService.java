package br.com.FormularioCadastro.infraEstrutura.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.FormularioCadastro.core.domain.Pessoa;
import br.com.FormularioCadastro.core.gateways.PessoaGateway;
import br.com.FormularioCadastro.infraEstrutura.converters.pessoaConverter.PessoaEntityConverter;
import br.com.FormularioCadastro.infraEstrutura.persistence.pessoaEntity.PessoaEntity;
import br.com.FormularioCadastro.infraEstrutura.persistence.pessoaEntity.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PessoaService implements PessoaGateway {

	private final PessoaRepository repository;
	private final PessoaEntityConverter entityMapper;

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
			return null;
		}
		return entityMapper.EntityToDomain(entity);
	}

	@Override
	public List<Pessoa> obtenAllPessoas() {
		return repository.findAll().stream().map(entity -> entityMapper.EntityToDomain(entity))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Pessoa> findById(Long id) {
		Optional<PessoaEntity> entityOptional  = repository.findById(id);
		if (entityOptional.isPresent()) {
			PessoaEntity entity = entityOptional.get();
			return Optional.of(entityMapper.EntityToDomain(entity));			
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
