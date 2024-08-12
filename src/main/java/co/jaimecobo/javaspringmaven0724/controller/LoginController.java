package co.jaimecobo.javaspringmaven0724.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/account")
public class LoginController {


    @GetMapping("/loginPageUrl")
    public ModelAndView loginPage(){
            ModelAndView response = new ModelAndView("auth/login");
        return response;
    }

}
