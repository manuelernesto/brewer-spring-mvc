package io.github.manuelernesto.controller;

import io.github.manuelernesto.Model.Cerveja;
import io.github.manuelernesto.Model.Sabor;
import io.github.manuelernesto.repository.Cervejas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CervejaController {

    private final Cervejas cervejas;

    public CervejaController(Cervejas cervejas) {
        this.cervejas = cervejas;
    }

    @RequestMapping("/cerveja/novo")
    public ModelAndView novo(Cerveja cerveja) {
        ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
        mv.addObject("sabores", Sabor.values());
        return mv;
    }

    @RequestMapping(value = "/cerveja/novo", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors())
            return novo(cerveja);


        attributes.addFlashAttribute("mensagem", cerveja.getSku() + " Cerveja Cadastrada com sucesso!");

        return new ModelAndView("redirect:/cerveja/novo");
    }

}













