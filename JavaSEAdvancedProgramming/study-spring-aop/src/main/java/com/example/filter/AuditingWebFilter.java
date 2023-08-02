package com.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuditingWebFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) request;
        var iter = httpRequest.getHeaderNames().asIterator();
        while (iter.hasNext()) {
            var headerName = iter.next();
            System.out.println(headerName + ": " + httpRequest.getHeader(headerName));
        }
        System.out.println(new String(httpRequest.getInputStream().readAllBytes()));
        chain.doFilter(request,response);
    }
}
