package com.sus.controller;

import com.sus.model.Usuario;
import com.sus.service.SusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final SusService susService;

    public AuthController(SusService susService) {
        this.susService = susService;
    }

    // POST /api/auth/login  { "cpf": "...", "senha": "..." }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String cpf   = body.getOrDefault("cpf", "");
        String senha = body.getOrDefault("senha", "");

        boolean ok = susService.fazerLogin(cpf, senha);
        if (ok) {
            Usuario u = susService.getUsuarioLogado();
            return ResponseEntity.ok(Map.of(
                "sucesso", true,
                "mensagem", "Login realizado com sucesso!",
                "usuario", u
            ));
        } else {
            return ResponseEntity.status(401).body(Map.of(
                "sucesso", false,
                "mensagem", "CPF ou senha inválidos"
            ));
        }
    }

    // POST /api/auth/logout
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        susService.fazerLogout();
        return ResponseEntity.ok(Map.of("sucesso", true, "mensagem", "Sessão encerrada"));
    }

    // GET /api/auth/usuario
    @GetMapping("/usuario")
    public ResponseEntity<?> getUsuario() {
        Usuario u = susService.getUsuarioLogado();
        if (u == null)
            return ResponseEntity.status(401).body(Map.of("mensagem", "Nenhum usuário logado"));
        return ResponseEntity.ok(u);
    }

    // GET /api/auth/cartao
    @GetMapping("/cartao")
    public ResponseEntity<?> getCartao() {
        Usuario u = susService.getUsuarioLogado();
        if (u == null)
            return ResponseEntity.status(401).body(Map.of("mensagem", "Nenhum usuário logado"));
        return ResponseEntity.ok(Map.of(
            "nome",              u.getNome(),
            "numerocartaoSus",   u.getNumerocartaoSus(),
            "dataNascimento",    u.getDataNascimento(),
            "municipioCadastro", u.getMunicipioCadastro(),
            "unidadeSaude",      u.getUnidadeSaude(),
            "cpf",               u.getCpf()
        ));
    }
}
