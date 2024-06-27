package br.com.FormularioCadastro.infraEstrutura.controllers;

import br.com.FormularioCadastro.core.domain.Carros;
import br.com.FormularioCadastro.core.useCases.carroUseCase.Inter.CreateCarroUseCase;
import br.com.FormularioCadastro.core.useCases.carroUseCase.Inter.FindByIdCarrosUseCase;
import br.com.FormularioCadastro.infraEstrutura.dtos.CarrosDTO;
import br.com.FormularioCadastro.infraEstrutura.mapper.CarrosMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/carros")
public class CarrosController {
    private final CreateCarroUseCase createCarroUseCase;
    private final FindByIdCarrosUseCase findByIdCarrosUseCase;

    private final CarrosMapper mapper;

    public CarrosController(CreateCarroUseCase createCarroUseCase, FindByIdCarrosUseCase findByIdCarrosUseCase,
                            CarrosMapper mappe) {
        this.createCarroUseCase = createCarroUseCase;
        this.findByIdCarrosUseCase = findByIdCarrosUseCase;
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
}
