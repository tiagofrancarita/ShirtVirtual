package br.com.franca.ShirtVirtual.controller;


import br.com.franca.ShirtVirtual.exceptions.ExceptionShirtVirtual;
import br.com.franca.ShirtVirtual.model.PessoaJuridica;
import br.com.franca.ShirtVirtual.repository.PessoaJuridicaRepository;
import br.com.franca.ShirtVirtual.service.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/pessoaJuridica")
public class PessoaJuridicaController {

    final String INICIO_LISTAR_ACESSO = "Iniciando a listagem de acesso!";
    final String LISTAGEM_COM_SUCESSO = "Iniciando a listagem de acesso!";
    final String ERRO_DESCRICAO_CADASTRADA = "Já existe um acesso com essa descrição.!";

    private PessoaJuridicaRepository pessoaJuridicaRepository;
    private PessoaJuridicaService pessoaJuridicaService;

    @Autowired
    public PessoaJuridicaController(PessoaJuridicaRepository pessoaJuridicaRepository, PessoaJuridicaService pessoaJuridicaService) {
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
        this.pessoaJuridicaService = pessoaJuridicaService;
    }

    @GetMapping("**/listarPessoaJuridica")
    public List<PessoaJuridica> listarPessoaJuridica() {

        return pessoaJuridicaRepository.findAll();

    }

    @ResponseBody
    @PostMapping("/salvarPessoaJuridica")
    public ResponseEntity<PessoaJuridica> salvarPessoaJuridica(@RequestBody PessoaJuridica pessoaJuridica) throws ExceptionShirtVirtual {

        if (pessoaJuridica == null) {
            throw new ExceptionShirtVirtual("Pessoa juridica nao pode ser NULL");
        }

        if (pessoaJuridica.getId() == null && pessoaJuridicaRepository.existeCNPJ(pessoaJuridica.getCnpj()) != null) {
            throw new ExceptionShirtVirtual("Já existe CNPJ cadastrado com o número: " + pessoaJuridica.getCnpj());
        }

        pessoaJuridica = pessoaJuridicaService.salvarPessoaJuridica(pessoaJuridica);

        return new ResponseEntity<PessoaJuridica>(pessoaJuridica, HttpStatus.OK);
    }

}
