package br.univille.nathandsi2021.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.nathandsi2021.model.PedidoDeCompra;

@Service
public interface PedidoService {
    public List<PedidoDeCompra> getAll();
    public void save(PedidoDeCompra pedido);
    public void delete(PedidoDeCompra pedido);
}
