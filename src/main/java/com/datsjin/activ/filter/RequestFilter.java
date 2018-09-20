package com.datsjin.activ.filter;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@WebFilter(filterName = "requestFilter", urlPatterns = "/*")
public class RequestFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("requestFilter initilized successfully!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();//获得参数列表
        Gson gson = new Gson(); // 需要用到google的gson解析包
        LOGGER.info("RequestURI = " + requestURI + "  Param=" + gson.toJson(parameterMap));
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        LOGGER.info("requestFilter destroy successfully!");
    }

}
