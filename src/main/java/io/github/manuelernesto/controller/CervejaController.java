package io.github.manuelernesto.controller;

import io.github.manuelernesto.Model.Cerveja;
import io.github.manuelernesto.Model.Origem;
import io.github.manuelernesto.Model.Sabor;
import io.github.manuelernesto.repository.Cervejas;
import io.github.manuelernesto.repository.Estilos;
import io.github.manuelernesto.repository.filter.CervejaFilter;
import io.github.manuelernesto.service.CadastroCervejaService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/cerveja")
public class CervejaController {

    private final Estilos estilos;
    private final CadastroCervejaService service;
    private final Cervejas cervejas;

    public CervejaController(Estilos estilos, CadastroCervejaService service, Cervejas cervejas) {
        this.estilos = estilos;
        this.service = service;
        this.cervejas = cervejas;
    }

    @RequestMapping("/novo")
    public ModelAndView novo(Cerveja cerveja) {
        ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
        mv.addObject("sabores", Sabor.values());
        mv.addObject("estilos", estilos.findAll());
        mv.addObject("origens", Origem.values());
        return mv;
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors())
            return novo(cerveja);


        service.salvar(cerveja);
        attributes.addFlashAttribute("mensagem", "Cerveja " + cerveja.getNome() + " cadastrada com sucesso!");

        return new ModelAndView("redirect:/cerveja/novo");
    }

    @GetMapping
    public ModelAndView pesquisar(CervejaFilter cervejaFilter, BindingResult result, Pageable page) {
        ModelAndView mv = new ModelAndView("cerveja/PesquisaCervejas");
        mv.addObject("estilos", estilos.findAll());
        mv.addObject("sabores", Sabor.values());
        mv.addObject("origens", Origem.values());
        mv.addObject("cervejas", cervejas.filtrar(cervejaFilter));
        return mv;
    }
}













