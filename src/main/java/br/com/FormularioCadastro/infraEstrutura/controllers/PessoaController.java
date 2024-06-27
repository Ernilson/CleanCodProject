package br.com.FormularioCadastro.infraEstrutura.controllers;

import br.com.FormularioCadastro.core.domain.Pessoa;
import br.com.FormularioCadastro.core.useCases.pessoaUseCases.Inter.CreatePessoaUseCase;
import br.com.FormularioCadastro.core.useCases.pessoaUseCases.Inter.DeleteByIdPessoaUseCase;
import br.com.FormularioCadastro.core.useCases.pessoaUseCases.Inter.GetAllPessoasUseCase;
import br.com.FormularioCadastro.core.useCases.pessoaUseCases.Inter.GetByIdPessoaUseCase;
import br.com.FormularioCadastro.infraEstrutura.dtos.PessoaDTO;
import br.com.FormularioCadastro.infraEstrutura.mapper.PessoaMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/pessoas")
@AllArgsConstructor
public class PessoaController {

    private final CreatePessoaUseCase createPessoaUseCase;
    private final GetAllPessoasUseCase getAllPessoaUseCase;
    private final GetByIdPessoaUseCase getByIdPessoaUseCase;
    private final DeleteByIdPessoaUseCase deletePessoa;
    private final PessoaMapper pessoaMapper;

    @PostMapping
    public PessoaDTO createPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = createPessoaUseCase.execute(pessoaMapper.toPessoa(pessoaDTO));
        return pessoaMapper.toPessoaDTO(pessoa);
    }

    @GetMapping
    public List<PessoaDTO> obtainAll() {
        return getAllPessoaUseCase.execute()
                .stream().map(pessoa -> pessoaMapper.toPessoaDTO(pessoa))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<PessoaDTO> buscarCadasroPorI(@PathVariable Long id) {
        Optional<Pessoa> pessoaOptional = getByIdPessoaUseCase.getById(id);

        if (pessoaOptional.isPresent()) {
            Pessoa pessoa = pessoaOptional.get();
            PessoaDTO pessoaDTO = pessoaMapper.toPessoaDTO(pessoa);
            return Optional.of(pessoaDTO);
        } else {
            return Optional.empty();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPessoa(@PathVariable Long id) {
        deletePessoa.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("A pessoa com o ID " + id + " foi deletada com sucesso!");
    }
}
