package com.relationships.relationships.security.filter;

import com.relationships.relationships.security.jwt.JwtUtils;
import com.relationships.relationships.security.manager.UserAuthenticationManager;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
public class UserAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final UserAuthenticationManager customAuthenticationManger;
    private final JwtUtils jwtUtils;

    @Override
    public Authentication attemptAuthentication
            (HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        //1. create an authentication obj (which contain auth credentials) that isn't authenticated
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //2. use authmanager to authenticate the user whose
        // auth credentials are now contained in the auth obj
        UsernamePasswordAuthenticationToken authenticationToken=
                new UsernamePasswordAuthenticationToken(email,password);
        //3. get back the auth obj
        Authentication authenticatedToken =customAuthenticationManger.authenticate(authenticationToken);
        //4. store auth in security context
        if (authenticatedToken!=null) {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authenticationToken);
            return authenticatedToken;
        }
        throw new BadCredentialsException("Oh Oh!!");
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

    }

}
