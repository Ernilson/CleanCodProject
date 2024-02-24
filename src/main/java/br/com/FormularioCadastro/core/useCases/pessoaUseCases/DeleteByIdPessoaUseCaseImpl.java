package br.com.FormularioCadastro.core.useCases.pessoaUseCases;

import br.com.FormularioCadastro.core.gateways.PessoaGateway;
import br.com.FormularioCadastro.core.useCases.pessoaUseCases.Inter.DeleteByIdPessoaUseCase;

public class DeleteByIdPessoaUseCaseImpl implements DeleteByIdPessoaUseCase{
	
	private PessoaGateway pessoaGateway;
	
	public DeleteByIdPessoaUseCaseImpl(PessoaGateway pessoaGateway) {
		this.pessoaGateway = pessoaGateway;
	}

	@Override
	public void delete(Long id) {
		pessoaGateway.delete(id);
		
	}
}
