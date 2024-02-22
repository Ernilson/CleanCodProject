package br.com.FormularioCadastro.core.useCases.interf;

import br.com.FormularioCadastro.core.domain.Pessoa;

public interface CreatePessoaUseCase {
    public Pessoa execute(Pessoa pessoa);
}
