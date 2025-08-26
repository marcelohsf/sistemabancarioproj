package com.sistema.bancario.controller;

import com.sistema.bancario.entity.Conta;
import com.sistema.bancario.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contas")
public class ContaController {
    
    @Autowired
    private ContaService contaService;
    
    @GetMapping
    public List<Conta> getAllContas() {
        return contaService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Conta> getContaById(@PathVariable Long id) {
        Optional<Conta> conta = contaService.findById(id);
        return conta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Conta createConta(@RequestBody Conta conta) {
        return contaService.save(conta);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Conta> updateConta(@PathVariable Long id, @RequestBody Conta conta) {
        if (contaService.findById(id).isPresent()) {
            conta.setId(id);
            return ResponseEntity.ok(contaService.save(conta));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConta(@PathVariable Long id) {
        if (contaService.findById(id).isPresent()) {
            contaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/usuario/{usuarioId}")
    public List<Conta> getContasByUsuario(@PathVariable Long usuarioId) {
        return contaService.findByUsuarioId(usuarioId);
    }
}
