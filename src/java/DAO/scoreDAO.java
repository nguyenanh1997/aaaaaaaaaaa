/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import entity.score;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
/**
 *
 * @author CNTT_anhN
 */
public class scoreDAO {
    public static List<score> findAll() throws ClassNotFoundException {
        List<score> ClassList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "select * from score";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                score std = new score(resultSet.getInt("student_id"), resultSet.getInt("class_id"), resultSet.getInt("score"));
                ClassList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return ClassList;
    }
    
    public static void insert(score std) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "insert into score(student_id, class_id, score) values(?,?,?)";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, std.getStudent_id());
            statement.setInt(2, std.getClass_id());
            statement.setInt(3, std.getScore());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void update(score std) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "update class set student_id = ?, class_id = ?, score = ?  where student_id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, std.getStudent_id());
            statement.setInt(2, std.getClass_id());
            statement.setInt(3, std.getScore());
            statement.setInt(4, std.getStudent_id());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void delete(int student_id, int class_id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "delete from score where student_id = ? or class_id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, student_id);
            statement.setInt(1, class_id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static List<score> findByClassId(int class_id) {
        List<score> ClassList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "select * from score where class_id = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+class_id+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                score std = new score(
                        resultSet.getInt("student_id"),
                        resultSet.getInt("class_id"),
                        resultSet.getInt("score")
                );
                ClassList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return ClassList;
    }
    
    public static List<score> findByClassIdStudentId(int class_id, int student_id) {
        List<score> ClassList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            //query
            String sql = "select * from score where class_id = ? and student_id = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, class_id);
            statement.setInt(2, student_id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                score std = new score(
                        resultSet.getInt("student_id"),
                        resultSet.getInt("class_id"),
                        resultSet.getInt("score")
                );
                ClassList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(scoreDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return ClassList;
    }
}
