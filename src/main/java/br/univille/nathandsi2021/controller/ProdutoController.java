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


import br.univille.nathandsi2021.model.Produto;
import br.univille.nathandsi2021.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService service;
    
    @GetMapping
    public ModelAndView index(){
        List<Produto> listaProduto = service.getAll();
        return new ModelAndView("produtos/index", "listaProdutos", listaProduto);
    }
    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Produto produto){
        return new ModelAndView("produtos/form");
    }
    @PostMapping(params="form")
    public ModelAndView save(Produto produto){
        System.out.println(produto.getNome());
        System.out.println(produto.getPeso());
        service.save(produto);
        return new ModelAndView("redirect:/produtos");
    }
    @GetMapping(value="/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Produto produto){
        System.out.println(produto.getNome());
        System.out.println(produto.getPeso());
        return new ModelAndView("/produtos/form","produto",produto);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Produto produto){
        service.delete(produto);
        return new ModelAndView("redirect:/produtos");
    }
}
