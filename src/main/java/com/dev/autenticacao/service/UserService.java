package com.dev.autenticacao.service;


import com.dev.autenticacao.entity.User;
import com.dev.autenticacao.entity.dto.CreateUser;
import com.dev.autenticacao.entity.dto.UpdateUser;
import com.dev.autenticacao.exception.RecursoNaoEncontrado;
import com.dev.autenticacao.repository.UserReposiroty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private UserReposiroty userReposiroty;

    public UserService(UserReposiroty userReposiroty) {
        this.userReposiroty = userReposiroty;
    }


    public User create(CreateUser createUser) {

        User user = new User();

        user.setName(createUser.name());
        user.setCpf(createUser.cpf());
        user.setDataNascimento(createUser.dataNascimento());

        return userReposiroty.save(user);
    }


    public List<User> userList() {

        return userReposiroty.findAll();
    }


    public Optional<User> findById(Long id) {

        return userReposiroty.findById(id);

    }

    public User update(Long id, UpdateUser updateUser) {

        Optional<User> optionalUser = userReposiroty.findById(id);

        if (optionalUser.isPresent()) {

            User user = optionalUser.get();  //Recupera o usuario existente

            user.setName(updateUser.name());
            user.setDataNascimento(updateUser.dataNascomento());

            return userReposiroty.save(user); //salva o mesmo objeto com os dados atualizados

        } else {

            throw new RecursoNaoEncontrado("Usuario não encontrado");
        }
    }

    public void delete(Long id) {

        Optional<User> optionalUser = userReposiroty.findById(id);

        if (optionalUser.isPresent()) {

            userReposiroty.deleteById(id);

        }else {

            throw new RecursoNaoEncontrado("Usuario não encontrado");
        }

    }
}