package com.dev.autenticacao.repository;

import com.dev.autenticacao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserReposiroty  extends JpaRepository<User, Long>{


    Optional<User> findByCpf(String cpf);  // buscar um usuário onde o campo cpf seja igual ao valor passado
}
