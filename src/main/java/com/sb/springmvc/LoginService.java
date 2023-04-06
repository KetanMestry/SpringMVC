package com.sb.springmvc;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateUser(String name, String password){
        System.out.println("name " + name );
        return name.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin");

    }
}
