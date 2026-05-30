package com.yeyu.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * 简单转发器：把以 /api 开头的请求转发到不带 /api 前缀的内部路径，便于在生产环境中兼容前端使用 /api 前缀的请求。
 */
@Controller
public class ApiPrefixController {

    @RequestMapping({"/api", "/api/**"})
    public void forwardApi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI(); // e.g. /api/emps
        String context = request.getContextPath();
        if (context != null && !context.isEmpty() && uri.startsWith(context)) {
            uri = uri.substring(context.length());
        }
        String path = uri.length() > 4 ? uri.substring(4) : "/";
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        String forwardTo = path;
        request.getRequestDispatcher(forwardTo).forward(request, response);
    }
}
