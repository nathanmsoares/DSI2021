package br.univille.nathandsi2021.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.nathandsi2021.repository.PedidosRepository;
import br.univille.nathandsi2021.service.PedidoService;
import br.univille.nathandsi2021.model.PedidoDeCompra;

@Service
public class PedidoServiceImpl implements PedidoService{
    @Autowired
    private PedidosRepository repository;
    @Override
    public List<PedidoDeCompra> getAll(){
        return repository.findAll();
    }
    @Override
    public void save(PedidoDeCompra pedido){
        repository.save(pedido);
    }
    @Override
    public void delete(PedidoDeCompra pedido){
        repository.delete(pedido);
    }
    @Override
    public List<PedidoDeCompra> findByAprovacao(boolean aprovacao) {
        return repository.findByAprovacao(aprovacao);
    }
}
