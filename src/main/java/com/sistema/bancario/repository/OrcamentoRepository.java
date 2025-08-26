package com.sistema.bancario.repository;

import com.sistema.bancario.entity.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
    List<Orcamento> findByPessoaId(Long pessoaId);
    List<Orcamento> findByContaId(Long contaId);
    List<Orcamento> findByMes(Integer mes);
}
