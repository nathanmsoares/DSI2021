package br.univille.nathandsi2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.nathandsi2021.model.GestorCompras;

@Repository
public interface GestorRepository extends JpaRepository<GestorCompras,Long>{
    GestorCompras findByNome(String nome);
}
