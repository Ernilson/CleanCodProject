package br.com.FormularioCadastro.infraEstrutura.service;

import br.com.FormularioCadastro.core.domain.Carros;
import br.com.FormularioCadastro.core.gateways.CarroGateway;
import br.com.FormularioCadastro.infraEstrutura.converters.carroConverter.CarroEntityConverter;
import br.com.FormularioCadastro.infraEstrutura.persistence.carrosEntity.CarrosEntity;
import br.com.FormularioCadastro.infraEstrutura.persistence.carrosEntity.repository.CarrosRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarrosService implements CarroGateway {
    private final CarrosRepository repository;
    private final CarroEntityConverter carroEntityConverter;

    public CarrosService(CarrosRepository repository, CarroEntityConverter carroEntityConverter ){
        this.repository = repository;
        this.carroEntityConverter = carroEntityConverter;
    }

    @Override
    public Carros createCarros(Carros carros) {
      CarrosEntity entity = carroEntityConverter.DomainToEntity(carros);
      CarrosEntity novoCarro = repository.save(entity);
      return carroEntityConverter.EntityToDomain(novoCarro);
    }

    @Override
    public Optional<Carros> findById(Long id) {
        Optional<CarrosEntity> entityOptional = repository.findById(id);
        if (entityOptional.isPresent()){
            CarrosEntity entity = entityOptional.get();
            return Optional.of(carroEntityConverter.EntityToDomain(entity));
        }
        return Optional.empty();
    }
}
