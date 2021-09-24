package br.univille.nathandsi2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.nathandsi2021.model.Funcionario;
import br.univille.nathandsi2021.repository.FuncionarioRepository;
import br.univille.nathandsi2021.service.FuncionarioService;


@Service
public class FuncionarioServiceImpl implements FuncionarioService{
    @Autowired
    private FuncionarioRepository repositoryFuncionario;
    @Override
    public List<Funcionario> getAll(){
        return repositoryFuncionario.findAll();
    }
    @Override
    public void save(Funcionario funcionario) {
        repositoryFuncionario.save(funcionario);
        
    }
    @Override
    public void delete(Funcionario funcionario) {
        repositoryFuncionario.delete(funcionario);
    };
    
}
