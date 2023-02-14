package br.com.franca.ShirtVirtual.repository;


import br.com.franca.ShirtVirtual.model.Acesso;
import br.com.franca.ShirtVirtual.model.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

    @Query("select p from PessoaFisica p where upper(trim(p.cpf)) like %?1%")
    List<Acesso> buscarPessoaCpf(String cpf);
}
