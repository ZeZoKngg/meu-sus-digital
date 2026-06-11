package com.sus.model;

// 4. SOBRECARGA — Vacina tem 3 construtores e métodos getDescricaoStatus sobrecarregados
public class Vacina {

    public enum Status { EM_DIA, PENDENTE, INCOMPLETA }

    private String nome;
    private String ultimaDose;
    private Status status;
    private int    totalDoses;
    private int    dosesAplicadas;

    // 4. SOBRECARGA DE CONSTRUTORES

    // Construtor 1: vacina completa / em dia
    public Vacina(String nome, String ultimaDose) {
        this.nome           = nome;
        this.ultimaDose     = ultimaDose;
        this.status         = Status.EM_DIA;
        this.totalDoses     = 1;
        this.dosesAplicadas = 1;
    }

    // Construtor 2: vacina com status explícito
    public Vacina(String nome, String ultimaDose, Status status) {
        this.nome           = nome;
        this.ultimaDose     = ultimaDose;
        this.status         = status;
        this.totalDoses     = 1;
        this.dosesAplicadas = 0;
    }

    // Construtor 3: vacina com múltiplas doses
    public Vacina(String nome, String ultimaDose, int dosesAplicadas, int totalDoses) {
        this.nome           = nome;
        this.ultimaDose     = ultimaDose;
        this.dosesAplicadas = dosesAplicadas;
        this.totalDoses     = totalDoses;
        this.status         = dosesAplicadas >= totalDoses ? Status.EM_DIA : Status.INCOMPLETA;
    }

    // 4. SOBRECARGA — getDescricaoStatus
    public String getDescricaoStatus() {
        switch (status) {
            case EM_DIA:     return "Em dia";
            case PENDENTE:   return "Pendente";
            case INCOMPLETA: return dosesAplicadas + " de " + totalDoses + " doses aplicadas";
            default:         return "Desconhecido";
        }
    }

    public String getDescricaoStatus(boolean comEmoji) {
        String emoji = status == Status.EM_DIA ? "💉 " : status == Status.PENDENTE ? "⚠️ " : "⏳ ";
        return comEmoji ? emoji + getDescricaoStatus() : getDescricaoStatus();
    }

    // Getters
    public String getNome()            { return nome; }
    public String getUltimaDose()      { return ultimaDose; }
    public Status getStatus()          { return status; }
    public int    getTotalDoses()      { return totalDoses; }
    public int    getDosesAplicadas()  { return dosesAplicadas; }
}
