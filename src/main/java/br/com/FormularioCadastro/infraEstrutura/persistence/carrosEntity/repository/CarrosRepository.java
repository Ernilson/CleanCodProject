package br.com.FormularioCadastro.infraEstrutura.persistence.carrosEntity.repository;

import br.com.FormularioCadastro.infraEstrutura.persistence.carrosEntity.CarrosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrosRepository extends JpaRepository<CarrosEntity, Long> {
}
