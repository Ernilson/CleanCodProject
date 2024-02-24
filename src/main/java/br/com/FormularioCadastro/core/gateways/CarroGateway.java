package br.com.FormularioCadastro.core.gateways;

import br.com.FormularioCadastro.core.domain.Carros;

import java.util.Optional;


public interface CarroGateway {

    Carros createCarros(Carros carros);

    Optional<Carros> findById(Long id);
}
