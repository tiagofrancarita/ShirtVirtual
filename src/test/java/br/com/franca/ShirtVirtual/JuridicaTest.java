package br.com.franca.ShirtVirtual;

import br.com.franca.ShirtVirtual.controller.PessoaJuridicaController;
import br.com.franca.ShirtVirtual.exceptions.ExceptionShirtVirtual;
import br.com.franca.ShirtVirtual.model.PessoaJuridica;
import br.com.franca.ShirtVirtual.repository.PessoaFisicaRepository;
import br.com.franca.ShirtVirtual.repository.PessoaJuridicaRepository;
import br.com.franca.ShirtVirtual.service.PessoaFisicaService;
import br.com.franca.ShirtVirtual.service.PessoaJuridicaService;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.util.Calendar;

@Profile("test")
@SpringBootTest
public class JuridicaTest extends TestCase {

    private PessoaFisicaService pessoaFisicaService;
    private PessoaFisicaRepository pessoaFisicaRepository;
    private PessoaJuridicaRepository pessoaJuridicaRepository;
    private PessoaJuridicaService pessoaJuridicaService;
    private PessoaJuridicaController pessoaJuridicaController;

    @Autowired
    public JuridicaTest(PessoaFisicaService pessoaFisicaService, PessoaFisicaRepository pessoaFisicaRepository, PessoaJuridicaRepository pessoaJuridicaRepository, PessoaJuridicaService pessoaJuridicaService, PessoaJuridicaController pessoaJuridicaController) {
        this.pessoaFisicaService = pessoaFisicaService;
        this.pessoaFisicaRepository = pessoaFisicaRepository;
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
        this.pessoaJuridicaService = pessoaJuridicaService;
        this.pessoaJuridicaController = pessoaJuridicaController;
    }

    @Test
    public void testeCadastroPessoaJuridica() throws ExceptionShirtVirtual {

        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCnpj("" + Calendar.getInstance().getTimeInMillis());
        pessoaJuridica.setNome("Tiago");
        pessoaJuridica.setEmail("admin");
        pessoaJuridica.setTelefone("45999795800");
        pessoaJuridica.setInscEstadual("655565656566615");
        pessoaJuridica.setInscricaoMunicipal("555545615656565");
        pessoaJuridica.setNomeFantasia("545565656651");
        pessoaJuridica.setRazaoSocial("46566565661");
        pessoaJuridica.setCategoria("Informatica");

        pessoaJuridicaController.salvarPessoaJuridica(pessoaJuridica);

    }
}
