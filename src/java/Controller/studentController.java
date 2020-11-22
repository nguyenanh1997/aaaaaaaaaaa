/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.*;
import entity.*;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author NA
 */

@Controller
public class studentController {
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile(ModelMap model, @CookieValue(value = "username") String username) throws ClassNotFoundException{
        List<user> users = userDAO.findProfile(username);

        model.put("users", users);

        return "profile";
    }
    
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public void editStudent(ModelMap model,@RequestParam("username") String username,@RequestParam("password") String password, 
            @RequestParam("email") String email, @RequestParam("role_name") String role_name, 
            @RequestParam("class_name") String class_name, @RequestParam("submit") String submit ) throws ClassNotFoundException{
            if(submit.compareTo("edit") == 0){
                user newUser = new user(username, password, email, role_name, class_name);
                int check = userDAO.update(newUser);
                if (check == 1){
                    model.put("message", "update thanh cong");
                }
                else{
                    model.put("message", "update khong thanh cong, de nghi xem lai thong tin update");
                }
            }else{
                if (submit.compareTo("delete") == 0){
                    boolean check = userDAO.delete(username);
                    if (check){
                    model.put("message", "xoa thanh cong");
                    }
                    else{
                        model.put("message", "xoa khong thanh cong, co loi khi xoa user");
                    }
                }
            }
        
           getProfile(model,username);
    }
    
    @RequestMapping(value = "/score", method = RequestMethod.GET)
    public String checkscore(ModelMap model, @CookieValue(value = "username") String username){
        List<user> users = userDAO.findProfile(username);
   
        List<score> scores = scoreDAO.findByClassIdStudentId(users.get(0).getClass_name(), users.get(0).getUsername());
        model.put("scores", scores);
        return "score";
        
    }
}
