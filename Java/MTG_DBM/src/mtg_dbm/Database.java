/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtg_dbm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author reticent
 */
public class Database {
    
    //Declared Variables
    Connection connect;
    PreparedStatement preparedStatement;
    Statement statement;
    ResultSet resultSet;
    String user;
    String password;
    String url;

    /**
     *  Database()
     * --------------------------
     * Default constructor for Database class that establishes
     * connection to mySQL db "sims_dbm".
     */
    public Database()
    {
        url = "jdbc:mysql://localhost/temp_mtg?";
        user = "root";
        password = "q1w2e3r4";
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    /**
     *  Database(String url, String user, String password)
     * --------------------------
     * 3 parameter constructor for Database class that establishes
     * connection to mySQL db with user provided parameters.
     * @param url
     * @param user
     * @param password 
     */
    public Database(String url, String user, String password)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public boolean createNewUser(String username, char [] password)
    {
        try
        {
            preparedStatement = connect.
                    prepareStatement("INSERT INTO User (Username, Password, Role) VALUES (?,?,?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,new String(password));
            preparedStatement.setString(3,"User");
            preparedStatement.executeUpdate();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean checkLogin(String username, String password)
    {
        try
        {
            preparedStatement = connect.
                    prepareStatement("SELECT * FROM User WHERE Username =? AND Password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next())
            {
                return true;   
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
