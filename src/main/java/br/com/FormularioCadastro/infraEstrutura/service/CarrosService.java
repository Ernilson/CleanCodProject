package br.com.FormularioCadastro.infraEstrutura.service;

import br.com.FormularioCadastro.core.domain.Carros;
import br.com.FormularioCadastro.core.gateways.CarroGateway;
import br.com.FormularioCadastro.infraEstrutura.mapper.CarrosMapper;
import br.com.FormularioCadastro.infraEstrutura.persistence.carrosEntity.CarrosEntity;
import br.com.FormularioCadastro.infraEstrutura.persistence.carrosEntity.repository.CarrosRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarrosService implements CarroGateway {
    private final CarrosRepository repository;
    private final CarrosMapper mapper;

    public CarrosService(CarrosRepository repository, CarrosMapper mapper ){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Carros createCarros(Carros carros) {
      CarrosEntity entity = mapper.toCarroEntity(carros);
      CarrosEntity novoCarro = repository.save(entity);
      return mapper.toCarros(novoCarro);
    }

    @Override
    public Optional<Carros> findById(Long id) {
        Optional<CarrosEntity> entityOptional = repository.findById(id);
        if (entityOptional.isPresent()){
            CarrosEntity entity = entityOptional.get();
            return Optional.of(mapper.toCarros(entity));
        }
        return Optional.empty();
    }
}
