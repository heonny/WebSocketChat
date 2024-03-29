package com.chang.socketchat.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 외부에서 접근가능하도록 CORS 허용
 */
@Slf4j
@Component
public class CORSFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        String remoteAddr = request.getRemoteAddr();
        if (remoteAddr.equals("0:0:0:0:0:0:0:1")) {
            remoteAddr = "localhost";
        }
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse
            .setHeader("Access-Control-Allow-Origin", "http://" + remoteAddr + ":9998");
        httpServletResponse
            .setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        httpServletResponse
            .setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse
            .setHeader("Access-Control-Allow-Headers", "*");
        httpServletResponse
            .setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) {
        log.debug("CORS Filter init");
    }

    @Override
    public void destroy() {
        log.debug("CORS Filter destroy");
    }
}
