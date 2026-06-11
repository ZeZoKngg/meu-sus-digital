package com.sus.service;

import com.sus.model.*;
import java.util.List;

// 3. POLIMORFISMO — Interface define o contrato do sistema
public interface SusService {

    boolean  fazerLogin(String cpf, String senha);
    Usuario  getUsuarioLogado();
    void     fazerLogout();

    String   getNumeroCartaoSus();
    String   getDadosCartao();

    List<Vacina>       getVacinas();
    long               contarVacinasPorStatus(Vacina.Status status);

    List<PostoDeSaude> getPostos();
    List<PostoDeSaude> buscarPostos(String termo);
    PostoDeSaude       selecionarPosto(String nome);

    Consulta           agendarConsulta(String nomePaciente, String data, String especialidade);
    Consulta           agendarConsulta(String nomePaciente, String data, String especialidade, String local);
    List<Consulta>     getConsultas();
}
