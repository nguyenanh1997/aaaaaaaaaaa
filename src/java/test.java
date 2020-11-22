/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NA
 */
import DAO.studentDAO;
import entity.student;

public class test {
    public static void main(String args[]) throws ClassNotFoundException{
        studentDAO a = new studentDAO();
        student b = new student(1,1,1,"nguyen anh", "adadsad");
        a.insert(b);
    }
}
