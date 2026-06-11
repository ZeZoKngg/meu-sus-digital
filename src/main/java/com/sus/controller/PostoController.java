package com.sus.controller;

import com.sus.model.PostoDeSaude;
import com.sus.service.SusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postos")
@CrossOrigin(origins = "*")
public class PostoController {

    private final SusService susService;

    public PostoController(SusService susService) {
        this.susService = susService;
    }

    // GET /api/postos             → todos os postos
    // GET /api/postos?busca=ubs   → filtro por nome/endereço
    @GetMapping
    public ResponseEntity<List<PostoDeSaude>> getPostos(
            @RequestParam(required = false) String busca) {
        List<PostoDeSaude> result = (busca != null && !busca.isBlank())
                ? susService.buscarPostos(busca)
                : susService.getPostos();
        return ResponseEntity.ok(result);
    }

    // GET /api/postos/{nome}  → detalhes de um posto específico
    @GetMapping("/{nome}")
    public ResponseEntity<?> getPostoByNome(@PathVariable String nome) {
        try {
            PostoDeSaude posto = susService.selecionarPosto(nome);
            return ResponseEntity.ok(posto);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Posto não encontrado: " + nome);
        }
    }
}
