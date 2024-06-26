package com.metropolitan.projekat.jwt;

import com.metropolitan.projekat.auth.TokenBlackListService;
import com.metropolitan.projekat.entiteti.User;
import com.metropolitan.projekat.service.UserService;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserService adminService;
    private final TokenBlackListService tokenBlackListService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        try {
            String authHeader = request.getHeader("Authorization"); // Bearer jwt

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                // Ako zahtev ne sadrži JWT token, samo ga prosledi dalje
                filterChain.doFilter(request, response);
                return;
            }

            String jwt = authHeader.substring(7);

            // Provera da li je zahtev za prikazivanje proizvoda ili kreiranje korisničke adrese
            if (request.getRequestURI().startsWith("/api/products") ||
                    (request.getMethod().equals("POST") && request.getRequestURI().startsWith("/api/userAddresses"))) {
                // Ako jeste, dozvoli pristup bez JWT tokena
                filterChain.doFilter(request, response);
                return;
            }

            if (tokenBlackListService.isTokenBlacklisted(jwt)) {
                extracted(response, "Please login - Token blacklisted");
                return;
            }

            String username = jwtService.extractUsername(jwt);

            User user = adminService.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    username, null, user.getAuthorities()
            );

            SecurityContextHolder.getContext().setAuthentication(authToken);
            filterChain.doFilter(request, response);

        } catch (JwtException e) {
            extracted(response, e.getMessage());
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }

    private static void extracted(HttpServletResponse response , String s) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write("{\"error\": \""+s+"\"}");
        response.getWriter().flush();
        response.getWriter().close();
    }
}
