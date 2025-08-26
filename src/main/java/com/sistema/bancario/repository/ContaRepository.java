package com.sistema.bancario.repository;

import com.sistema.bancario.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    List<Conta> findByUsuarioId(Long usuarioId);
    List<Conta> findByBancoId(Long bancoId);
}
