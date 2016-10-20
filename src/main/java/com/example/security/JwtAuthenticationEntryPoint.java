package com.example.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/*If the user can not be authenticated we return a 401
response to the user (REST -> client handles the redirect to the loginpage)*/

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable{

    // This is invoked when user tries to access a secured REST resource without supplying any credentials
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.sendError(response.SC_BAD_REQUEST, "Unauthorized");
    }
}
