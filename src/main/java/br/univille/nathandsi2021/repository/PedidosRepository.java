package br.univille.nathandsi2021.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.nathandsi2021.model.PedidoDeCompra;

@Repository
public interface PedidosRepository extends JpaRepository<PedidoDeCompra,Long>{
    public List<PedidoDeCompra> findByIdContains(Long id);  
}
