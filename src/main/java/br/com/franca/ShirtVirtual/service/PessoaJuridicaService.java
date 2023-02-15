package br.com.franca.ShirtVirtual.service;

import br.com.franca.ShirtVirtual.model.PessoaJuridica;
import br.com.franca.ShirtVirtual.model.Usuario;
import br.com.franca.ShirtVirtual.repository.PessoaJuridicaRepository;
import br.com.franca.ShirtVirtual.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class PessoaJuridicaService {

    private PessoaJuridicaRepository pessoaJuridicaRepository;
    private UsuarioRepository usuarioRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PessoaJuridicaService(PessoaJuridicaRepository pessoaJuridicaRepository, UsuarioRepository usuarioRepository, JdbcTemplate jdbcTemplate) {
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
        this.usuarioRepository = usuarioRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public PessoaJuridica salvarPessoaJuridica(PessoaJuridica pessoaJuridica){

        pessoaJuridica = pessoaJuridicaRepository.save(pessoaJuridica);
        Usuario usuarioPJ = usuarioRepository.findByPessoa(pessoaJuridica.getId(), pessoaJuridica.getEmail());

        if (usuarioPJ == null){

            String constraint = usuarioRepository.consultaConstraintAcesso();
            if (constraint != null){
                jdbcTemplate.execute("begin; ALTER TABLE usuarios_acesso DROP CONSTRAINT " + constraint +";commit ;");
            }

            String geradorSenha = "" + Calendar.getInstance().getTimeInMillis();
            String senhaCript = new BCryptPasswordEncoder().encode(geradorSenha);
            usuarioPJ = new Usuario();
            usuarioPJ.setDataAtualSenha(Calendar.getInstance().getTime());
            usuarioPJ.setEmpresa(pessoaJuridica);
            usuarioPJ.setPessoa(pessoaJuridica);
            usuarioPJ.setLogin(pessoaJuridica.getEmail());
            usuarioPJ.setSenha(senhaCript);

            usuarioPJ = usuarioRepository.save(usuarioPJ);

            usuarioRepository.cadastroAcessoUserPJ(usuarioPJ.getId());





        }

        return pessoaJuridica;

    }
}
