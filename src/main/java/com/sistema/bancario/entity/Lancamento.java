package com.sistema.bancario.entity;

import com.sistema.bancario.enums.Situacao;
import com.sistema.bancario.enums.TipoLancamento;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "lancamento")
public class Lancamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String descricao;
    
    @Column(precision = 19, scale = 2)
    private BigDecimal valor;
    
    private String parcela;
    
    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;
    
    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;
    
    @Column(name = "data_baixa")
    private LocalDate dataBaixa;
    
    @Column(name = "valor_documento", precision = 19, scale = 2)
    private BigDecimal valorDocumento;
    
    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;
    
    @Enumerated(EnumType.STRING)
    private Situacao situacao;
    
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;
    
    // Construtores
    public Lancamento() {}
    
    public Lancamento(String descricao, BigDecimal valor, TipoLancamento tipo, Conta conta) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.conta = conta;
        this.dataLancamento = LocalDate.now();
        this.situacao = Situacao.ABERTO;
    }
    
    // Métodos de negócio
    public void registrar() {
        this.dataLancamento = LocalDate.now();
        this.situacao = Situacao.ABERTO;
        System.out.println("Lançamento registrado: " + this.descricao);
    }
    
    public void editar(String novaDescricao, BigDecimal novoValor) {
        this.descricao = novaDescricao;
        this.valor = novoValor;
        System.out.println("Lançamento editado: " + this.descricao);
    }
    
    public void excluir() {
        this.situacao = Situacao.FECHADO;
        System.out.println("Lançamento excluído: " + this.descricao);
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public BigDecimal getValor() {
        return valor;
    }
    
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    public String getParcela() {
        return parcela;
    }
    
    public void setParcela(String parcela) {
        this.parcela = parcela;
    }
    
    public LocalDate getDataLancamento() {
        return dataLancamento;
    }
    
    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    
    public LocalDate getDataVencimento() {
        return dataVencimento;
    }
    
    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    public LocalDate getDataBaixa() {
        return dataBaixa;
    }
    
    public void setDataBaixa(LocalDate dataBaixa) {
        this.dataBaixa = dataBaixa;
    }
    
    public BigDecimal getValorDocumento() {
        return valorDocumento;
    }
    
    public void setValorDocumento(BigDecimal valorDocumento) {
        this.valorDocumento = valorDocumento;
    }
    
    public TipoLancamento getTipo() {
        return tipo;
    }
    
    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }
    
    public Situacao getSituacao() {
        return situacao;
    }
    
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
    
    public Conta getConta() {
        return conta;
    }
    
    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
