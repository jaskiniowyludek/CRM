package pl.coderslab.filter;

import pl.coderslab.entity.Role;
import pl.coderslab.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LogInFilter", urlPatterns = {"/priority/*", "/task/*", "/user/*", "/project/*", "/status/*", "/admin/*"})
public class LogInFilter implements Filter {

    public void destroy() {}

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();

        if (session.getAttribute("user") == null){

            response.sendRedirect("/login?requested=" + request.getRequestURL());
            return;
        }
        else {
            User loggedUser = (User) session.getAttribute("user");
            Role role = loggedUser.getRole();
            String requestedURL = request.getRequestURL().toString();

            if (requestedURL.contains("/admin") && !role.getRole().equalsIgnoreCase("ADMIN")) {
                response.sendError(403);
            }
        }


        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {}

}
