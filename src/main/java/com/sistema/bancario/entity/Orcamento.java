package com.sistema.bancario.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orcamento")
public class Orcamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "valor_limite", precision = 19, scale = 2)
    private BigDecimal valorLimite;
    
    private Integer mes;
    
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;
    
    // Construtores
    public Orcamento() {}
    
    public Orcamento(BigDecimal valorLimite, Integer mes, Pessoa pessoa, Conta conta) {
        this.valorLimite = valorLimite;
        this.mes = mes;
        this.pessoa = pessoa;
        this.conta = conta;
    }
    
    // Método de negócio
    public boolean verificarLimite(BigDecimal valorGasto) {
        if (valorLimite == null || valorGasto == null) {
            return false;
        }
        return valorGasto.compareTo(valorLimite) <= 0;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public BigDecimal getValorLimite() {
        return valorLimite;
    }
    
    public void setValorLimite(BigDecimal valorLimite) {
        this.valorLimite = valorLimite;
    }
    
    public Integer getMes() {
        return mes;
    }
    
    public void setMes(Integer mes) {
        this.mes = mes;
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public Conta getConta() {
        return conta;
    }
    
    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
