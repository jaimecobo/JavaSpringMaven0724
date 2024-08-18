package co.jaimecobo.javaspringmaven0724.service;


import co.jaimecobo.javaspringmaven0724.database.dao.EmployeeDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.EmployeeRoleDAO;
import co.jaimecobo.javaspringmaven0724.database.entity.Employee;
import co.jaimecobo.javaspringmaven0724.database.entity.EmployeeRole;
import co.jaimecobo.javaspringmaven0724.form.CreateEmployeeFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeRoleDAO employeeRoleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Employee createEmployee(CreateEmployeeFormBean form){
        log.debug(form.toString());

        Employee employee = employeeDAO.findById(form.getEmployeeId());
        if(employee == null){
            employee = new Employee();
        }
        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        employee.setPassword(encryptedPassword);
        employee.setEmail(form.getEmail());
        employee.setFullName(form.getFullName());
        employee.setCreateDate(new Date());
        employee = employeeDAO.save(employee);

        // Create an employee role for the employee
        EmployeeRole employeeRole = new EmployeeRole();
        employeeRole.setRoleName("USER");
        employeeRole.setEmployeeId(employee.getId());
        employeeRole.setCreateDate(new Date());
        employeeRoleDAO.save(employeeRole);

        return employee;

    }

}