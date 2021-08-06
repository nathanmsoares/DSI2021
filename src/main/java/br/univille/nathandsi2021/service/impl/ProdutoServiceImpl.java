package br.univille.nathandsi2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.nathandsi2021.model.Produto;
import br.univille.nathandsi2021.repository.ProdutosRepository;
import br.univille.nathandsi2021.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{
    @Autowired
    private ProdutosRepository repository;
    @Override
    public List<Produto> getAll(){
        return repository.findAll();
    }
    @Override
    public void save(Produto produto) {
        repository.save(produto);
        
    }
    @Override
    public void delete(Produto produto) {
        repository.delete(produto);
    };
    
}
