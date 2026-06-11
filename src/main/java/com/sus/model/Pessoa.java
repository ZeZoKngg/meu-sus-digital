package com.sus.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// 1. ABSTRAÇÃO — Classe abstrata base do sistema SUS
@JsonIgnoreProperties({"resumo"})
public abstract class Pessoa {

    protected String nome;
    protected String cpf;
    protected String email;

    public Pessoa(String nome, String cpf, String email) {
        this.nome  = nome;
        this.cpf   = cpf;
        this.email = email;
    }

    // Métodos abstratos: cada subclasse deve implementar
    public abstract String getTipo();
    public abstract String getResumo();

    public String getNome()  { return nome; }
    public String getCpf()   { return cpf; }
    public String getEmail() { return email; }
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public String toString() {
        return "[" + getTipo() + "] " + nome + " | CPF: " + cpf;
    }
}
