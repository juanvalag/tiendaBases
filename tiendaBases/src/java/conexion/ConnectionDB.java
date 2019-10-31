/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB 
{
    private final String url;
    private final String username;
    private final String password;
    private Connection conn;
    
    public ConnectionDB() 
    {        
        this.url = "jdbc:mysql://localhost:3306/tiendaBases";
        this.username = "root";
        this.password = "MySQLRoot";
        try 
        {
            // Class.forName("com.mysql.cj.jdbc.Driver").newInstance();//para MySQL 8.x..x
            //Class.forName("com.mysql.jdbc.Driver").newInstance();//para MySQL 5.x..x
            
            this.conn = DriverManager.getConnection(this.url, this.username, this.password);
            if(this.conn!=null)
                System.out.println("Todo bien..estamos conectados..!!");
        } 
        catch (SQLException e) 
        {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }         

    }
    
    public Connection getConn() {
        return conn;
    }
    public void cierraConexion()
    {        
        try 
        {
            this.conn.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}