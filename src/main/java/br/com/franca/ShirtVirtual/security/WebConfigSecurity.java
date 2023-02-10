package br.com.franca.ShirtVirtual.security;

import br.com.franca.ShirtVirtual.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpSessionListener;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebConfigSecurity extends WebSecurityConfigurerAdapter implements HttpSessionListener {

    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public WebConfigSecurity(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository
                .withHttpOnlyFalse())
                .disable().authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().authenticated()
                .and().logout().logoutSuccessUrl("/index")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and().addFilterAfter(new JWTLoginFilter("/login",authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtApiAutheticacaoFilter(),UsernamePasswordAuthenticationFilter.class);

    }
      @Override
    public void configure(WebSecurity web) throws Exception {
       /* web.ignoring().antMatchers(HttpMethod.POST,"/acessos/cadastrarAcesso")
                .antMatchers(HttpMethod.DELETE,"/acessos/deletarAcesso")
                .antMatchers(HttpMethod.GET,"/acessos/cadastrarAcesso")
                .antMatchers(HttpMethod.GET,"/acessos/listarAcessos");*/
    }
}


