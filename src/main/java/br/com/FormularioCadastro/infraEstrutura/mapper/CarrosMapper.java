package br.com.FormularioCadastro.infraEstrutura.mapper;


import br.com.FormularioCadastro.core.domain.Carros;
import br.com.FormularioCadastro.infraEstrutura.dtos.CarrosDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarrosMapper {

    private final ModelMapper mapper;

    public CarrosMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Carros toCarros(CarrosDTO dto) {
        return mapper.map(dto, Carros.class);
    }

    public CarrosDTO toCarrosDTO(Carros carros){
        return mapper.map(carros, CarrosDTO.class);
    }

    public List<CarrosDTO> pessoaDTOSList(List<Carros> carrosList){
        return carrosList.stream()
                .map(this::toCarrosDTO)
                .collect(Collectors.toList());
    }
}
