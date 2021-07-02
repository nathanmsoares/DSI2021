package br.univille.nathandsi2021.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.nathandsi2021.model.Produto;

@Service
public interface ProdutoService {
    public List<Produto> getAll();
    public void save(Produto produto);
    public void delete(Produto produto);
}
