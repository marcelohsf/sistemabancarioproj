package com.sistema.bancario.entity;

import com.sistema.bancario.enums.TipoConta;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "conta")
public class Conta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(precision = 19, scale = 2)
    private BigDecimal saldo = BigDecimal.ZERO;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_conta")
    private TipoConta tipoConta;
    
    @ManyToOne
    @JoinColumn(name = "banco_id")
    private Banco banco;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
    private List<Lancamento> lancamentos;
    
    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
    private List<Orcamento> orcamentos;
    
    // Construtores
    public Conta() {}
    
    public Conta(TipoConta tipoConta, Banco banco, Usuario usuario) {
        this.tipoConta = tipoConta;
        this.banco = banco;
        this.usuario = usuario;
    }
    
    // Métodos de negócio
    public void adicionarSaldo(BigDecimal valor) {
        if (valor != null && valor.compareTo(BigDecimal.ZERO) > 0) {
            this.saldo = this.saldo.add(valor);
        }
    }
    
    public void removerSaldo(BigDecimal valor) {
        if (valor != null && valor.compareTo(BigDecimal.ZERO) > 0 && 
            this.saldo.compareTo(valor) >= 0) {
            this.saldo = this.saldo.subtract(valor);
        }
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public BigDecimal getSaldo() {
        return saldo;
    }
    
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    
    public TipoConta getTipoConta() {
        return tipoConta;
    }
    
    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }
    
    public Banco getBanco() {
        return banco;
    }
    
    public void setBanco(Banco banco) {
        this.banco = banco;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }
    
    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }
    
    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }
    
    public void setOrcamentos(List<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    }
}
