package com.sistema.bancario.service;

import com.sistema.bancario.entity.Lancamento;
import com.sistema.bancario.enums.TipoLancamento;
import com.sistema.bancario.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {
    
    @Autowired
    private LancamentoRepository lancamentoRepository;
    
    @Autowired
    private ContaService contaService;
    
    public List<Lancamento> findAll() {
        return lancamentoRepository.findAll();
    }
    
    public Optional<Lancamento> findById(Long id) {
        return lancamentoRepository.findById(id);
    }
    
    public Lancamento save(Lancamento lancamento) {
        lancamento.registrar();
        Lancamento savedLancamento = lancamentoRepository.save(lancamento);
        
        // Atualizar saldo da conta
        if (lancamento.getTipo() == TipoLancamento.CREDITO) {
            contaService.adicionarSaldo(lancamento.getConta().getId(), lancamento.getValor());
        } else if (lancamento.getTipo() == TipoLancamento.DEBITO) {
            contaService.removerSaldo(lancamento.getConta().getId(), lancamento.getValor());
        }
        
        return savedLancamento;
    }
    
    public void deleteById(Long id) {
        Optional<Lancamento> lancamentoOpt = lancamentoRepository.findById(id);
        if (lancamentoOpt.isPresent()) {
            Lancamento lancamento = lancamentoOpt.get();
            lancamento.excluir();
            lancamentoRepository.save(lancamento);
        }
    }
    
    public List<Lancamento> findByContaId(Long contaId) {
        return lancamentoRepository.findByContaId(contaId);
    }
}
