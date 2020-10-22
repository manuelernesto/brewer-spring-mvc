package io.github.manuelernesto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @RequestMapping("/novo")
    public ModelAndView novo() {
        return new ModelAndView("cliente/CadastroCliente");
    }
}
