/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import entity.manager;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
/**
 *
 * @author CNTT_anhN
 */
public class managerDAO {
    public static List<manager> findAll() throws ClassNotFoundException {
        List<manager> managerList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "select * from manager";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                manager std = new manager(resultSet.getInt("id"), resultSet.getInt("role_id"),  resultSet.getString("name"), resultSet.getString("email"));
                managerList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return managerList;
    }
    
    public static void insert(manager std) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "insert into manager(name, email, role_id) values(?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getName());
            statement.setString(2, std.getEmail());
            statement.setInt(3, std.getRole_id());


            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void update(manager std) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "update manager set name=?,email=?,role_id=? where name = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getName());
            statement.setString(2, std.getEmail());
            statement.setInt(3, std.getRole_id());
            statement.setString(4, std.getName());

            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            String sql = "delete from manager where name = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, name);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static List<manager> findByFullname(String name) {
        List<manager> managerList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "select * from manager where name like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+name+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                manager std = new manager(
                        resultSet.getInt("id"),resultSet.getInt("role_id"),
                        resultSet.getString("name"), resultSet.getString("email") 
                );
                managerList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(managerDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return managerList;
    }

}
