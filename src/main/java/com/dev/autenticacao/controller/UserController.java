package com.dev.autenticacao.controller;


import com.dev.autenticacao.entity.User;
import com.dev.autenticacao.entity.dto.CreateUser;
import com.dev.autenticacao.entity.dto.UpdateUser;
import com.dev.autenticacao.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<User> create(@RequestBody CreateUser createUser){

        User user = userService.create(createUser);

        return ResponseEntity.ok(user);  //O método "create" retorna um objeto User, que é atribuído à variável user
    }


    @GetMapping
    public ResponseEntity<List<User>> findAll(){ // retorna uma lista de usuarios

        List<User> userList = userService.userList(); //Vai buscar o usuario e retorna uma lista dele

        return ResponseEntity.ok().body(userList);


    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        if ( id == null || id <= 0){

            return ResponseEntity.badRequest().build();
        }

        Optional<User> optionalUser = userService.findById(id);

        if (optionalUser.isEmpty()){ //Ausência do usuário

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }

        return ResponseEntity.ok(optionalUser.get()); //Retorna o valor contido dentro do Optional, se ele estiver presente
    }



    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UpdateUser updateUser){

        if ( id == null || id <= 0){

            return ResponseEntity.badRequest().build();
        }

        Optional<User> userOptional = userService.findById(id);

        if (userOptional.isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }

        User user = userService.update(id, updateUser); // Se o usuário existe, chama o método update no service,
                                                        // passando o id e os dados atualizados.

        return ResponseEntity.ok(user);

    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){

        if ( id == null || id <= 0){

            return ResponseEntity.badRequest().build();
        }

        Optional<User> userOptional = userService.findById(id);

        if (userOptional.isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }

        userService.delete(id);

        return ResponseEntity.noContent().build();

    }
}
