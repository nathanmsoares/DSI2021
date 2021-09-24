package br.univille.nathandsi2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.nathandsi2021.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long>{
}
