package br.univille.nathandsi2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.nathandsi2021.model.PedidoDeCompra;
import br.univille.nathandsi2021.service.PedidoService;


@Controller
@RequestMapping("/pedidos")
public class PedidoDeCompraController {

    @Autowired
    private PedidoService service;

    @GetMapping
    public ModelAndView index(){
        List<PedidoDeCompra> listaPedido = service.getAll();
        return new ModelAndView("/pedidos/index", "listaPedidos", listaPedido);
    }
    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute PedidoDeCompra pedido){
        return new ModelAndView("pedidos/form");
    }
    @PostMapping(params="form")
    public ModelAndView save(PedidoDeCompra pedido){
        System.out.println(pedido);
        return new ModelAndView("redirect:/pedidos");
    }
    @GetMapping(value="/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") PedidoDeCompra pedido){
        return new ModelAndView("/pedidos/form", "pedido", pedido);
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") PedidoDeCompra pedido){
        service.delete(pedido);
        return new ModelAndView("redirect:/pedidos");
    }
    
}
