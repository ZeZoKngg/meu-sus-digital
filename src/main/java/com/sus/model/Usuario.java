package com.sus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

// 2. HERANÇA — Usuario HERDA de Pessoa
public class Usuario extends Pessoa {

    private String numerocartaoSus;
    private String dataNascimento;
    private String municipioCadastro;
    private String unidadeSaude;

    @JsonIgnore
    private String senha;

    public Usuario(String nome, String cpf, String email,
                   String numerocartaoSus, String dataNascimento,
                   String municipioCadastro, String unidadeSaude, String senha) {
        super(nome, cpf, email);
        this.numerocartaoSus   = numerocartaoSus;
        this.dataNascimento    = dataNascimento;
        this.municipioCadastro = municipioCadastro;
        this.unidadeSaude      = unidadeSaude;
        this.senha             = senha;
    }

    // 5. SOBRESCRITA
    @Override
    public String getTipo() { return "Paciente"; }

    @Override
    public String getResumo() {
        return "Olá, " + nome + "! | Cartão SUS: " + numerocartaoSus;
    }

    // Valida login
    public boolean autenticar(String cpfDigitado, String senhaDigitada) {
        return this.cpf.replaceAll("[^0-9]", "")
                       .equals(cpfDigitado.replaceAll("[^0-9]", ""))
               && this.senha.equals(senhaDigitada);
    }

    // Getters
    public String getNumerocartaoSus()   { return numerocartaoSus; }
    public String getDataNascimento()    { return dataNascimento; }
    public String getMunicipioCadastro() { return municipioCadastro; }
    public String getUnidadeSaude()      { return unidadeSaude; }
}
