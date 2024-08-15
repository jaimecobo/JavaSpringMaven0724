package co.jaimecobo.javaspringmaven0724.security;

import co.jaimecobo.javaspringmaven0724.database.dao.EmployeeDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.EmployeeRoleDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.UserDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.UserRoleDAO;
import co.jaimecobo.javaspringmaven0724.database.entity.Employee;
import co.jaimecobo.javaspringmaven0724.database.entity.EmployeeRole;
import co.jaimecobo.javaspringmaven0724.database.entity.User;
import co.jaimecobo.javaspringmaven0724.database.entity.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

//    @Autowired
//    private EmployeeDAO employeeDAO;
//    @Autowired
//    private EmployeeRoleDAO employeeRoleDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//        Employee employee = employeeDAO.findByEmailIgnoreCase(username);
        User user = userDAO.findByEmailIgnoreCase(username);


//        if(employee == null){
        if(user == null){
                throw new UsernameNotFoundException("Username " + username + " not found!");
        }
        // check the account status
        boolean accountIsEnabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        // Using the employee object from the database to get the employee's roles
//        List<EmployeeRole> employeeRoleList = employeeRoleDAO.findByEmployeeId(employee.getId());
        List<UserRole> userRoleList = userRoleDAO.findByUserId(user.getId());

        // Passing the employee's roles to create the granted authorities
        Collection<? extends GrantedAuthority> authorities = buildGrantAuthorities(userRoleList);

        // This UserDetails object is part of Spring Security
        // Because both objets are named User, we have to use the full path to the object
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
//                employee.getEmail(),  // This parameter is the username, in our case the employee email from the database
//                employee.getPassword(), // This is the user's encrypted password from the database
                user.getEmail(),  // This parameter is the username, in our case the employee email from the database
                user.getPassword(), // This is the user's encrypted password from the database
                accountIsEnabled, // Is this account enabled? if false, then spring security will deny access
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                authorities     // This is the list of security roles that the user is authorized to have
        );
        return userDetails;

    }


//    private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<EmployeeRole> employeeRoles) {
        private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (UserRole role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;

    }

}