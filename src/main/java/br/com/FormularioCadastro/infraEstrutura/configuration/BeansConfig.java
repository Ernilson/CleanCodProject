package br.com.FormularioCadastro.infraEstrutura.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.FormularioCadastro.core.gateways.PessoaGateway;
import br.com.FormularioCadastro.core.useCases.CreatePessoaUseCaseImp;
import br.com.FormularioCadastro.core.useCases.GetAllPessoaUseCaseImpl;
import br.com.FormularioCadastro.core.useCases.interf.CreatePessoaUseCase;
import br.com.FormularioCadastro.core.useCases.interf.GetAllPessoasUseCase;

@Configuration
public class BeansConfig {

    @Bean
    public CreatePessoaUseCase createPessoaUseCase(PessoaGateway pessoaGateway){
        return new CreatePessoaUseCaseImp(pessoaGateway);
    }
    
    @Bean
    public GetAllPessoasUseCase getAllPessoasUseCase(PessoaGateway pessoaGateway) {
    	return new GetAllPessoaUseCaseImpl(pessoaGateway);
    }
}
