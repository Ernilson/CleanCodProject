package br.com.FormularioCadastro.infraEstrutura.persistence.pessoaEntity.repository;

import br.com.FormularioCadastro.infraEstrutura.persistence.pessoaEntity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {

	PessoaEntity findByCpfCnpj(String cpfCnpj);
}
