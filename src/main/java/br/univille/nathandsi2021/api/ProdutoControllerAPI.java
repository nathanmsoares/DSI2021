package br.univille.nathandsi2021.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.nathandsi2021.model.Produto;
import br.univille.nathandsi2021.service.ProdutoService;
import io.swagger.models.Response;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoControllerAPI {

    @Autowired
    private ProdutoService service;
    
    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        List<Produto> listaProduto = service.getAll();
        return new ResponseEntity<List<Produto>>(listaProduto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody Produto produto){
        try{
            produto.setId(0);
            service.save(produto);
            return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/list")
    public ResponseEntity<List<Produto>> insertList(@RequestBody List<Produto> listaProdutos){
        for(Produto umProduto: listaProdutos){
            umProduto.setId(0);
            service.save(umProduto);
        }
        return new ResponseEntity<List<Produto>>(listaProdutos,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable("id") Produto produto){
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }


}
