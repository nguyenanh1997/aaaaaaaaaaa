/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import entity.classs;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
/**
 *
 * @author CNTT_anhN
 */
public class classsDAO {
    public static List<classs> findAll() throws ClassNotFoundException {
        List<classs> ClassList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "select * from class";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                classs std = new classs(resultSet.getInt("class_id"), resultSet.getString("class_name"));
                ClassList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return ClassList;
    }
    
    public static void insert(classs std) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "insert into class(class_name) values(?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getClass_name());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void update(classs std) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "update class set class_name=? where class_name = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getClass_name());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void delete(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "delete from class where name = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, name);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static List<classs> findByFullname(String name) {
        List<classs> ClassList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "select * from class where name like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+name+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                classs std = new classs(
                        resultSet.getInt("class_id"),
                        resultSet.getString("class_name")
                );
                ClassList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return ClassList;
    }
    
    public static List<classs> findId() {
        List<classs> ClassList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "select * from class";
            statement = connection.prepareCall(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                classs std = new classs(
                        resultSet.getInt("class_id"),
                        resultSet.getString("class_name")
                );
                ClassList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(classsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return ClassList;
    }
}
