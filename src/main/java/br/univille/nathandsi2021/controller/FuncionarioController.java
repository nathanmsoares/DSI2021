package br.univille.nathandsi2021.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.univille.nathandsi2021.model.Funcionario;
import br.univille.nathandsi2021.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService service;
    
    @GetMapping
    public ModelAndView index(){
        List<Funcionario> listaFuncionarios = service.getAll();
        return new ModelAndView("funcionarios/index", "listaFuncionarios", listaFuncionarios);
    }
    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Funcionario funcionario){
        return new ModelAndView("funcionarios/form");
    }
    @PostMapping(params="form")
    public ModelAndView save(Funcionario funcionario){
        service.save(funcionario);
        return new ModelAndView("redirect:/funcionarios");
    }
    @GetMapping(value="/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Funcionario funcionario){
        return new ModelAndView("/funcionarios/form","funcionario", funcionario);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Funcionario funcionario){
        service.delete(funcionario);
        return new ModelAndView("redirect:/funcionarios");
    }
}
