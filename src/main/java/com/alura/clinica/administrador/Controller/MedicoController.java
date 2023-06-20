package com.alura.clinica.administrador.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicoController {

    @GetMapping("/welcome")
    String welcome(){
        return "Hello world from Spring Boot!";
    }
}
