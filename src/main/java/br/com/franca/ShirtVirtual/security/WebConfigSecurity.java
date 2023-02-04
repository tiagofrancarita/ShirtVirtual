package br.com.franca.ShirtVirtual.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.servlet.http.HttpSessionListener;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebConfigSecurity extends WebSecurityConfigurerAdapter implements HttpSessionListener {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.POST,"/acessos/cadastrarAcesso")
                .antMatchers(HttpMethod.DELETE,"/acessos/deletarAcesso")
                .antMatchers(HttpMethod.GET,"/acessos/cadastrarAcesso")
                .antMatchers(HttpMethod.GET,"/acessos/listarAcessos")
                .antMatchers("**/");
    }
}