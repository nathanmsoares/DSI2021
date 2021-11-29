package br.univille.nathandsi2021.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.nathandsi2021.model.GestorCompras;

@Service
public interface GestorService {
    public List<GestorCompras> getAll();
    public void save(GestorCompras gestor);
    public void delete(GestorCompras gestor);
    public GestorCompras encontrarPorNome(String nome);

}
