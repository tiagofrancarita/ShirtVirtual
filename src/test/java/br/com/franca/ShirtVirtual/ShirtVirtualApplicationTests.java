package br.com.franca.ShirtVirtual;

import br.com.franca.ShirtVirtual.controller.AcessoController;
import br.com.franca.ShirtVirtual.model.Acesso;
import br.com.franca.ShirtVirtual.repository.AcessoRepository;
import br.com.franca.ShirtVirtual.service.AcessoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShirtVirtualApplicationTests {


    //private AcessoRepository acessoRepository;
    //private AcessoService acessoService;

    private AcessoController acessoController;

    @Autowired
    public ShirtVirtualApplicationTests(AcessoController acessoController) {

        this.acessoController = acessoController;
    }

    @Test
    public void testeCadastrarAcesso(){

        Acesso acesso = new Acesso();
        acesso.setDescAcesso("ROLE_ADMIN_TESTE_controller");
        acessoController.salvarAcess(acesso);

    }
}