package br.univille.nathandsi2021.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.nathandsi2021.model.OrdemDeCompra;

@Service
public interface OrdemService {
    public List<OrdemDeCompra> getAll();
    public void save(OrdemDeCompra ordem);
    public void delete(OrdemDeCompra ordem);
}
