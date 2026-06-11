package com.sus.model;

// 2. HERANÇA — PostoDeSaude HERDA de Pessoa
public class PostoDeSaude extends Pessoa {

    private String  endereco;
    private String  horario;
    private String  telefone;
    private String  tipo;
    private boolean aberto24h;

    public PostoDeSaude(String nome, String cnpj, String email,
                        String endereco, String horario,
                        String telefone, String tipo, boolean aberto24h) {
        super(nome, cnpj, email);
        this.endereco  = endereco;
        this.horario   = horario;
        this.telefone  = telefone;
        this.tipo      = tipo;
        this.aberto24h = aberto24h;
    }

    // 5. SOBRESCRITA
    @Override
    public String getTipo() { return tipo; }

    @Override
    public String getResumo() {
        return nome + " | " + endereco + " | " + (aberto24h ? "24 horas" : horario);
    }

    public String getStatusBadge() {
        return aberto24h ? "24 horas" : "Aberto agora";
    }

    // Getters
    public String  getEndereco()  { return endereco; }
    public String  getHorario()   { return horario; }
    public String  getTelefone()  { return telefone; }
    public boolean isAberto24h()  { return aberto24h; }
}
