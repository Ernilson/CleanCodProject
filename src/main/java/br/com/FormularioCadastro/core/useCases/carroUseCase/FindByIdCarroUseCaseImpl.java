package br.com.FormularioCadastro.core.useCases.carroUseCase;

import br.com.FormularioCadastro.core.domain.Carros;
import br.com.FormularioCadastro.core.gateways.CarroGateway;
import br.com.FormularioCadastro.core.useCases.carroUseCase.Inter.FindByIdCarrosUseCase;

import java.util.Optional;

public class FindByIdCarroUseCaseImpl implements FindByIdCarrosUseCase {

    private CarroGateway carroGateway;

    public FindByIdCarroUseCaseImpl(CarroGateway carroGateway){
        this.carroGateway = carroGateway;
    }

    @Override
    public Optional<Carros> findByIdCarros(Long id) {
        return carroGateway.findById(id);
    }
}
