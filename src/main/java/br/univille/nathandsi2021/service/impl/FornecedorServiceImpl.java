package br.univille.nathandsi2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.nathandsi2021.model.Fornecedor;
import br.univille.nathandsi2021.repository.FornecedorRepository;
import br.univille.nathandsi2021.service.FornecedorService;


@Service
public class FornecedorServiceImpl implements FornecedorService{
    @Autowired
    private FornecedorRepository repositoryFornecedor;
    @Override
    public List<Fornecedor> getAll(){
        return repositoryFornecedor.findAll();
    }
    @Override
    public void save(Fornecedor fornecedor) {
        repositoryFornecedor.save(fornecedor);
        
    }
    @Override
    public void delete(Fornecedor fornecedor) {
        repositoryFornecedor.delete(fornecedor);
    };
    
}
