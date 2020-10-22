package io.github.manuelernesto.controller;

import io.github.manuelernesto.Model.Estilo;
import io.github.manuelernesto.controller.page.PageWrapper;
import io.github.manuelernesto.repository.Estilos;
import io.github.manuelernesto.repository.filter.EstiloFilter;
import io.github.manuelernesto.service.CadastroEstiloService;
import io.github.manuelernesto.service.exception.NomeJaCadastradoException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/estilo")
public class EstiloController {

    private final CadastroEstiloService service;
    private final Estilos estilos;

    public EstiloController(CadastroEstiloService service, Estilos estilos) {
        this.service = service;
        this.estilos = estilos;
    }

    @RequestMapping("/novo")
    public ModelAndView novo(Estilo estilo) {
        return new ModelAndView("estilo/CadastroEstilo");
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
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

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ResponseEntity<?> salvar(@RequestBody @Valid Estilo estilo, BindingResult result) {
        if (result.hasErrors())
            return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());

        estilo = service.salvar(estilo);

        return ResponseEntity.ok(estilo);
    }

    @GetMapping
    public ModelAndView pesquisar(
            EstiloFilter estiloFilter,
            BindingResult result,
            @PageableDefault(size = 2) Pageable pageable,
            HttpServletRequest httpServletRequest
    ) {
        ModelAndView mv = new ModelAndView("estilo/PesquisaEstilos");

        PageWrapper<Estilo> pageWrapper = new PageWrapper<>(
                estilos.filtrar(estiloFilter, pageable),
                httpServletRequest);

        mv.addObject("page", pageWrapper);
        return mv;
    }

}













