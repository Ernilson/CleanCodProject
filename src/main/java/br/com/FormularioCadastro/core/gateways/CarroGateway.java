package br.com.FormularioCadastro.core.gateways;

import br.com.FormularioCadastro.core.domain.Carros;

import java.util.List;
import java.util.Optional;


public interface CarroGateway {

    Carros createCarros(Carros carros);

    Optional<Carros> findById(Long id);

    List<Carros> findAll();

    void deleteById(Long id);
}
