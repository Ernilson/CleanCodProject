package br.com.FormularioCadastro.core.gateways;

import java.util.List;
import java.util.Optional;

import br.com.FormularioCadastro.core.domain.Pessoa;

public interface PessoaGateway {
    Pessoa createPessoa(Pessoa pessoa);
    
    Pessoa findByCpfCnpj(String cpfCnpj);

	List<Pessoa> obtenAllPessoas();

	Optional<Pessoa> findById(Long id);
}
