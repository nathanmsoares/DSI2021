package br.univille.nathandsi2021.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.nathandsi2021.model.Fornecedor;
import br.univille.nathandsi2021.model.Funcionario;
import br.univille.nathandsi2021.model.ItemPedido;
import br.univille.nathandsi2021.model.PedidoDeCompra;
import br.univille.nathandsi2021.model.Produto;
import br.univille.nathandsi2021.service.FornecedorService;
import br.univille.nathandsi2021.service.FuncionarioService;
import br.univille.nathandsi2021.service.PedidoService;
import br.univille.nathandsi2021.service.ProdutoService;


@Controller
@RequestMapping("/pedidos")
public class PedidoDeCompraController {

    @Autowired
    private PedidoService service;

    @Autowired
    private ProdutoService serviceProduto;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ModelAndView index(){
        List<PedidoDeCompra> listaPedidos = service.getAll();
        return new ModelAndView("/pedidos/index", "listaPedidos", listaPedidos);
    }
    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute PedidoDeCompra pedido){
        List<Produto> listaProdutos = this.serviceProduto.getAll();
        ItemPedido itemPedido = new ItemPedido();
        List<Funcionario> funcionarios = this.funcionarioService.getAll();
        List<Fornecedor> fornecedores = this.fornecedorService.getAll();
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("pedido", pedido);
        dados.put("listaProdutos", listaProdutos);
        dados.put("listaFuncionarios", funcionarios);
        dados.put("itemPedido", itemPedido);
        dados.put("listaFornecedores", fornecedores);
        return new ModelAndView("pedidos/form", dados);
    }
    @PostMapping()
    public ModelAndView save(PedidoDeCompra pedido){
        System.out.println(pedido);
        service.save(pedido);
        return new ModelAndView("redirect:/pedidos");
    }
    @GetMapping(value="/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") PedidoDeCompra pedido){
        List<Produto> listaProdutos = this.serviceProduto.getAll();
        ItemPedido itemPedido = new ItemPedido();
        List<Funcionario> funcionarios = this.funcionarioService.getAll();
        List<Fornecedor> fornecedores = this.fornecedorService.getAll();
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("pedido", pedido);
        dados.put("listaProdutos", listaProdutos);
        dados.put("listaFuncionarios", funcionarios);
        dados.put("itemPedido", itemPedido);
        dados.put("listaFornecedores", fornecedores);
        return new ModelAndView("pedidos/form", dados);
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") PedidoDeCompra pedido){
        service.delete(pedido);
        return new ModelAndView("redirect:/pedidos");
    }

    @PostMapping(params= {"insertproc"})
    public ModelAndView insertproc(PedidoDeCompra pedido, ItemPedido itemPedido, Produto produtos) {
        pedido.getListaItemPedido().add(itemPedido);
        List<Produto> listaProdutos = this.serviceProduto.getAll();
        ItemPedido novoItemPedido = new ItemPedido();
        List<Funcionario> funcionarios = this.funcionarioService.getAll();
        List<Fornecedor> fornecedores = this.fornecedorService.getAll();
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("pedido", pedido);
        dados.put("listaProdutos", listaProdutos);
        dados.put("listaFuncionarios", funcionarios);
        dados.put("itemPedido", novoItemPedido);
        dados.put("listaFornecedores", fornecedores);
        return new ModelAndView("pedidos/form", dados);
    }
   
    @PostMapping(params= {"removeproc"})
    public ModelAndView removeproc(@RequestParam(name = "removeproc") int index, PedidoDeCompra pedido, ItemPedido itemPedido) {
        pedido.getListaItemPedido().remove(index);
        List<Produto> listaProdutos = this.serviceProduto.getAll();
        ItemPedido novoItemPedido = new ItemPedido();
        List<Funcionario> funcionarios = this.funcionarioService.getAll();
        List<Fornecedor> fornecedores = this.fornecedorService.getAll();
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("pedido", pedido);
        dados.put("listaProdutos", listaProdutos);
        dados.put("listaFuncionarios", funcionarios);
        dados.put("itemPedido", novoItemPedido);
        dados.put("listaFornecedores", fornecedores);
        return new ModelAndView("pedidos/form", dados);
    }

    
}
