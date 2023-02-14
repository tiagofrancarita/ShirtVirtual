package br.com.franca.ShirtVirtual;

import br.com.franca.ShirtVirtual.model.PessoaFisica;
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

@Profile("test")
@SpringBootTest
public class PessoaFisicaTest extends TestCase {

    private PessoaFisicaService pessoaFisicaService;
    private PessoaFisicaRepository pessoaFisicaRepository;
    private PessoaJuridicaRepository pessoaJuridicaRepository;
    private PessoaJuridicaService pessoaJuridicaService;

    @Autowired
    public PessoaFisicaTest(PessoaFisicaService pessoaFisicaService, PessoaFisicaRepository pessoaFisicaRepository, PessoaJuridicaRepository pessoaJuridicaRepository, PessoaJuridicaService pessoaJuridicaService) {
        this.pessoaFisicaService = pessoaFisicaService;
        this.pessoaFisicaRepository = pessoaFisicaRepository;
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
        this.pessoaJuridicaService = pessoaJuridicaService;
    }

    @Test
    public void testeCadastroPessoaFisica(){

        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setNome("teste de cadastro");
        pessoaJuridica.setEmail("tiagofranca.rita@gmail.com");
        pessoaJuridica.setCnpj("9881932178596");
        pessoaJuridica.setTipoPessoa("Juridica");
        pessoaJuridica.setInscEstadual("34578909");
        pessoaJuridica.setInscricaoMunicipal("321741852");
        pessoaJuridica.setCategoria("Informatica");
        pessoaJuridica.setNomeFantasia("cadastro teste");
        pessoaJuridica.setRazaoSocial("FF teste");
        pessoaJuridica.setTelefone("2133651238");

        pessoaJuridicaRepository.save(pessoaJuridica);

        /*
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setNome("Tiago de França");
        pessoaFisica.setCpf("11807566730");
       // pessoaFisica.setDataNascimento("1995-06-07");
        pessoaFisica.setTipoPessoa("Fisica");
        pessoaFisica.setEmail("tiagofranca.rita@gmail.com");
        pessoaFisica.setEmpresa(pessoaFisica);

         */

    }
}
