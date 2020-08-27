package io.github.manuelernesto.controller;

import io.github.manuelernesto.Model.Cerveja;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class CervejaController {

    @RequestMapping("/cerveja/novo")
    public String novo() {
        return "cerveja/CadastroCerveja";
    }

    @RequestMapping(value = "/cerveja/novo", method = RequestMethod.POST)
    public String cadastrar(@Valid Cerveja cerveja, BindingResult result) {
        if (result.hasErrors()) {
            //TODO
        }

        return "cerveja/CadastroCerveja";
    }
}













