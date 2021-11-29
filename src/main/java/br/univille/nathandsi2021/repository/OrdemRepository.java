package br.univille.nathandsi2021.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.nathandsi2021.model.OrdemDeCompra;

@Repository
public interface OrdemRepository extends JpaRepository<OrdemDeCompra,Long>{
}
