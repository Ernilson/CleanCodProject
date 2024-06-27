package br.com.FormularioCadastro.infraEstrutura.dtos;

import br.com.FormularioCadastro.infraEstrutura.persistence.pessoaEntity.PessoaEntity;

public class CarrosDTO {

    private String nome;

    private String placa;

    private Long ano;

    private String cor;

    private Integer chassi;

    private PessoaEntity pessoaEntity;

    public CarrosDTO() {
    }

    public CarrosDTO(String nome, String placa, Long ano, String cor, Integer chassi, PessoaEntity pessoaEntity) {
        this.nome = nome;
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
        this.chassi = chassi;
        this.pessoaEntity = pessoaEntity;
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
