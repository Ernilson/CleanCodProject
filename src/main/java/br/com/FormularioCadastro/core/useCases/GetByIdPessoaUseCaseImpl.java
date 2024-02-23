package br.com.FormularioCadastro.core.useCases;

import java.util.Optional;

import br.com.FormularioCadastro.core.domain.Pessoa;
import br.com.FormularioCadastro.core.gateways.PessoaGateway;
import br.com.FormularioCadastro.core.useCases.interf.GetByIdPessoaUseCase;

public class GetByIdPessoaUseCaseImpl implements GetByIdPessoaUseCase{
	
	private PessoaGateway pessoaGateway;
	
	public GetByIdPessoaUseCaseImpl (PessoaGateway pessoaGateway) {
		this.pessoaGateway = pessoaGateway;
	}

	@Override
	public Optional<Pessoa> getById(Long id) {		
		return pessoaGateway.findById(id);
	}

}
