package com.sistema.bancario.controller;

import com.sistema.bancario.entity.Lancamento;
import com.sistema.bancario.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoController {
    
    @Autowired
    private LancamentoService lancamentoService;
    
    @GetMapping
    public List<Lancamento> getAllLancamentos() {
        return lancamentoService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> getLancamentoById(@PathVariable Long id) {
        Optional<Lancamento> lancamento = lancamentoService.findById(id);
        return lancamento.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Lancamento createLancamento(@RequestBody Lancamento lancamento) {
        return lancamentoService.save(lancamento);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Lancamento> updateLancamento(@PathVariable Long id, @RequestBody Lancamento lancamento) {
        if (lancamentoService.findById(id).isPresent()) {
            lancamento.setId(id);
            return ResponseEntity.ok(lancamentoService.save(lancamento));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLancamento(@PathVariable Long id) {
        lancamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/conta/{contaId}")
    public List<Lancamento> getLancamentosByConta(@PathVariable Long contaId) {
        return lancamentoService.findByContaId(contaId);
    }
}
