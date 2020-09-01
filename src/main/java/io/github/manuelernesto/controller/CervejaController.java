package io.github.manuelernesto.controller;

import io.github.manuelernesto.Model.Cerveja;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CervejaController {

    private static final Logger logger = LoggerFactory.getLogger(CervejaController.class);

    @RequestMapping("/cerveja/novo")
    public String novo(Cerveja cerveja) {
        logger.error("NIVEL ERROR");
        logger.info("NIVEL INFO");
        return "cerveja/CadastroCerveja";
    }

    @RequestMapping(value = "/cerveja/novo", method = RequestMethod.POST)
    public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors())
            return novo(cerveja);


        attributes.addFlashAttribute("mensagem", cerveja.getSku() + " Cerveja Cadastrada com sucesso!");

        return "redirect:/cerveja/novo";
    }

}













