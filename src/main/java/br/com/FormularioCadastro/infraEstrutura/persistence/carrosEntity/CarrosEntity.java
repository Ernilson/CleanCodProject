package br.com.FormularioCadastro.infraEstrutura.persistence.carrosEntity;

import br.com.FormularioCadastro.core.domain.Pessoa;
import br.com.FormularioCadastro.infraEstrutura.persistence.pessoaEntity.PessoaEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_carros")
public class CarrosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String placa;

    private Long ano;

    private String cor;

    private Integer chassi;

    @ManyToOne
    private PessoaEntity pessoaEntity;

    public CarrosEntity() {
    }

    public CarrosEntity(Long id, String nome, String placa, Long ano, String cor, Integer chassi, PessoaEntity pessoaEntity) {
        this.id = id;
        this.nome = nome;
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
        this.chassi = chassi;
        this.pessoaEntity = pessoaEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getChassi() {
        return chassi;
    }

    public void setChassi(Integer chassi) {
        this.chassi = chassi;
    }

    public PessoaEntity getPessoaEntity() {
        return pessoaEntity;
    }

    public void setPessoaEntity(PessoaEntity pessoaEntity) {
        this.pessoaEntity = pessoaEntity;
    }
}