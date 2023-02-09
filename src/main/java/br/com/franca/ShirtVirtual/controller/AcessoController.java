package br.com.franca.ShirtVirtual.controller;

import br.com.franca.ShirtVirtual.model.Acesso;
import br.com.franca.ShirtVirtual.repository.AcessoRepository;
import br.com.franca.ShirtVirtual.service.AcessoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/acessos")
//@Api(value = "entry-point para gerenciar categorias", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, tags = {"entrypoint-categorias"})
public class AcessoController {

    private static final Logger logger = LoggerFactory.getLogger(AcessoController.class);

    private AcessoService acessoService;
    private AcessoRepository acessoRepository;

    @Autowired
    public AcessoController(AcessoService acessoService,AcessoRepository acessoRepository) {
        this.acessoService = acessoService;
        this.acessoRepository = acessoRepository;
    }


    //@ApiOperation(value = "Lista todos os acessos cadastrados")
    @GetMapping("**/listarAcessos")
    public List<Acesso> listarAcessos(){

        logger.info("Inicio da listagem de acessos");

        return acessoRepository.findAll();


    }

    //@ApiOperation(value = "end-point para cadastrar acesso")
    @ResponseBody
    @PostMapping(value = "/cadastrarAcesso")
    public ResponseEntity <Acesso> salvarAcess(@RequestBody Acesso acesso){

        Acesso acessoSalvo = acessoService.salvarAcesso(acesso);

        return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.CREATED);
    }

    //@ApiOperation(value = "end-point para deletar acesso")
    @ResponseBody
    @DeleteMapping(value = "**/deletarAcesso")
    public ResponseEntity <String> deletarAcesso(@RequestBody Acesso acesso){

        acessoRepository.deleteById(acesso.getId());

        return new ResponseEntity<String>("Acesso removido com sucesso",HttpStatus.OK);
    }

    @ResponseBody
    @DeleteMapping(value = "**/deleteAcessoPorId/{id}")
    public ResponseEntity<?> deleteAcessoPorId(@PathVariable("id") Long id) {

        acessoRepository.deleteById(id);
        return new ResponseEntity("Acesso removido com sucesso",HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "**/obterAcesso/{id}")
    public ResponseEntity<Acesso> obterAcesso(@PathVariable("id") Long id) {

        Acesso acesso = acessoRepository.findById(id).get();
        return new ResponseEntity<Acesso>(acesso,HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "**/buscarPorDesc/{desc}")
    public ResponseEntity<List<Acesso>> buscarPorDesc(@PathVariable("desc") String desc) {

        List<Acesso> acesso = acessoRepository.buscarAcessoDescricao(desc);

        return new ResponseEntity<List<Acesso>>(acesso,HttpStatus.OK);
    }
}