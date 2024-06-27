package br.com.FormularioCadastro.core.domain;

import br.com.FormularioCadastro.infraEstrutura.persistence.pessoaEntity.PessoaEntity;

public class Carros {

    private Long id;
    private String nome;

    private String placa;

    private Long ano;

    private String cor;

    private Integer chassi;

    private Pessoa pessoa;

    public Carros(Long id, String nome, String placa, Long ano, String cor, Integer chassi, PessoaEntity pessoaEntity) {
    }

    public Carros(Long id, String nome, String placa, Long ano, String cor, Integer chassi) {
        this.id = id;
        this.nome = nome;
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
        this.chassi = chassi;
        this.pessoa = pessoa;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
