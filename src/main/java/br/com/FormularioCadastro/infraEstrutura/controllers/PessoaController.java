package br.com.FormularioCadastro.infraEstrutura.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.FormularioCadastro.core.domain.Pessoa;
import br.com.FormularioCadastro.core.useCases.interf.CreatePessoaUseCase;
import br.com.FormularioCadastro.core.useCases.interf.GetAllPessoasUseCase;
import br.com.FormularioCadastro.infraEstrutura.converters.PessoaDTOMapper;
import br.com.FormularioCadastro.infraEstrutura.dtos.PessoaDTO;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/pessoas")
@AllArgsConstructor
public class PessoaController {

    private final CreatePessoaUseCase createPessoaUseCase;
    private final PessoaDTOMapper mapper;
    private final GetAllPessoasUseCase getAllPessoaUseCase;

    @PostMapping
    public PessoaDTO createPessoa(@RequestBody PessoaDTO pessoaDTO){
     Pessoa pessoa = createPessoaUseCase.execute(mapper.toDomain(pessoaDTO));
     return mapper.toDTO(pessoa);
    }
    
    @GetMapping
    public List<PessoaDTO> obtainAll(){    	
    	return getAllPessoaUseCase.execute()
    			.stream().map(pessoa -> mapper.toDTO(pessoa))
    			.collect(Collectors.toList());    	
    }
}
