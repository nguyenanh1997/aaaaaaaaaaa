/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author CNTT_anhN
 */

import DAO.*;
import entity.*;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class adminController {
    @RequestMapping(value = "/studentManager", method = RequestMethod.GET)
    public String getStudentManager(ModelMap model) throws ClassNotFoundException{
        List<user> users = userDAO.findByRoleName("student");
        List<role> listrole = roleDAO.findAll();
        model.put("listrole", listrole);
        model.put("users", users);

        return "userManager";
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchUser(ModelMap model, @RequestParam("username") String username) throws ClassNotFoundException{
        List<user> users = userDAO.findByUsername(username);
        List<role> listrole = roleDAO.findAll();
        model.put("listrole", listrole);
        model.put("users", users);
        return "userManager";
    }
    
    @RequestMapping(value = "/userManager", method = RequestMethod.GET)
    public String getUserManager(ModelMap model) throws ClassNotFoundException{
        List<user> users = userDAO.findAll();
        List<role> listrole = roleDAO.findAll();
        model.put("listrole", listrole);
        model.put("users", users);

        return "userManager";
    }
    
    @RequestMapping(value = "/userManager", method = RequestMethod.POST)
    public void editUser(ModelMap model,@RequestParam("id") int id, @RequestParam("username") String username,@RequestParam("password") String password, 
            @RequestParam("email") String email, @RequestParam("role_name") String role_name, 
            @RequestParam("submit") String submit ) throws ClassNotFoundException{
            if(submit.compareTo("edit") == 0){
                user newUser = new user(id, username, password, email, role_name);
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
        
           getUserManager(model);
    }

    
    
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String getPage(ModelMap model) throws ClassNotFoundException{
        List<classs> listclass = classsDAO.findAll();
        List<role> listrole = roleDAO.findAll();
        model.put("listclass", listclass);
        model.put("listrole", listrole);
        
        return "addStudent";
    }
    
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String postUser(ModelMap model, @RequestParam("username") String username, @RequestParam("password") String password,
            @RequestParam( value = "email", required=false ) String email, @RequestParam(value="role_name", required=false) String role_name, 
            @RequestParam(value = "class_name", required=false) String class_name) throws ClassNotFoundException{
        if (username.isEmpty() || password.isEmpty())
        {
            model.put("message", "de nghi nhap username va password");
        }
        if(userDAO.findByUsername(username).isEmpty())
        {
            user newUser = new user(username, password, email, role_name, class_name);
            boolean check = userDAO.insert(newUser);
            model.put("message", "insert thanh cong");
        }
        else{
            model.put("message", "username khong hop le");
        }
        List<classs> listclass = classsDAO.findAll();
        List<role> listrole = roleDAO.findAll();
        model.put("listclass", listclass);
        model.put("listrole", listrole);
        
        return "addStudent";
        
    }
    
    
    @RequestMapping(value = "/studentManager", method = RequestMethod.POST)
    public void editStudent(ModelMap model,@RequestParam("id") int id, @RequestParam("username") String username,@RequestParam("password") String password, 
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
        
           getStudentManager(model);
    }

    
    @RequestMapping(value = "/teacherManager", method = RequestMethod.GET)
    public String getTeacherManager(ModelMap model) throws ClassNotFoundException{
        List<user> users = userDAO.findByRoleName("teacher");
        List<role> listrole = roleDAO.findAll();
        model.put("listrole", listrole);
        model.put("users", users);

        return "userManager";
    }
      
    
    @RequestMapping(value = "/teacherManager", method = RequestMethod.POST)
    public void editTeacher(ModelMap model,@RequestParam("id") int id, @RequestParam("username") String username,@RequestParam("password") String password, 
            @RequestParam("email") String email, @RequestParam("role_name") String role_name, 
            @RequestParam("class_name") String class_name, @RequestParam("submit") String submit ) throws ClassNotFoundException{
            if(submit.compareTo("edit") == 0){
                user newUser = new user(id, username, password, email, role_name, class_name);
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
        
           getTeacherManager(model);
    }

    
    @RequestMapping(value = "/adminManager", method = RequestMethod.GET)
    public String getAdminManager(ModelMap model) throws ClassNotFoundException{
        List<user> users = userDAO.findByRoleName("admin");
        List<role> listrole = roleDAO.findAll();
        model.put("listrole", listrole);
        model.put("users", users);

        return "userManager";
    }
      
    
    @RequestMapping(value = "/adminManager", method = RequestMethod.POST)
    public void editAdmin(ModelMap model,@RequestParam("id") int id, @RequestParam("username") String username,@RequestParam("password") String password, 
            @RequestParam("email") String email, @RequestParam("role_name") String role_name, 
            @RequestParam("submit") String submit ) throws ClassNotFoundException{
            if(submit.compareTo("edit") == 0){
                user newUser = new user(id, username, password, email, role_name);
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
        
           getAdminManager(model);
    }

    
    
}
