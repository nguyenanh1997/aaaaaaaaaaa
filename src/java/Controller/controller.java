package Controller;
import entity.*;
import DAO.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String xinchao(@CookieValue("username") String username, @CookieValue("role_name") String role_name)
    {
        if(username != null && role_name != null)
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
            model.addAttribute("username", "tai khoan hoac mat khau khong dung!");
        }
        
        model.mergeAttributes(map);
        return "dashbroad";
    }
}
