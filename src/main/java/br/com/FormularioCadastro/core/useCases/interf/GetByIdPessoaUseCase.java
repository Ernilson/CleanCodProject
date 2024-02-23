package br.com.FormularioCadastro.core.useCases.interf;

import java.util.Optional;

import br.com.FormularioCadastro.core.domain.Pessoa;

public interface GetByIdPessoaUseCase {
	
	Optional <Pessoa> getById(Long id);
	

}
