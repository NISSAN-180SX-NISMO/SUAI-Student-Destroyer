package io.swagger.configuration;


import io.swagger.DataBase.servises.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Home redirection to swagger api documentation 
 */
@Controller
public class HomeController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "index";
    }
}
