package security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class JwtService {

   //Essa chave serve para assinar o token, validade se foi no programa que gerou ele
    //static = não precisa instanciar     final= variavel não pode ser alterado, ela tem esse valor até o final
    private static final String SECRET_KEY = "sua-chave=secreta";

//Esse método gera o token
    public String generateToken (String cpf){

        return Jwts.builder() //inicia a construção do token
                .setSubject(cpf) //define o assunto do token, que nesse caso é o cpf
                .setIssuedAt(new Date()) //data de emissão do token, now/agora
                .setExpiration(Date.from(LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.ES256,SECRET_KEY) //assina o token
                .compact(); //token gerado

    }
//Método para extrais o cpf
    public String extractCpf(String token){

        return Jwts.parser() //inicia um parser(analisador)
                .setSigningKey(SECRET_KEY)//define a chave secret que foi usada para assinar o token
                .parseClaimsJws(token) //analisa o token e descodifica o token
                .getBody() //Pega todos os dados do token  e retorno o conteudo do token
                .getSubject(); //acessa apenas o valor do campo "sub", que nessse caso é o cpf

    }


}
