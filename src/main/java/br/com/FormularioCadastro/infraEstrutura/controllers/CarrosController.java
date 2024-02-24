package br.com.FormularioCadastro.infraEstrutura.controllers;

import br.com.FormularioCadastro.core.domain.Carros;
import br.com.FormularioCadastro.core.domain.Pessoa;
import br.com.FormularioCadastro.core.useCases.carroUseCase.Inter.CreateCarroUseCase;
import br.com.FormularioCadastro.core.useCases.carroUseCase.Inter.FindByIdCarrosUseCase;
import br.com.FormularioCadastro.infraEstrutura.converters.carroConverter.CarrosDtoConverter;
import br.com.FormularioCadastro.infraEstrutura.dtos.CarrosDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarrosController {
    private final CreateCarroUseCase createCarroUseCase;
    private final FindByIdCarrosUseCase findByIdCarrosUseCase;
    private final CarrosDtoConverter carrosDtoConverter;
    public CarrosController(CreateCarroUseCase createCarroUseCase, FindByIdCarrosUseCase findByIdCarrosUseCase,
                            CarrosDtoConverter carrosDtoConverter){
        this.createCarroUseCase = createCarroUseCase;
        this.findByIdCarrosUseCase = findByIdCarrosUseCase;
        this.carrosDtoConverter = carrosDtoConverter;
    }

    @PostMapping
    public CarrosDTO createCarro(@RequestBody CarrosDTO carrosDTO){
       Carros carro = createCarroUseCase.execute(carrosDtoConverter.toDomain(carrosDTO));
       return carrosDtoConverter.toDTO(carro);
    }

    @GetMapping("/{id}")
    public Optional<CarrosDTO> buscaPorId(@PathVariable Long id){
        Optional<Carros> carrosOptional = findByIdCarrosUseCase.findByIdCarros(id);
        if (carrosOptional.isPresent()){
            Carros carros = carrosOptional.get();
            CarrosDTO carrosDTO = carrosDtoConverter.toDTO(carros);
            return Optional.of(carrosDTO);
        }
        return Optional.empty();
    }
}
