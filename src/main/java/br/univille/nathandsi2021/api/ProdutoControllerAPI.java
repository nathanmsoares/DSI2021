package br.univille.nathandsi2021.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.nathandsi2021.model.Produto;
import br.univille.nathandsi2021.service.ProdutoService;

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
            produto.setIdd(0);
            service.save(produto);
            return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/list")
    public ResponseEntity<List<Produto>> insertList(@RequestBody List<Produto> listaProdutos){
        for(Produto umProduto: listaProdutos){
            umProduto.setIdd(0);
            service.save(umProduto);
        }
        return new ResponseEntity<List<Produto>>(listaProdutos,HttpStatus.CREATED);
    }

    @GetMapping("/{idd}")
    public ResponseEntity<Produto> getById(@PathVariable("idd") Produto produto){
        try{
            return new ResponseEntity<>(produto, HttpStatus.OK);
        }catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @DeleteMapping("/{idd}")
    public ResponseEntity<Produto> delete(@PathVariable("idd") Produto produto){
        service.delete(produto);
        return new ResponseEntity<Produto>(produto,HttpStatus.OK);
    }
    @PutMapping("/{idd}")
    public ResponseEntity<Produto> update (@RequestBody Produto produto, 
                                           @PathVariable("idd") Produto produtoAntigo){
        produtoAntigo.setDimensao(produto.getDimensao());
        produtoAntigo.setNome(produto.getNome());
        produtoAntigo.setPeso(produto.getPeso());
        service.save(produtoAntigo);
        return new ResponseEntity<Produto>(produtoAntigo,HttpStatus.OK);
    }


}
