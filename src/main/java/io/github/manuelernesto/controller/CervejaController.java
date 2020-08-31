package io.github.manuelernesto.controller;

import io.github.manuelernesto.Model.Cerveja;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CervejaController {

    @RequestMapping("/cerveja/novo")
    public String novo(Cerveja cerveja) {
        return "cerveja/CadastroCerveja";
    }

    @RequestMapping(value = "/cerveja/novo", method = RequestMethod.POST)
    public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors())
            return novo(cerveja);


        attributes.addFlashAttribute("mensagem", cerveja.getSku() + " Cerveja Cadastrada com sucesso!");

        return "redirect:/cerveja/novo";
    }

    @RequestMapping("/cliente/novo")
    public String cliente() {
        return "cliente/CadastroCliente";
    }
}













