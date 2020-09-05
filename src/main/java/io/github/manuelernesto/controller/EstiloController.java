package io.github.manuelernesto.controller;

import io.github.manuelernesto.Model.Cerveja;
import io.github.manuelernesto.Model.Estilo;
import io.github.manuelernesto.Model.Origem;
import io.github.manuelernesto.Model.Sabor;
import io.github.manuelernesto.repository.Estilos;
import io.github.manuelernesto.service.CadastroCervejaService;
import io.github.manuelernesto.service.CadastroEstiloService;
import io.github.manuelernesto.service.exception.NomeJaCadastradoException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class EstiloController {

    private final CadastroEstiloService service;

    public EstiloController(CadastroEstiloService service) {
        this.service = service;
    }

    @RequestMapping("/estilo/novo")
    public ModelAndView novo(Estilo estilo) {
        return new ModelAndView("estilo/CadastroEstilo");
    }

    @RequestMapping(value = "/estilo/novo", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors())
            return novo(estilo);


        try {
            service.salvar(estilo);
        } catch (NomeJaCadastradoException e) {
            result.rejectValue("nome", e.getMessage(), e.getMessage());
            return novo(estilo);
        }

        attributes.addFlashAttribute("mensagem", "Estilo " + estilo.getNome() + " cadastrado com sucesso!");
        return new ModelAndView("redirect:/estilo/novo");
    }

}













