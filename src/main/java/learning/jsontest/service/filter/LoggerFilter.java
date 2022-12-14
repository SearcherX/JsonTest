package learning.jsontest.service.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class LoggerFilter extends HttpFilter {
    Logger logger = LoggerFactory.getLogger(LoggerFilter.class);

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        if (response.getStatus() == 200)
            logger.info("Remote host: " + request.getRemoteHost() + ", Requested URI: " +
                    request.getRequestURI() + ", Status: OK");
        else
            logger.error("Remote host: " + request.getRemoteHost() + ", Requested URI: " +
                    request.getRequestURI() + ", Error. Status: " + response.getStatus());
    }
}
