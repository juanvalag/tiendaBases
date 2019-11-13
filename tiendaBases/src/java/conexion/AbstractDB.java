/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;

/**
 *
 * @author LUZDA
 */
public abstract class AbstractDB {
    
    protected Connection conexionSQL;

    public AbstractDB() 
    
    {
        ConnectionDB x=new ConnectionDB();
        this.conexionSQL = x.getConn();
    }
    
    
    
}
