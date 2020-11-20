/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import entity.teacher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NA
 */
public class teacherDAO {
    public static List<teacher> findAll() throws ClassNotFoundException {
        List<teacher> teacherList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "select * from teacher";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                teacher std = new teacher(resultSet.getInt("id"), resultSet.getInt("role_id"), resultSet.getInt("class_id"),  resultSet.getString("name"), resultSet.getString("email"));
                teacherList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return teacherList;
    }
    
    public static void insert(teacher std) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "insert into teacher(name, email, role_id, class_id) values(?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getName());
            statement.setString(2, std.getEmail());
            statement.setInt(3, std.getRole_id());
            statement.setInt(4, std.getClass_id());

            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void update(teacher std) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "update teacher set name=?,email=?,role_id=?,class_id=? where name = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getName());
            statement.setString(2, std.getEmail());
            statement.setInt(3, std.getRole_id());
            statement.setInt(4, std.getClass_id());
            statement.setString(5, std.getName());

            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void delete(String name) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "delete from teacher where name = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, name);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static List<teacher> findByFullname(String name) throws ClassNotFoundException {
        List<teacher> teacherList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "select * from teacher where name like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+name+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                teacher std = new teacher(resultSet.getInt("id"),
                        resultSet.getInt("role_id"), resultSet.getInt("class_id"),
                        resultSet.getString("name"), resultSet.getString("email") 
                );
                teacherList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return teacherList;
    }
}
