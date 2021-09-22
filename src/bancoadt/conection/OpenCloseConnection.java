/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoadt.conection;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2dam
 */
public class OpenCloseConnection {
    
    private ResourceBundle configFile;
    private String url, user, pass;
    
    public OpenCloseConnection() {
        
        configFile = ResourceBundle.getBundle("config");
        url = configFile.getString("Conn");
        user = configFile.getString("DBUser");
        pass = configFile.getString("DBPass");
        
    }
    
    public Connection openConnection() throws ConnectException {
        
        Connection con = null;
        
        try {
            con = DriverManager.getConnection(url,user,pass);
        } catch (SQLException ex) {
            throw new ConnectException("Error al conectar con la base de datos");
        }
        
        return con;
        
    }
    
    public void closeConnection(PreparedStatement stat, Connection con) throws ConnectException {
        
        if (stat != null || con != null) {
            try {
                stat.close();
                con.close();
            } catch (SQLException ex) {
                throw new ConnectException("Error al desconectar con la base de datos"); 
            }
        }
        
        
    }
    
    
}
