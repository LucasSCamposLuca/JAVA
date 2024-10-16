package com.example.projetoFinalJava.controllers;

import com.example.projetoFinalJava.models.Convidado;
import com.example.projetoFinalJava.models.Evento;
import com.example.projetoFinalJava.repository.ConvidadoRepository;
import com.example.projetoFinalJava.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;

    @Autowired
    private ConvidadoRepository cr;

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
    public String form(){
        return "evento/formEvento";
    }

    @RequestMapping(value = "/cadastrarEvento")
    public String form(@Validated Evento evento, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarEventos";
        }
        er.save(evento);
        attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso!");
        return  "redirect/cadastrarEvento";
    }

    @RequestMapping("/eventos")
    public ModelAndView listaEvento(){
        ModelAndView mv = new ModelAndView();
        Iterable<Evento> eventos = er.findAll();
        mv.addObject("eventos", eventos);
        return mv;
    }

    @RequestMapping(value = "/{codigo}")
    public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo){
        Evento evento = er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("evento/detalhesEvento");
        mv.addObject("evento", evento);

        Iterable<Convidado> convidados = cr.findByEvento(evento);
        mv.addObject("convidados", convidados);
        return  mv;
    }

    @RequestMapping("deletarEvento")
    public String deletarEvento(long codigo){
        Evento evento = er.findByCodigo(codigo);
        return "redirect/eventos";
    }

    @RequestMapping(value = "{codigo}")
    public String detalhes(@PathVariable("codigo") long codigo, @Validated Convidado convido, BindingResult result, RedirectAttributes attributes){

        if (result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "verifique os campos");
            return "redirect:/cadastrarEvento";
        }

        Evento evento = er.findByCodigo(codigo);
        cr.delete(convido);
        cr.save(convido);
        attributes.addFlashAttribute("mesnsagem", "Convidado adcionado com sucesso");
        return "redirect:/{codigo}";
    }

    @RequestMapping("/deletarConvidado")
    public String deletarConvidado(String rg){
        Convidado convidado = cr.findByRg(rg);
        cr.delete(convidado);

        Evento evento = convidado.getEvento();
    }

}
