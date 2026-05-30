package com.yeyu.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 在 Servlet 层拦截请求并在满足条件时转发到 index.html，优先级高于 Spring MVC 的 Controller 映射。
 * 这样可以解决在浏览器刷新 SPA 子路由（例如 /emps）时后端 API（/emps）优先返回 JSON 的问题。
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SpaRedirectFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
            chain.doFilter(request, response);
            return;
        }
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI(); // e.g. /emps or /api/emps or /assets/...
        String method = req.getMethod();

        // 如果是 GET 请求且不以 /api 开头，并且不是静态资源（包含点或以 assets/static/js/css 等开头），则转发到 index.html
        boolean isGet = "GET".equalsIgnoreCase(method);
        boolean isApi = uri.startsWith(req.getContextPath() + "/api") || uri.equals("/api") || uri.startsWith("/api/");
        boolean isStatic = uri.startsWith(req.getContextPath() + "/assets") || uri.startsWith(req.getContextPath() + "/static")
                || uri.equals("/favicon.ico") || uri.contains(".");

        if (isGet && !isApi && !isStatic) {
            // 转发到 index.html，让前端路由处理路径
            req.getRequestDispatcher("/index.html").forward(request, response);
            return;
        }

        chain.doFilter(request, response);
    }
}

