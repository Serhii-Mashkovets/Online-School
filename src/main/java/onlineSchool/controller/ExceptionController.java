package onlineSchool.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    // Створений клас чисто для перевірки механізму обробки винятків

    @GetMapping("/exception")
    public String exception() throws Exception {
        throw new Exception("Test exception");
    }
}

