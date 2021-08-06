package br.univille.nathandsi2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    
    
}
