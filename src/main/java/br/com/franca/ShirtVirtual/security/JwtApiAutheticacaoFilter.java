package br.com.franca.ShirtVirtual.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtApiAutheticacaoFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        Authentication authentication = new JWTTokenAutenticacaoService().getAuthentication((HttpServletRequest) request, (HttpServletResponse) response);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request,response);

    }
}