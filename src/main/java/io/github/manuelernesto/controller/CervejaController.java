package io.github.manuelernesto.controller;

import io.github.manuelernesto.Model.Cerveja;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CervejaController {

    @RequestMapping("/cerveja/novo")
    public String novo() {
        return "cerveja/CadastroCerveja";
    }

    @RequestMapping(value = "/cerveja/novo", method = RequestMethod.POST)
    public String cadastrar(Cerveja cerveja) {
        return "cerveja/CadastroCerveja";
    }
}













