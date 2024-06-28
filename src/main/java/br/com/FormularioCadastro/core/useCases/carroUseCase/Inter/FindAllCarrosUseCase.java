package br.com.FormularioCadastro.core.useCases.carroUseCase.Inter;

import br.com.FormularioCadastro.core.domain.Carros;

import java.util.List;

public interface FindAllCarrosUseCase {
    public List<Carros> findAll();
}
