package br.com.FormularioCadastro.core.useCases.carroUseCase.Inter;

import br.com.FormularioCadastro.core.domain.Carros;

import java.util.Optional;

public interface FindByIdCarrosUseCase {

    Optional<Carros> findByIdCarros(Long id);

}
