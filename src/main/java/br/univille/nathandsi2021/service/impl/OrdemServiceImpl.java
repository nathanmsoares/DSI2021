package br.univille.nathandsi2021.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.nathandsi2021.repository.OrdemRepository;
import br.univille.nathandsi2021.service.OrdemService;
import br.univille.nathandsi2021.model.OrdemDeCompra;

@Service
public class OrdemServiceImpl implements OrdemService{
    @Autowired
    private OrdemRepository repository;
    @Override
    public List<OrdemDeCompra> getAll(){
        return repository.findAll();
    }
    @Override
    public void save(OrdemDeCompra ordem){
        repository.save(ordem);
    }
    @Override
    public void delete(OrdemDeCompra ordem){
        repository.delete(ordem);
    }
}
