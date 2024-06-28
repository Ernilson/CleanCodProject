package br.com.FormularioCadastro.core.useCases.carroUseCase;

import br.com.FormularioCadastro.core.gateways.CarroGateway;
import br.com.FormularioCadastro.core.useCases.carroUseCase.Inter.DeleteCarrosUseCase;

public class DeleteCarroByIdUseCaseImpl implements DeleteCarrosUseCase {

    private final CarroGateway gateway;

    public DeleteCarroByIdUseCaseImpl(CarroGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void deleteById(Long id) {
        gateway.deleteById(id);
    }
}
