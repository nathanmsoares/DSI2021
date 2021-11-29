package br.univille.nathandsi2021.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.univille.nathandsi2021.model.OrdemDeCompra;
import br.univille.nathandsi2021.model.PedidoDeCompra;
import br.univille.nathandsi2021.service.OrdemService;
import br.univille.nathandsi2021.service.PedidoService;

@Controller
@RequestMapping("/ordem")
public class OrdemController {

    @Autowired
    private PedidoService pedidoService;
    
    @Autowired
    private OrdemService service;
    
    @GetMapping
    public ModelAndView index(){
        List<OrdemDeCompra> listaOrdem = service.getAll();
        return new ModelAndView("ordem/index", "listaOrdem", listaOrdem);
    }
    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute OrdemDeCompra ordem){

        List<PedidoDeCompra> listaPedidos = this.pedidoService.findByAprovacao(false);
        System.out.println("parar");
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("listaPedidos", listaPedidos);
        dados.put("ordem", ordem);
        // usar em save
        // ordem.getPedido_de_compra().setAprovacao(true);
        return new ModelAndView("ordem/form", dados);
    }
    @PostMapping()
    public ModelAndView save(OrdemDeCompra ordem){
        if(ordem.getPedidoDeCompra() != null){
            if(ordem.getAprovado().equals("Aprovado")){
                ordem.getPedidoDeCompra().setAprovacao(true);
            };
            service.save(ordem);
        }
        return new ModelAndView("redirect:/ordem");
    }
    @GetMapping(value="/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") OrdemDeCompra ordem){
        List<PedidoDeCompra> listaPedidos = new ArrayList<>();
        listaPedidos.add(ordem.getPedidoDeCompra());
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("listaPedidos", listaPedidos);
        dados.put("ordem", ordem);
        // usar em save
        // ordem.getPedido_de_compra().setAprovacao(true);
        return new ModelAndView("ordem/form", dados);
    }

    // @GetMapping("/delete/{id}")
    // public ModelAndView delete(@PathVariable("id") OrdemDeCompra ordem){
    //     service.delete(ordem);
    //     return new ModelAndView("redirect:/ordem");
    // }
}
