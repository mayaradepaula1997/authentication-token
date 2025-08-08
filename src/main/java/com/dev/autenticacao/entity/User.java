package com.dev.autenticacao.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String cpf;

    private LocalDate dataNascimento;

    private boolean tokenUsado;

    //PARTE DO TOKEN DIÁRIO

    private String dailyToken;

    private LocalDate dataToken;




    public User(){  //construtor vazio

    }

    public User(Long id, String name, String cpf, LocalDate dataNascimento, boolean tokenUsado) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.tokenUsado = tokenUsado;
    }

    public Long getId() {     // não temos o setter do id
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isTokenUsado() {
        return tokenUsado;
    }

    public void setTokenUsado(boolean tokenUsado) {
        this.tokenUsado = tokenUsado;
    }

    public String getDailyToken() {
        return dailyToken;
    }

    public void setDailyToken(String dailyToken) {
        this.dailyToken = dailyToken;
    }

    public LocalDate getDataToken() {
        return dataToken;
    }

    public void setDataToken(LocalDate dataToken) {
        this.dataToken = dataToken;
    }
}
