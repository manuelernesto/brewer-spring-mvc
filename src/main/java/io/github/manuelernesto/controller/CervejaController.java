package io.github.manuelernesto.controller;

import io.github.manuelernesto.Model.Cerveja;
import io.github.manuelernesto.Model.Origem;
import io.github.manuelernesto.Model.Sabor;
import io.github.manuelernesto.repository.Cervejas;
import io.github.manuelernesto.repository.Estilos;
import io.github.manuelernesto.service.CadastroCervejaService;
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

    private final Estilos estilos;
    private final CadastroCervejaService service;

    public CervejaController(Estilos estilos, CadastroCervejaService service) {
        this.estilos = estilos;
        this.service = service;
    }

    @RequestMapping("/cerveja/novo")
    public ModelAndView novo(Cerveja cerveja) {
        ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
        mv.addObject("sabores", Sabor.values());
        mv.addObject("estilos", estilos.findAll());
        mv.addObject("origens", Origem.values());
        return mv;
    }

    @RequestMapping(value = "/cerveja/novo", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors())
            return novo(cerveja);


        service.salvar(cerveja);
        attributes.addFlashAttribute("mensagem", cerveja.getSku() + " Cerveja Cadastrada com sucesso!");

        return new ModelAndView("redirect:/cerveja/novo");
    }

}













