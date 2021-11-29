package br.univille.nathandsi2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.nathandsi2021.model.GestorCompras;
import br.univille.nathandsi2021.repository.GestorRepository;
import br.univille.nathandsi2021.service.GestorService;


@Service
public class GestorServiceImpl implements GestorService{
    @Autowired
    private GestorRepository repositoryGestor;
    @Override
    public List<GestorCompras> getAll(){
        return repositoryGestor.findAll();
    }
    @Override
    public void save(GestorCompras gestor) {
        repositoryGestor.save(gestor);
        
    }
    @Override
    public void delete(GestorCompras gestor) {
        repositoryGestor.delete(gestor);
    }
    @Override
    public GestorCompras encontrarPorNome(String nome) {
        return repositoryGestor.findByNome(nome);
    };
    
}
