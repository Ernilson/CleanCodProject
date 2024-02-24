package br.com.FormularioCadastro.core.useCases.pessoaUseCases.Inter;

import br.com.FormularioCadastro.core.domain.Pessoa;

public interface CreatePessoaUseCase {
    public Pessoa execute(Pessoa pessoa);
}
