package com.sistema.bancario.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "pessoa")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String nome;
    
    @Email
    @NotBlank
    private String email;
    
    @NotBlank
    private String senha;
    
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Orcamento> orcamentos;
    
    // Construtores
    public Pessoa() {}
    
    public Pessoa(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    // Métodos de negócio
    public void cadastrarUsuario() {
        // Lógica para cadastrar usuário
        System.out.println("Usuário cadastrado: " + this.nome);
    }
    
    public boolean autenticar(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }
    
    public void setOrcamentos(List<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    }
}
