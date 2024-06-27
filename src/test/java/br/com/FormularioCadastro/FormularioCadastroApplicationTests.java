package br.com.FormularioCadastro;

import br.com.FormularioCadastro.core.enums.EnumTipoPessoa;
import br.com.FormularioCadastro.infraEstrutura.persistence.carrosEntity.CarrosEntity;
import br.com.FormularioCadastro.infraEstrutura.persistence.carrosEntity.repository.CarrosRepository;
import br.com.FormularioCadastro.infraEstrutura.persistence.pessoaEntity.PessoaEntity;
import br.com.FormularioCadastro.infraEstrutura.persistence.pessoaEntity.repository.PessoaRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FormularioCadastroApplicationTests {

	@Autowired
	private PessoaRepository repository;

	@Autowired
	private CarrosRepository carrosRepository;

	@Test
	@Order(1)
	void contextLoads() {

		PessoaEntity entity = new PessoaEntity();
		entity.setNome("teste5");
		entity.setEmail("teste@teste.com");
		entity.setCpfCnpj("12345678910");
		entity.setTipo(EnumTipoPessoa.valueOf("FISICA"));

		repository.save(entity);
	}

	@Test
	@Order(2)
	void contextCarros() {
		var car = new CarrosEntity();
		int chassi = 123456789;
		PessoaEntity entity = new PessoaEntity();

		entity.setId(1);

		car.setNome("Chevet");
		car.setCor("azul Marinho");
		car.setAno(2025L);
		car.setChassi(chassi);
		car.setPlaca("2825ZL");
		car.setPessoaEntity(entity);

		carrosRepository.save(car);

	}


}
