package com.sb.springmvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping("/login")
    public String loginPage(){
        System.out.println("Inside login page");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(ModelMap model, @RequestParam String name, @RequestParam String password) {
        boolean isValidUser = service.validateUser(name, password);
        if (!isValidUser) {
            model.put("errmsg", "Enter valid credentials");
            return "login";
        } else {
            model.put("name", name);
            model.put("password", password);
            System.out.println("Inside home page");
            return "home";
        }

    }

    @RequestMapping("/home")
    public String homepage(){
        System.out.println("inside home page");
        return "home";
    }

    @RequestMapping("/third")
    public  String thirdPage(){
        System.out.println("Inside third page");
        return "third";
    }
}
