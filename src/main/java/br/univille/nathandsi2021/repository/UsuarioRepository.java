package br.univille.nathandsi2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.nathandsi2021.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    Usuario findByUsuario(String usuario);
    Usuario findByUsuarioAndSenha(String usuario,String senha);
}
