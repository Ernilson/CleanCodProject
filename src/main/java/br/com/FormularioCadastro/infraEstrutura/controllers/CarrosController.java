package br.com.FormularioCadastro.infraEstrutura.controllers;

import br.com.FormularioCadastro.core.domain.Carros;
import br.com.FormularioCadastro.core.useCases.carroUseCase.Inter.CreateCarroUseCase;
import br.com.FormularioCadastro.core.useCases.carroUseCase.Inter.DeleteCarrosUseCase;
import br.com.FormularioCadastro.core.useCases.carroUseCase.Inter.FindAllCarrosUseCase;
import br.com.FormularioCadastro.core.useCases.carroUseCase.Inter.FindByIdCarrosUseCase;
import br.com.FormularioCadastro.infraEstrutura.dtos.CarrosDTO;
import br.com.FormularioCadastro.infraEstrutura.mapper.CarrosMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/carros")
public class CarrosController {
    private final CreateCarroUseCase createCarroUseCase;
    private final FindByIdCarrosUseCase findByIdCarrosUseCase;
    private final FindAllCarrosUseCase findAllCarrosUseCase;
    private final DeleteCarrosUseCase deletaCarro;

    private final CarrosMapper mapper;

    public CarrosController(CreateCarroUseCase createCarroUseCase, FindByIdCarrosUseCase findByIdCarrosUseCase,
                            FindAllCarrosUseCase findAllCarrosUseCase, DeleteCarrosUseCase deletaCarro,
                            CarrosMapper mappe) {
        this.createCarroUseCase = createCarroUseCase;
        this.findByIdCarrosUseCase = findByIdCarrosUseCase;
        this.findAllCarrosUseCase = findAllCarrosUseCase;
        this.deletaCarro = deletaCarro;
        this.mapper = mappe;
    }

    @PostMapping
    public CarrosDTO createCarro(@RequestBody CarrosDTO carrosDTO) {
        Carros carro = createCarroUseCase.execute(mapper.toCarros(carrosDTO));
        return mapper.toCarrosDTO(carro);
    }

    @GetMapping("/{id}")
    public Optional<CarrosDTO> buscaPorId(@PathVariable Long id) {
        Optional<Carros> carrosOptional = findByIdCarrosUseCase.findByIdCarros(id);
        if (carrosOptional.isPresent()) {
            Carros carros = carrosOptional.get();
            CarrosDTO carrosDTO = mapper.toCarrosDTO(carros);
            return Optional.of(carrosDTO);
        }
        return Optional.empty();
    }

    @GetMapping
    public List<CarrosDTO> listaTodos(){
        var carros = findAllCarrosUseCase.findAll();
        return mapper.toCarroDTOList(carros);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletaCarro(@PathVariable Long id){
        deletaCarro.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("O carro com ID" + id +" não pode ser encontrado!");
    }

}
