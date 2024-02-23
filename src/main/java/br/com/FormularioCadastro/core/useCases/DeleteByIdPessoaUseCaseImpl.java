package br.com.FormularioCadastro.core.useCases;

import br.com.FormularioCadastro.core.gateways.PessoaGateway;
import br.com.FormularioCadastro.core.useCases.interf.DeleteByIdPessoaUseCase;

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
