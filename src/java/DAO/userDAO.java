/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import entity.user;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
/**
 *
 * @author CNTT_anhN
 */
public class userDAO {
    public static List<user> findAll() throws ClassNotFoundException {
        List<user> ClassList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "select * from user";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                user std = new user(resultSet.getInt("id"), resultSet.getString("username"), 
                        resultSet.getString("password"), resultSet.getString("email"), resultSet.getString("role_name"), 
                        resultSet.getString("class_name"));
                ClassList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return ClassList;
    }
    
    public static boolean insert(user std) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "insert into user( username, password, email, role_name, class_name) values(?,?,?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getUsername());
            statement.setString(2, std.getPassword());
            statement.setString(3, std.getEmail());
            statement.setString(4, std.getRole_name());
            statement.setString(5, std.getClass_name());
            
            boolean check = statement.execute();
            return check;
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return false;
    }
    
    public static int update(user std) {
        Connection connection = null;
        PreparedStatement statement = null;
        int check = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "update user set  username = ?, password = ?, email = ?, role_name = ?, class_name = ?  where username = ?";
            statement = connection.prepareCall(sql);
            

            statement.setString(1, std.getUsername());
            statement.setString(2, std.getPassword());
            statement.setString(3, std.getEmail());
            statement.setString(4, std.getRole_name());
            statement.setString(5, std.getClass_name());
            statement.setString(6, std.getUsername());
            
            check = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return check;
    }
    
    public static boolean delete(String username) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean check = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "delete from user where username = ? ";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, username);

            
            check = statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return check;
    }
    
    public static List<user> findByUsername(String username) {
        List<user> ClassList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "select * from user where username like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+username+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                user std = new user(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("role_name"),
                        resultSet.getString("class_name")
                );
                ClassList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return ClassList;
    }
    
    public static List<user> findProfile(String username) {
        List<user> ClassList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "select * from user where username = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, username);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                user std = new user(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),resultSet.getString("email"),
                        resultSet.getString("role_name"),resultSet.getString("class_name")
                );
                ClassList.add(std);
 
            }
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return ClassList;
    }
    
    public static String login(String username, String password){
        List<user> ClassList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "select * from user where username = ? and password = ? ";
            statement = connection.prepareCall(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            
            ResultSet resultSet = statement.executeQuery();
            
          
            if (resultSet.next() == false)
            {
                return null;
            }
            else{
                    return resultSet.getString("role_name");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return null;

    }
    
    public static List<user> findByRoleName(String role_name) {
        List<user> ClassList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "select * from user where role_name = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, role_name);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                user std = new user(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),resultSet.getString("email"),
                        resultSet.getString("role_name"),resultSet.getString("class_name")
                );
                ClassList.add(std);

            }
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return ClassList;
    }
    
    public static List<user> findByClassName(String class_name) {
        List<user> ClassList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "select * from user where class_name = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, class_name);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                user std = new user(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),resultSet.getString("email"),
                        resultSet.getString("role_name"),resultSet.getString("class_name")
                );
                ClassList.add(std);

            }
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return ClassList;
    }
}
