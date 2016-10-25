package kaer.morhen.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter extends OncePerRequestFilter {

    private static final String UTF_8 = "UTF-8";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {

        String xRequestWithHeader = request.getHeader("X-Requested-With");
        if (xRequestWithHeader == null || "XMLHttpRequest".equals(xRequestWithHeader)) {
            // HTTP 1.1.
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            // HTTP 1.0.
            response.setHeader("Pragma", "no-cache");
            // Proxies.
            response.setDateHeader("Expires", 0);
        }

        // Honour the client-specified character encoding
        if (null == request.getCharacterEncoding()) {
            request.setCharacterEncoding(UTF_8);
        }

        filterChain.doFilter(request, response);
    }
}