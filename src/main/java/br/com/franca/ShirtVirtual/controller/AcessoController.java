package br.com.franca.ShirtVirtual.controller;

import br.com.franca.ShirtVirtual.model.Acesso;
import br.com.franca.ShirtVirtual.service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AcessoController {

    private AcessoService acessoService;

    @Autowired
    public AcessoController(AcessoService acessoService) {
        this.acessoService = acessoService;
    }

    public Acesso salvarAcess(Acesso acesso){

        return acessoService.salvarAcesso(acesso);
    }
}
