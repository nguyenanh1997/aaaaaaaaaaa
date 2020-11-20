/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.*;
import java.util.List;
import entity.*;
/**
 *
 * @author CNTT_anhN
 */
public class Main {
    public static void main(String args[]) throws ClassNotFoundException{
        System.out.println(userDAO.findByUsername("a"));

    }
}
