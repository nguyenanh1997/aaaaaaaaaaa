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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author NA
 */
@Controller
public class teacherController {
    @RequestMapping(value = "/addClass" , method=RequestMethod.GET)
    public String addClass()
    {
        return "addClass";
    }
    
    @RequestMapping(value = "/addClass", method=RequestMethod.POST)
    public String postAddClass(@RequestParam("class_name") String class_name, ModelMap model) throws ClassNotFoundException{
        classs newClass;
        newClass = new classs(class_name);
        int check = classsDAO.insert(newClass);
        if (check == 0 )
        {
            model.put("message", "co looi xay ra!");
        }
        else
        {
            model.put("message", "tao lop hoc thanh cong");
        }
        return "addClass";
    }
    
    @RequestMapping(value = "/classList" , method=RequestMethod.GET)
    public String getClassList(ModelMap model) throws ClassNotFoundException
    {
        List<classs> listClass = classsDAO.findAll();
        model.put("classList", listClass);
        return "classList";
    }
    
    @RequestMapping(value = "/classList", method=RequestMethod.POST)
    public void postclassList(@RequestParam("class_name") String class_name,@RequestParam("class_id") int class_id, @RequestParam("submit") String submit, ModelMap model) throws ClassNotFoundException{
        if(submit.compareTo("edit") == 0){
            int check = classsDAO.update((new classs(class_id,class_name)));
            if (check == 0)
            {
                model.put("message", "edit khong thanh cong");
            }else{
                model.put("message", "edit thanh cong!");
            }

        }
        else{
            if(submit.compareTo("delete") == 0){
                int check = classsDAO.delete(class_name);
                if (check == 0)
                {
                    model.put("message", "xoa khong thanh cong");
                }else{
                    model.put("message", "xoa thanh cong!");
                }
            }
         
        }
        getClassList(model);
    }
        
    
    @RequestMapping(value = "/addStudentToClass", method=RequestMethod.GET)
    public String addStudentToClass(ModelMap model) throws ClassNotFoundException{
        List<classs> listClass = classsDAO.findAll();
        List<user> listStudent = userDAO.findByRoleName("student");
        model.put("listuser", listStudent);
        model.put("listclass", listClass);
        return "addStudentToClass";
    }
    
}
