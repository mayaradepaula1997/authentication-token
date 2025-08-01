package com.dev.autenticacao.entity.dto;

import java.time.LocalDate;

public record CreateUser(String name, String cpf, LocalDate dataNascimento) {
}
