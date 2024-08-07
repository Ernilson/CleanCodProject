package br.com.FormularioCadastro.infraEstrutura.dtos;

import br.com.FormularioCadastro.core.enums.EnumTipoPessoa;

public class PessoaDTO {
    String nome;
    String email;
    String cpfCnpj;
    EnumTipoPessoa tipo;

    public PessoaDTO() {
    }

    public PessoaDTO(String nome, String email, String cpfCnpj, EnumTipoPessoa tipo) {
        this.nome = nome;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.tipo = tipo;
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
