package com.sistema.bancario.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Column(name = "razao_social")
    private String razaoSocial;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Conta> contas;
    
    // Construtores
    public Usuario() {}
    
    public Usuario(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getRazaoSocial() {
        return razaoSocial;
    }
    
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    public List<Conta> getContas() {
        return contas;
    }
    
    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
