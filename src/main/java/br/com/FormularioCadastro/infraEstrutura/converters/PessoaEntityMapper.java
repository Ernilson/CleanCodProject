package br.com.FormularioCadastro.infraEstrutura.converters;

import br.com.FormularioCadastro.core.domain.Pessoa;
import br.com.FormularioCadastro.infraEstrutura.persistence.PessoaEntity;
import org.springframework.stereotype.Component;

@Component
public class PessoaEntityMapper {

    public PessoaEntity DomaintoEntity(Pessoa pessoa){
        return new PessoaEntity(pessoa.id(), pessoa.nome(), pessoa.email(), pessoa.cpfCnj(), pessoa.tipo());
    }

    public Pessoa EntityToDomain(PessoaEntity entity){
        return new Pessoa(entity.getId(), entity.getNome(), entity.getEmail(), entity.getCpfCnpj(), entity.getTipo());
    }
}
