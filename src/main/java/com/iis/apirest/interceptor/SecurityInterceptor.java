package com.iis.apirest.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.iis.apirest.jwt.JwtService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtService jwtService;

    private static final String BEARER_PREFIX = "Bearer ";

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object handler)
            throws Exception {
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        // Permitir siempre la solicitud a /user2/login
        if (request.getRequestURI().equals("/user1/login")) {
            return true;
        }
        boolean success = true;

        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER_PREFIX)) {
            String token = authorizationHeader.substring(BEARER_PREFIX.length());
            System.out.println("Bearer Token: " + token);
            success = jwtService.validateToken(token);
        } else {
            success = false;
        }
        // Si el token no es válido o falta, devolver 401
        if (success == false) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        return success;
    }
}
