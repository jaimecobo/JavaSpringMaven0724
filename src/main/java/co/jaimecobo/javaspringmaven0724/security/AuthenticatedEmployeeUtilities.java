package co.jaimecobo.javaspringmaven0724.security;

import co.jaimecobo.javaspringmaven0724.database.dao.EmployeeDAO;
import co.jaimecobo.javaspringmaven0724.database.entity.Employee;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Slf4j
@Component
public class AuthenticatedEmployeeUtilities {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String getCurrentUsername() {
        SecurityContext context = SecurityContextHolder.getContext();
        if(context != null && context.getAuthentication() != null) {
            if(context.getAuthentication().getPrincipal() instanceof AnonymousAuthenticationToken) {
                return null;
            }
            final org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) context.getAuthentication().getPrincipal();
            return principal.getUsername();
        }
        else{
            return null;
        }
    }

    public Employee getCurrentEmployee(){
        String username = getCurrentUsername();
        if(username == null){
            return  null;
        }
        return employeeDAO.findByEmailIgnoreCase(username);
    }

    public void manualAuthentication(HttpSession session, String username, String unencryptedPassword) {
        // Resets security principal to be the new employee information
        Authentication request = new UsernamePasswordAuthenticationToken(username, unencryptedPassword);
        Authentication result = authenticationManager.authenticate(request);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(result);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, sc);
    }


    public boolean isUserInRole(String role) {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context != null && context.getAuthentication() != null) {
            Collection<? extends GrantedAuthority> authorities = context.getAuthentication().getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(role)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return false;
        }
        return (authentication != null && authentication.isAuthenticated());

    }

}