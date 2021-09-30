package br.univille.nathandsi2021.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.nathandsi2021.model.PedidoDeCompra;

@Repository
public interface PedidosRepository extends JpaRepository<PedidoDeCompra,Long>{
}
