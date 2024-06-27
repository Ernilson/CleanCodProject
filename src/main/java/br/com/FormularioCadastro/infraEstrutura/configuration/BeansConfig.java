package br.com.FormularioCadastro.infraEstrutura.configuration;

import br.com.FormularioCadastro.core.gateways.CarroGateway;
import br.com.FormularioCadastro.core.useCases.carroUseCase.CreateCarroUseCaseImpl;
import br.com.FormularioCadastro.core.useCases.carroUseCase.FindByIdCarroUseCaseImpl;
import br.com.FormularioCadastro.core.useCases.carroUseCase.Inter.CreateCarroUseCase;
import br.com.FormularioCadastro.core.useCases.carroUseCase.Inter.FindByIdCarrosUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.FormularioCadastro.core.gateways.PessoaGateway;
import br.com.FormularioCadastro.core.useCases.pessoaUseCases.CreatePessoaUseCaseImp;
import br.com.FormularioCadastro.core.useCases.pessoaUseCases.DeleteByIdPessoaUseCaseImpl;
import br.com.FormularioCadastro.core.useCases.pessoaUseCases.GetAllPessoaUseCaseImpl;
import br.com.FormularioCadastro.core.useCases.pessoaUseCases.GetByIdPessoaUseCaseImpl;
import br.com.FormularioCadastro.core.useCases.pessoaUseCases.Inter.CreatePessoaUseCase;
import br.com.FormularioCadastro.core.useCases.pessoaUseCases.Inter.DeleteByIdPessoaUseCase;
import br.com.FormularioCadastro.core.useCases.pessoaUseCases.Inter.GetAllPessoasUseCase;
import br.com.FormularioCadastro.core.useCases.pessoaUseCases.Inter.GetByIdPessoaUseCase;

@Configuration
public class BeansConfig {

    @Bean
    public ModelMapper modelMapper(){

        return new ModelMapper();
    }

    //-------------------------------Pessoas ---------------------------------//
    @Bean
    public CreatePessoaUseCase createPessoaUseCase(PessoaGateway pessoaGateway){
        return new CreatePessoaUseCaseImp(pessoaGateway);
    }
    
    @Bean
    public GetAllPessoasUseCase getAllPessoasUseCase(PessoaGateway pessoaGateway) {
    	return new GetAllPessoaUseCaseImpl(pessoaGateway);
    }
    
    @Bean
    public GetByIdPessoaUseCase getByIdPessoaUseCase(PessoaGateway pessoaGateway){
    	return new GetByIdPessoaUseCaseImpl(pessoaGateway);
    }
    
    @Bean
    public DeleteByIdPessoaUseCase DeleteById(PessoaGateway pessoaGateway) {
    	return new DeleteByIdPessoaUseCaseImpl(pessoaGateway);
    }

    // ------------------------Carros----------------------------------------//
    @Bean
    public CreateCarroUseCase createCarroUseCase(CarroGateway carroGateway){
        return new CreateCarroUseCaseImpl(carroGateway);
    }
    @Bean
    public FindByIdCarrosUseCase findByIdCarrosUseCase(CarroGateway carroGateway){
        return new FindByIdCarroUseCaseImpl(carroGateway);
    }
}
