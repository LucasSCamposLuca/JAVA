package com.example.ProjetoSenai.Atividades;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//localhost:8080/helo

@RestController
public class HelloWorlds {
    @GetMapping("/helo")
    public  String HelloWorld(){
            return "Hello World!";
    }
}
