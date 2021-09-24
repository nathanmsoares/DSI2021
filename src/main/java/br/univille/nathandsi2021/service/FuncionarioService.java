package br.univille.nathandsi2021.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.nathandsi2021.model.Funcionario;

@Service
public interface FuncionarioService {
    public List<Funcionario> getAll();
    public void save(Funcionario funcionario);
    public void delete(Funcionario funcionario);
}
