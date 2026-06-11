package com.sus.controller;

import com.sus.model.Vacina;
import com.sus.service.SusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vacinas")
@CrossOrigin(origins = "*")
public class VacinaController {

    private final SusService susService;

    public VacinaController(SusService susService) {
        this.susService = susService;
    }

    // GET /api/vacinas  → lista todas as vacinas
    @GetMapping
    public ResponseEntity<List<Vacina>> getVacinas() {
        return ResponseEntity.ok(susService.getVacinas());
    }

    // GET /api/vacinas/resumo  → contagem por status
    @GetMapping("/resumo")
    public ResponseEntity<?> getResumo() {
        return ResponseEntity.ok(Map.of(
            "emDia",      susService.contarVacinasPorStatus(Vacina.Status.EM_DIA),
            "pendentes",  susService.contarVacinasPorStatus(Vacina.Status.PENDENTE),
            "incompletas",susService.contarVacinasPorStatus(Vacina.Status.INCOMPLETA)
        ));
    }
}
