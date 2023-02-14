package br.com.franca.ShirtVirtual.service;

import br.com.franca.ShirtVirtual.model.Acesso;
import br.com.franca.ShirtVirtual.model.PessoaFisica;
import br.com.franca.ShirtVirtual.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaFisicaService {

    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    public PessoaFisicaService(PessoaFisicaRepository pessoaFisicaRepository) {
        this.pessoaFisicaRepository = pessoaFisicaRepository;
    }

    public PessoaFisica salvarPessoa(PessoaFisica pessoaFisica){

        //Validações

        return pessoaFisicaRepository.save(pessoaFisica);

    }
}