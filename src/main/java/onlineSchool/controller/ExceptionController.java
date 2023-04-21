package onlineSchool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionController {

    // Створений клас чисто для перевірки механізму обробки винятків

    @GetMapping("/exception")
    public String exception() throws Exception {
        throw new Exception("Test exception");
    }
}

