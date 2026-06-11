package com.sus.service;

import com.sus.model.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

// 3. POLIMORFISMO — Implementação concreta da interface SusService
@Service
public class SusServiceImpl implements SusService {

    private Usuario              usuarioLogado        = null;
    private PostoDeSaude         postoSelecionado     = null;
    private List<Vacina>         vacinas              = new ArrayList<>();
    private List<PostoDeSaude>   postos               = new ArrayList<>();
    private List<Consulta>       consultas            = new ArrayList<>();
    private Map<String, Usuario> usuariosCadastrados  = new HashMap<>();

    public SusServiceImpl() {
        carregarUsuarios();
        carregarVacinas();
        carregarPostos();
    }

    private void carregarUsuarios() {
        Usuario joao = new Usuario(
            "João da Silva", "123.456.789-09", "joao@email.com",
            "123 4567 8912 3456", "15/08/1990",
            "São Paulo – SP", "UBS Central – Zona Leste", "senha123"
        );
        usuariosCadastrados.put(joao.getCpf().replaceAll("[^0-9]", ""), joao);
    }

    private void carregarVacinas() {
        // 4. SOBRECARGA — 3 construtores diferentes
        vacinas.add(new Vacina("COVID-19", "12/03/2024"));
        vacinas.add(new Vacina("Febre Amarela", "Recomendado atualizar", Vacina.Status.PENDENTE));
        vacinas.add(new Vacina("Influenza", "20/04/2025"));
        vacinas.add(new Vacina("Hepatite B", "01/01/2024", 2, 3));
    }

    private void carregarPostos() {
        postos.add(new PostoDeSaude(
            "UBS Central", "00.000.001/0001-00", "ubs.central@sp.gov.br",
            "Rua das Flores, 123 – Centro", "Seg–Sex 07h–17h",
            "(11) 3000-0001", "UBS", false
        ));
        postos.add(new PostoDeSaude(
            "Clínica Santa Vida", "00.000.002/0001-00", "santavida@sp.gov.br",
            "Av. Paulista, 456 – Bela Vista", "Seg–Sáb 06h–22h",
            "(11) 3000-0002", "Clínica", false
        ));
        postos.add(new PostoDeSaude(
            "UPA 24h Norte", "00.000.003/0001-00", "upa.norte@sp.gov.br",
            "Rua dos Pinheiros, 789 – Pinheiros", "24 horas / 7 dias",
            "(11) 3000-0003", "UPA", true
        ));
    }

    @Override
    public boolean fazerLogin(String cpf, String senha) {
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");
        Usuario u = usuariosCadastrados.get(cpfLimpo);
        if (u != null && u.autenticar(cpf, senha)) {
            usuarioLogado = u;
            return true;
        }
        return false;
    }

    @Override public Usuario  getUsuarioLogado()  { return usuarioLogado; }
    @Override public void     fazerLogout()       { usuarioLogado = null; postoSelecionado = null; }

    @Override
    public String getNumeroCartaoSus() {
        return usuarioLogado != null ? usuarioLogado.getNumerocartaoSus() : "—";
    }

    @Override
    public String getDadosCartao() {
        if (usuarioLogado == null) return "Nenhum usuário logado.";
        return usuarioLogado.getNome() + " | " + usuarioLogado.getNumerocartaoSus();
    }

    @Override public List<Vacina>       getVacinas() { return vacinas; }
    @Override
    public long contarVacinasPorStatus(Vacina.Status status) {
        return vacinas.stream().filter(v -> v.getStatus() == status).count();
    }

    @Override public List<PostoDeSaude> getPostos()  { return postos; }
    @Override
    public List<PostoDeSaude> buscarPostos(String termo) {
        if (termo == null || termo.isBlank()) return postos;
        String t = termo.toLowerCase();
        return postos.stream()
                .filter(p -> p.getNome().toLowerCase().contains(t)
                          || p.getEndereco().toLowerCase().contains(t))
                .collect(Collectors.toList());
    }

    @Override
    public PostoDeSaude selecionarPosto(String nome) {
        postoSelecionado = postos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Posto não encontrado: " + nome));
        return postoSelecionado;
    }

    // 4. SOBRECARGA — agendarConsulta com e sem local
    @Override
    public Consulta agendarConsulta(String nomePaciente, String data, String especialidade) {
        Consulta c = new Consulta(nomePaciente, data, especialidade);
        consultas.add(c);
        return c;
    }

    @Override
    public Consulta agendarConsulta(String nomePaciente, String data,
                                    String especialidade, String local) {
        Consulta c = new Consulta(nomePaciente, data, especialidade, local);
        consultas.add(c);
        return c;
    }

    @Override public List<Consulta> getConsultas() { return consultas; }
    public PostoDeSaude getPostoSelecionado()       { return postoSelecionado; }
}
