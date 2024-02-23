package br.com.FormularioCadastro.infraEstrutura.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.FormularioCadastro.core.domain.Pessoa;
import br.com.FormularioCadastro.core.useCases.interf.CreatePessoaUseCase;
import br.com.FormularioCadastro.core.useCases.interf.DeleteByIdPessoaUseCase;
import br.com.FormularioCadastro.core.useCases.interf.GetAllPessoasUseCase;
import br.com.FormularioCadastro.core.useCases.interf.GetByIdPessoaUseCase;
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
    private final GetByIdPessoaUseCase getByIdPessoaUseCase;
    private final DeleteByIdPessoaUseCase deletePessoa;

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
    
    @GetMapping("/{id}")
    public Optional<PessoaDTO> buscarCadasroPorI(@PathVariable Long id){
    	Optional<Pessoa> pessoaOptional = getByIdPessoaUseCase.getById(id);
    	
        if (pessoaOptional.isPresent()) {
        	Pessoa pessoa = pessoaOptional.get();
            PessoaDTO pessoaDTO = mapper.toDTO(pessoa);
            return Optional.of(pessoaDTO);
        } else {
            return Optional.empty(); 
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPessoa(@PathVariable Long id){
    	deletePessoa.delete(id);
    	return ResponseEntity.status(HttpStatus.NO_CONTENT)
    			.body("A pessoa com o ID " + id + " foi deletada com sucesso!");
    }
}
