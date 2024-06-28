package br.com.FormularioCadastro.core.useCases.carroUseCase;

import br.com.FormularioCadastro.core.domain.Carros;
import br.com.FormularioCadastro.core.gateways.CarroGateway;
import br.com.FormularioCadastro.core.useCases.carroUseCase.Inter.FindAllCarrosUseCase;

import java.util.List;

public class FindAllCarroUseCaseImpl implements FindAllCarrosUseCase {

    private CarroGateway gateway;

    public FindAllCarroUseCaseImpl(CarroGateway gateway){
        this.gateway = gateway;
    }

    @Override
    public List<Carros> findAll() {
         return gateway.findAll();
    }
}
