//package br.com.FormularioCadastro.infraEstrutura.converters.carroConverter;
//
//import br.com.FormularioCadastro.core.domain.Carros;
//import br.com.FormularioCadastro.core.domain.Pessoa;
//import br.com.FormularioCadastro.infraEstrutura.persistence.carrosEntity.CarrosEntity;
//import br.com.FormularioCadastro.infraEstrutura.persistence.pessoaEntity.PessoaEntity;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CarroEntityConverter {
//
//    public CarrosEntity DomainToEntity(Carros carros){
//        return new CarrosEntity(carros.getId(), carros.getNome(), carros.getPlaca(), carros.getAno(), carros.getCor(), carros.getChassi(), new PessoaEntity());
//    }
//
//    public Carros EntityToDomain(CarrosEntity entity){
//        return new Carros(entity.getId(), entity.getNome(), entity.getPlaca(), entity.getAno(), entity.getCor(), entity.getChassi(), entity.getPessoaEntity());
//    }
//}
