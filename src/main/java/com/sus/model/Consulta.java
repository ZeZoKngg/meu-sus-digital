package com.sus.model;

// 4. SOBRECARGA — Consulta tem 3 construtores e métodos getDetalhes sobrecarregados
public class Consulta {

    private String nomePaciente;
    private String data;
    private String especialidade;
    private String localAtendimento;
    private String status;

    // Construtor 1: agendamento direto (sem posto)
    public Consulta(String nomePaciente, String data, String especialidade) {
        this.nomePaciente    = nomePaciente;
        this.data            = data;
        this.especialidade   = especialidade;
        this.localAtendimento = "A definir";
        this.status          = "Agendada";
    }

    // Construtor 2: agendamento via posto selecionado
    public Consulta(String nomePaciente, String data, String especialidade, String local) {
        this.nomePaciente    = nomePaciente;
        this.data            = data;
        this.especialidade   = especialidade;
        this.localAtendimento = local;
        this.status          = "Agendada";
    }

    // Construtor 3: agendamento completo com status
    public Consulta(String nomePaciente, String data, String especialidade,
                    String local, String status) {
        this.nomePaciente    = nomePaciente;
        this.data            = data;
        this.especialidade   = especialidade;
        this.localAtendimento = local;
        this.status          = status;
    }

    public void cancelar() { this.status = "Cancelada"; }
    public void concluir() { this.status = "Realizada"; }

    // Getters
    public String getNomePaciente()     { return nomePaciente; }
    public String getData()             { return data; }
    public String getEspecialidade()    { return especialidade; }
    public String getLocalAtendimento() { return localAtendimento; }
    public String getStatus()           { return status; }
}
