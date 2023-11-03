package com.cetus.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CetusSecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        System.out.println(request.getRequestURI());
//        System.out.println(request.getMethod());

        // 非登录请求，不处理
//        if ("/login".equals(request.getRequestURI()) && request.getMethod().equals(HttpMethod.POST.name())) {
//            String username = request.getParameter("username");
//            String password = request.getParameter("password");
//            System.out.println("username:" + username);
//            System.out.println("password:" + password);
//        } else {
//            System.out.println("非登录处理！");
//        }

        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("Evan", "", null));
        filterChain.doFilter(request, response);
    }
}
