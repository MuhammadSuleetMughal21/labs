/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Ryan
 */
public class food_conn {
    Connection conn124 = null;
    
    public static Connection food_connection(){
        //"org.sqlite.JDBC"
        try{
            // Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection conn123 = DriverManager.getConnection("jdbc:derby://localhost:1527/food", "suleet", "123");
            System.out.println("connected");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            //System.out.println("connected");
            return null;
        }
        
    }
}
