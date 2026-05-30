package com.yeyu.interceptor;

import com.yeyu.utils.CurrentHolder;
import com.yeyu.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 令牌拦截器
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //1.获取请求路径
//        String requestURI = request.getRequestURI();
//
//        //2.判断是否为登录接口，如果是登录接口，放行
//        if (requestURI.contains("/login")) {
//            return true;
//        }
        //3.如果不是登录接口，获取请求头中的token
        String token = request.getHeader("token");

        //4.验证token是否存在，不存在，响应401状态码，提示用户重新登录
        if(token == null || token.isEmpty()){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        //5.校验令牌，如失败，响应401状态码，提示用户重新登录
        try {
            Claims claims = JwtUtils.parseToken(token);
            CurrentHolder.setCurrentId((Integer) claims.get("id"));
        }catch (Exception e){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        //6.放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        CurrentHolder.remove();
    }
}
