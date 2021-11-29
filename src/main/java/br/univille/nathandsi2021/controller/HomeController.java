package br.univille.nathandsi2021.controller;

import java.security.Principal;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

//MVC Model / View / Controller
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping()
    public ModelAndView index(){

        HashMap<String,String> listaDeParzinho = new HashMap<>();
        listaDeParzinho.put("nome", "Sistema de DSI 2021 - NAO ACREDITO");
        listaDeParzinho.put("nomeEmpresa", "UNIVILLE SISTEMAS");
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(principal.getPrincipal());

        return new ModelAndView("home/index", listaDeParzinho);
    }

}