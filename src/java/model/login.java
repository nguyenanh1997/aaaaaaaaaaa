/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author CNTT_anhN
 */
public class login {
    public boolean  check_Logined(Cookie[] cookies){
        boolean result = false;
        if (cookies.length == 0 ) {
            return false;
        } else {
            for (Cookie cookie : cookies ){
                if(cookie.getName().compareTo("role_id") == 0 || cookie.getName().compareTo("username") == 0 )
                {
                    result = true;
                }
                else{
                    return false;
                }
                
            }
        }
        return result;
    }
}
