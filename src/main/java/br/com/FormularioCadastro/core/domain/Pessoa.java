package br.com.FormularioCadastro.core.domain;

import br.com.FormularioCadastro.core.enums.EnumTipoPessoa;

public class Pessoa {
    private Long id;
    private String nome;
    private String email;
    private String cpfCnpj;
    private EnumTipoPessoa tipo;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String email, String cpfCnpj, EnumTipoPessoa tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.tipo = tipo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public EnumTipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoPessoa tipo) {
        this.tipo = tipo;
    }
}

