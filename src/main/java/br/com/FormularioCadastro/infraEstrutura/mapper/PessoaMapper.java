package br.com.FormularioCadastro.infraEstrutura.mapper;

import br.com.FormularioCadastro.core.domain.Pessoa;
import br.com.FormularioCadastro.infraEstrutura.dtos.PessoaDTO;
import br.com.FormularioCadastro.infraEstrutura.persistence.pessoaEntity.PessoaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaMapper {

    private final ModelMapper mapper;

    public PessoaMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    //De PessoaDTOpara Pessoa -----------------------------------
    public Pessoa toPessoa(PessoaDTO dto) {
        return mapper.map(dto, Pessoa.class);
    }

    //Pessoa para PessoaDTO
    public PessoaDTO toPessoaDTO(Pessoa pessoa) {
        return mapper.map(pessoa, PessoaDTO.class);
    }

    public List<PessoaDTO> toPessoaDTOList(List<Pessoa> pessoas) {
        return pessoas.stream()
                .map(this::toPessoaDTO)
                .collect(Collectors.toList());
    }

    //De Pessoa para PessoaEntity ----------------------------------------
    public PessoaEntity toPessoaEntity(Pessoa pessoa) {
        return mapper.map(pessoa, PessoaEntity.class);
    }

    public Pessoa toPessoa(PessoaEntity entity) {
        return mapper.map(entity, Pessoa.class);
    }

}
