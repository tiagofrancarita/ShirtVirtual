package br.com.franca.ShirtVirtual.repository;

import br.com.franca.ShirtVirtual.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT u FROM Usuario u WHERE u.login = ?1")
    Usuario findUserByLogin(String login);
}
