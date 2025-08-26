package com.sistema.bancario.repository;

import com.sistema.bancario.entity.Lancamento;
import com.sistema.bancario.enums.Situacao;
import com.sistema.bancario.enums.TipoLancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
    List<Lancamento> findByContaId(Long contaId);
    List<Lancamento> findByTipo(TipoLancamento tipo);
    List<Lancamento> findBySituacao(Situacao situacao);
    List<Lancamento> findByContaIdAndSituacao(Long contaId, Situacao situacao);
}
