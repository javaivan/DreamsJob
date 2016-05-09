package com.ivanmix.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession(false);
        if(req.getRequestURI().contains("/login")){
            filterChain.doFilter(servletRequest,servletResponse);
        } else if((session == null) || (session.getAttribute("login") == null)){
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(servletRequest,servletResponse);
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }

        System.out.println("filter");
    }

    public void destroy() {

    }
}
