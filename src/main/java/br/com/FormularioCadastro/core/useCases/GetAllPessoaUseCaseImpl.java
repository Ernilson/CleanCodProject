package br.com.FormularioCadastro.core.useCases;

import java.util.List;

import br.com.FormularioCadastro.core.domain.Pessoa;
import br.com.FormularioCadastro.core.gateways.PessoaGateway;
import br.com.FormularioCadastro.core.useCases.interf.GetAllPessoasUseCase;

public class GetAllPessoaUseCaseImpl implements GetAllPessoasUseCase{
	
	private final PessoaGateway pessoaGateway;
	
	public GetAllPessoaUseCaseImpl(PessoaGateway pessoaGateway) {
		this.pessoaGateway = pessoaGateway;
	}

	@Override
	public List<Pessoa> execute() {		
		return pessoaGateway.obtenAllPessoas();
	}

}
