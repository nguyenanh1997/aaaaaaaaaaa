/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
/**
 *
 * @author NA   
 */
public class user implements  Serializable {
    public int id;
    public String username;
    public String password, email, role_name, class_name;

    public user(String username, String email, String role_name, String class_name) {
        this.username = username;
        this.email = email;
        this.role_name = role_name;
        this.class_name = class_name;
    }
    
    public user(String username, String email, String role_name) {
        this.username = username;
        this.email = email;
        this.role_name = role_name;

    }
    
    
    
    public user(int id, String username, String password , String email, String role_name) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role_name = role_name;

    }
    
    public user(String username, String password , String email, String role_name, String class_name) {
        this.username = username;
        this.password = password;
        this.role_name = role_name;
        this.class_name = class_name;
    }
    
    
    public user(int id, String username, String password , String email, String role_name, String class_name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role_name = role_name;
        this.class_name = class_name;
    }
    
    
    public user() {
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
            
}
