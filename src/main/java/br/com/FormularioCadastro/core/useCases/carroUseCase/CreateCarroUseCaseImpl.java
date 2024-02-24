package br.com.FormularioCadastro.core.useCases.carroUseCase;

import br.com.FormularioCadastro.core.domain.Carros;
import br.com.FormularioCadastro.core.gateways.CarroGateway;
import br.com.FormularioCadastro.core.useCases.carroUseCase.Inter.CreateCarroUseCase;

public class CreateCarroUseCaseImpl implements CreateCarroUseCase {

    private CarroGateway carroGateway;

    public CreateCarroUseCaseImpl(CarroGateway carroGateway){
        this.carroGateway = carroGateway;
    }

    @Override
    public Carros execute(Carros carros) {

        return carroGateway.createCarros(carros);
    }
}
