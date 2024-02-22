package br.com.FormularioCadastro.core.useCases.interf;

import java.util.List;

import br.com.FormularioCadastro.core.domain.Pessoa;

public interface GetAllPessoasUseCase {

	public List<Pessoa> execute();
}
