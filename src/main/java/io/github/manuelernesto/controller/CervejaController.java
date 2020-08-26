package io.github.manuelernesto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CervejaController {

    @RequestMapping("/cerveja/novo")
    public String novo() {
        return "cerveja/CadastroCerveja";
    }
}
