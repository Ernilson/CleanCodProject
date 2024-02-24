package br.com.FormularioCadastro.core.useCases.pessoaUseCases;

import br.com.FormularioCadastro.core.domain.Pessoa;
import br.com.FormularioCadastro.core.gateways.PessoaGateway;
import br.com.FormularioCadastro.core.useCases.pessoaUseCases.Inter.CreatePessoaUseCase;
import br.com.FormularioCadastro.infraEstrutura.exceptions.BusinessException;

public class CreatePessoaUseCaseImp implements CreatePessoaUseCase {

    private final PessoaGateway pessoaGateway;

    public CreatePessoaUseCaseImp(PessoaGateway pessoaGateway){
        this.pessoaGateway = pessoaGateway;
    }
    
    @Override
    public Pessoa execute(Pessoa pessoa) {
    	Pessoa pessoExistente = pessoaGateway.findByCpfCnpj(pessoa.cpfCnj());
    	if (pessoExistente != null) {
			throw new BusinessException("Já existe um cpf/cnpj cadastrado");
		}
        return pessoaGateway.createPessoa(pessoa);
    }
}
