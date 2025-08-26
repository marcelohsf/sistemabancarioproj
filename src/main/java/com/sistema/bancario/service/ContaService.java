package com.sistema.bancario.service;

import com.sistema.bancario.entity.Conta;
import com.sistema.bancario.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    
    @Autowired
    private ContaRepository contaRepository;
    
    public List<Conta> findAll() {
        return contaRepository.findAll();
    }
    
    public Optional<Conta> findById(Long id) {
        return contaRepository.findById(id);
    }
    
    public Conta save(Conta conta) {
        return contaRepository.save(conta);
    }
    
    public void deleteById(Long id) {
        contaRepository.deleteById(id);
    }
    
    public List<Conta> findByUsuarioId(Long usuarioId) {
        return contaRepository.findByUsuarioId(usuarioId);
    }
    
    public void adicionarSaldo(Long contaId, BigDecimal valor) {
        Optional<Conta> contaOpt = contaRepository.findById(contaId);
        if (contaOpt.isPresent()) {
            Conta conta = contaOpt.get();
            conta.adicionarSaldo(valor);
            contaRepository.save(conta);
        }
    }
    
    public void removerSaldo(Long contaId, BigDecimal valor) {
        Optional<Conta> contaOpt = contaRepository.findById(contaId);
        if (contaOpt.isPresent()) {
            Conta conta = contaOpt.get();
            conta.removerSaldo(valor);
            contaRepository.save(conta);
        }
    }
}
