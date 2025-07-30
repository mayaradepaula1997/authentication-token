package com.dev.autenticacao;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;

    private Date dataNascimento;


    public User(){  //construtor vazio

    }


    public User(Long id, String name, String cpf, Date dataNascimento) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {               //não temos o sette id.
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
