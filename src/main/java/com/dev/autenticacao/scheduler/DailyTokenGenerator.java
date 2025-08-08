package com.dev.autenticacao.scheduler;


import com.dev.autenticacao.entity.User;
import com.dev.autenticacao.repository.UserReposiroty;
import org.springframework.scheduling.annotation.Scheduled;
import security.JwtService;

import java.time.LocalDate;
import java.util.List;

//CLASSE QUE VAI GERAR O TOKEN AUTOMATICO TODO DIA AS OOHH
public class DailyTokenGenerator {

    private UserReposiroty userReposiroty;

    private JwtService jwtService;


    public DailyTokenGenerator(UserReposiroty userReposiroty, JwtService jwtService) {
        this.userReposiroty = userReposiroty;
        this.jwtService = jwtService;
    }

  //A anotação @Scheduled: agenda tarfas para serem executadas automaticamnete
    @Scheduled(cron = "0 0 0 * * * ")
    public void generateDailyTokens(){
        List<User> users = userReposiroty.findAll();
        // percorre a lista de usuário no banco e atualiza o token todos os dias as meia noite
        for (User user: users){

            //para cada usuario do meu BD, vou chamar o serviço que gera o token, passamndo o CPF do usuario
            String token =  jwtService.generateToken(user.getCpf());

            user.setDailyToken(token); // vai setar uma novo token
            user.setDataToken(LocalDate.now()); //uma nova data, que é a data atual
            user.setTokenUsado(false); // e muda o "token usado" para false

            userReposiroty.save(user);

        }

    }


}
