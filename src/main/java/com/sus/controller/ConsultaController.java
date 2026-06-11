package com.sus.controller;

import com.sus.model.Consulta;
import com.sus.service.SusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/consultas")
@CrossOrigin(origins = "*")
public class ConsultaController {

    private final SusService susService;

    public ConsultaController(SusService susService) {
        this.susService = susService;
    }

    // GET /api/consultas  → todas as consultas agendadas
    @GetMapping
    public ResponseEntity<List<Consulta>> getConsultas() {
        return ResponseEntity.ok(susService.getConsultas());
    }

    // POST /api/consultas
    // Body: { "nomePaciente": "...", "data": "...", "especialidade": "...", "local": "..." (opcional) }
    @PostMapping
    public ResponseEntity<?> agendar(@RequestBody Map<String, String> body) {
        String nome      = body.get("nomePaciente");
        String data      = body.get("data");
        String espec     = body.get("especialidade");
        String local     = body.get("local"); // pode ser null

        if (nome == null || data == null || espec == null) {
            return ResponseEntity.badRequest().body(Map.of(
                "sucesso", false,
                "mensagem", "Campos obrigatórios: nomePaciente, data, especialidade"
            ));
        }

        // 4. SOBRECARGA — chama versão com ou sem local
        Consulta c = (local != null && !local.isBlank())
                ? susService.agendarConsulta(nome, data, espec, local)
                : susService.agendarConsulta(nome, data, espec);

        return ResponseEntity.ok(Map.of(
            "sucesso",  true,
            "mensagem", "Consulta agendada com sucesso!",
            "consulta", c
        ));
    }
}
