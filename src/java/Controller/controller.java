package Controller;
import entity.*;
import DAO.*;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CNTT_anhN
 */

@Controller

public class controller {
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String xinchao(@CookieValue(value = "username", defaultValue = "hello") String username, @CookieValue(value = "role_name", defaultValue = "hello") String role_name)
    {
        if(username.compareTo("hello") != 0  && role_name.compareTo("hello") != 0)
        {
            return "dashbroad";
        }
        return "login";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String postLogin(HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password, Model model){
        Map<String, String> map = new HashMap<>();
        
        String role_id = userDAO.login(username, password);
        
        if (role_id != null){

            map.put("spring", "mvc");
            model.addAttribute("username", username);
            Cookie role_cookie = new Cookie("role_name", role_id);
            Cookie username_cookie = new Cookie("username" , username );
            response.addCookie(role_cookie);
            response.addCookie(username_cookie);
        }else
        {
            map.put("spring", "mvc");
            model.addAttribute("message", "tai khoan hoac mat khau khong dung!");
            return "login";
        }
        
        model.mergeAttributes(map);
        return "dashbroad";
    }
    
    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout(HttpServletResponse response){
        Cookie username = new Cookie("username", "");
        Cookie role_name = new Cookie("role_name", "");
        username.setMaxAge(0);
        role_name.setMaxAge(0);
        response.addCookie(username);
        response.addCookie(role_name);
        return "redirect:" + "login.htm";
    }
}
