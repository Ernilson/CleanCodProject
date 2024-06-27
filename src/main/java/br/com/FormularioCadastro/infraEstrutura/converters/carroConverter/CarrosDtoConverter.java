//package br.com.FormularioCadastro.infraEstrutura.converters.carroConverter;
//
//import br.com.FormularioCadastro.core.domain.Carros;
//import br.com.FormularioCadastro.infraEstrutura.dtos.CarrosDTO;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CarrosDtoConverter {
//
//    public CarrosDTO toDTO(Carros carros){
//        return new CarrosDTO(carros.getNome(), carros.getPlaca(), carros.getAno(), carros.getCor(), carros.getChassi());
//    }
//
//    public Carros toDomain(CarrosDTO carrosDTO){
//        return new Carros(null, carrosDTO.getNome(), carrosDTO.getCor(), carrosDTO.getAno(), carrosDTO.getPlaca(), carrosDTO.getChassi());
//    }
//
//}
