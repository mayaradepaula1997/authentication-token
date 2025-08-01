package com.dev.autenticacao.entity.dto;

import java.time.LocalDate;

public record UpdateUser(String name, LocalDate dataNascomento) {
}
