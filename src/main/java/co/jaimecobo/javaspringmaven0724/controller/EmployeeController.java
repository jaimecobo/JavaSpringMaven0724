package co.jaimecobo.javaspringmaven0724.controller;

import co.jaimecobo.javaspringmaven0724.database.dao.EmployeeDAO;
import co.jaimecobo.javaspringmaven0724.database.entity.Employee;
import co.jaimecobo.javaspringmaven0724.form.CreateEmployeeFormBean;
import co.jaimecobo.javaspringmaven0724.security.AuthenticatedEmployeeUtilities;
import co.jaimecobo.javaspringmaven0724.security.AuthenticatedUserUtilities;
import co.jaimecobo.javaspringmaven0724.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AuthenticatedEmployeeUtilities authenticatedEmployeeUtilities;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;


    @GetMapping("/employees")
    public ModelAndView searchEmployee(@RequestParam(required = false) String email) {
        ModelAndView response = new ModelAndView("employee/employees"); //Here employees is the exact same name of employees.jsp
        response.addObject("email", email); //Here employee is the variable that we are passing or returning to the web page
        Employee employee = employeeDAO.findByEmailIgnoreCase(email);
        response.addObject("employee", employee);
        return response;

    }


    @GetMapping({"/employee/{id}"})
    public ModelAndView employeeById(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("employee/employee");
        log.debug("The user has selected a employee with id = " + id);
        Employee employee = employeeDAO.findById(id);
        response.addObject("employeeKey", employee);
        return response;

    }


    @GetMapping("/create-employee")
    public ModelAndView createEmployee() {
        return new ModelAndView("employee/create-employee");
    }


    @PostMapping("/submit-employee")
    public ModelAndView createEmployeeSubmit(HttpSession session, @Valid CreateEmployeeFormBean form, BindingResult bindingResult){
        ModelAndView response = new ModelAndView("employee/create-employee");

        if ( form.getEmployeeId() == null ) {
            Employee e = employeeDAO.findByEmailIgnoreCase(form.getEmail());
            if ( e != null ) {
                bindingResult.rejectValue("email", "email", "Try with a different email. Checking from ctrl");
            }
        }

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
            response.setViewName("employee/create-employee");
        }
        else{
            // This line was creating the new employee and redirecting to their new create employee details page
//            response.setViewName("redirect:/employee/employee/" + employeeService.createEmployee(form).getId());

            // These to lines instead of the line above, is creating the new employee and logging in the employee automatically
            employeeService.createEmployee(form);
            authenticatedEmployeeUtilities.manualAuthentication(session, form.getEmail(), form.getPassword());

        }
        return response;

    }

    @GetMapping({"/edit-employee"})
    public ModelAndView editEmployee(@RequestParam(required = false) Integer employeeId) {
        ModelAndView response = new ModelAndView("employee/create-employee");
        if(employeeId != null) {
            Employee employee = employeeDAO.findById(employeeId);
            if(employee != null) {
                CreateEmployeeFormBean form = new CreateEmployeeFormBean();
                form.setEmployeeId(employee.getId());
                form.setEmail(employee.getEmail());
                form.setFullName(employee.getFullName());
                form.setPassword(employee.getPassword());
                response.addObject("form", form);
            }
            else {
                response.addObject("errorMessage", "Employee was not found!");
            }
        }
        return response;

    }

}