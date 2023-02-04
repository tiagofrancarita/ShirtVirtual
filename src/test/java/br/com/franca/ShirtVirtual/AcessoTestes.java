package br.com.franca.ShirtVirtual;

import br.com.franca.ShirtVirtual.controller.AcessoController;
import br.com.franca.ShirtVirtual.model.Acesso;
import br.com.franca.ShirtVirtual.repository.AcessoRepository;
import br.com.franca.ShirtVirtual.service.AcessoService;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class AcessoTestes extends TestCase {


    private AcessoRepository acessoRepository;
    private AcessoService acessoService;
    private AcessoController acessoController;

    @Autowired
    public AcessoTestes(AcessoController acessoController,AcessoRepository acessoRepository,AcessoService acessoService) {

        this.acessoController = acessoController;
        this.acessoRepository = acessoRepository;
        this.acessoService = acessoService;
    }

    @Test
    public void testeCadastrarAcesso(){

        Acesso acesso = new Acesso();
        acesso.setDescAcesso("ROLE_ADMIN_TESTE_controller");
        acesso = acessoController.salvarAcess(acesso).getBody();
        assertEquals(true,acesso.getId() > 0);

    }

    @Test
    public void salvarFormaCorreta(){

        Acesso acesso = new Acesso();
        acesso.setDescAcesso("ROLE_ADMIN");
        acesso = acessoController.salvarAcess(acesso).getBody();
       assertEquals("ROLE_ADMIN",acesso.getDescAcesso());
    }

    @Test
    public void testeCarregamento(){

        Acesso acesso = new Acesso();
        acesso.setDescAcesso("ROLE_ADMIN");
        acesso = acessoController.salvarAcess(acesso).getBody();
        Acesso acesso2 = acessoRepository.findById(acesso.getId()).get();
        assertEquals(acesso.getId(), acesso2.getId());
    }

    @Test
    public void testeDeletarAcesso(){

        Acesso acesso = new Acesso();
        acesso.setDescAcesso("ROLE_ADMIN");
        acesso = acessoController.salvarAcess(acesso).getBody();
        acessoRepository.deleteById(acesso.getId());
        acessoRepository.flush();
        Acesso acessoDelete = acessoRepository.findById(acesso.getId()).orElse(null);
        assertEquals(true, acessoDelete == null);

    }

    @Test
    public void testeQuery(){

        Acesso acesso = new Acesso();
        acesso.setDescAcesso("ROLE_ALUNO");
        acesso = acessoController.salvarAcess(acesso).getBody();
        List<Acesso> acessos = acessoRepository.buscarAcessoDescricao("ALUNO".trim().toUpperCase());
        assertEquals(1, acessos.size());
        acessoRepository.deleteById(acesso.getId());

    }
}