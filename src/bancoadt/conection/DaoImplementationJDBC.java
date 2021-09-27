/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoadt.conection;

import bancoadt.clases.Account;
import bancoadt.clases.Customer;
import bancoadt.clases.Movement;
import bancoadt.utilidades.Util;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Steven,Irkus,Unai y Adrian
 */
public class DaoImplementationJDBC implements Dao{
    
    private Connection con;
    private PreparedStatement stat;
    private final OpenCloseConnection connection = new OpenCloseConnection();
    
    private final String insertarCliente = "insert into customer (city,email,firstName,lastName,middleInitial,phone,state,street,zip) values (?,?,?,?,?,?,?,?,?)";
    private final String buscarIdCliente = "select * from customer where id = ?";
    private final String buscarMovimientos = "select * from movement where account_id = ?";
    
   
  
   
    private Customer comprobarIdCliente(Customer cli) {
        
        ResultSet rs = null;
       
          try {
            con = connection.openConnection();
        } catch (ConnectException ex) {
            Logger.getLogger(DaoImplementationJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
            stat = con.prepareStatement(buscarIdCliente);
            stat.setLong(1, cli.getId());
            rs = stat.executeQuery();
            if (rs == null) {
                return null;
            } else {
                Customer cust = new Customer();
                cust.setId(rs.getLong("customer.id"));
                cust.setCity(rs.getString("customer.city"));
                cust.setEmail(rs.getString("customer.email"));
                cust.setFirstName(rs.getString("customer.firstName"));
                cust.setLastName(rs.getString("customer.lastName"));
                cust.setMiddleName(rs.getNString("customer.middleName"));
                cust.setPhone(rs.getLong("customer.phone"));
                cust.setState(rs.getString("customer.state"));
                cust.setStreet(rs.getString("customer.street"));
                cust.setZip(rs.getLong("customer.zip"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoImplementationJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            connection.closeConnection(stat, con);
        } catch (ConnectException ex) {
            Logger.getLogger(DaoImplementationJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cli;
    }
    
    @Override
    public void crearCliente() {
        
        ResultSet rs = null;     
        
        try {
            con = connection.openConnection();
        } catch (ConnectException ex) {
            Logger.getLogger(DaoImplementationJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
            stat = con.prepareStatement(insertarCliente);
            
            stat.setString(1, Util.introducirCadena("Introduce tu ciudad:"));
            stat.setString(2, Util.introducirCadena("Introduce tu tu email:"));
            stat.setString(3, Util.introducirCadena("Introduce tu nombre:"));
            stat.setString(4, Util.introducirCadena("Introduce tu apellido:"));
            stat.setString(5, Util.introducirCadena("Introduce tu inicial de segundo nombre:"));
            stat.setLong(6, Util.leerLong("Introduce tu telefono:"));
            stat.setString(7, Util.introducirCadena("Introduce tu provincia"));
            stat.setString(8, Util.introducirCadena("Introduce tu direccion"));
            stat.setString(9, Util.introducirCadena("Introduce tu codigo postal"));
            
            rs = stat.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoImplementationJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            connection.closeConnection(stat, con);
        } catch (ConnectException ex) {
            Logger.getLogger(DaoImplementationJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }

    @Override
    public Customer consultarCliente() {
        
        Customer cli = new Customer();
        cli.setId(Util.leerLong("Introduce la id del cliente a buscar:"));
               
        if (comprobarIdCliente(cli) == null) {
            System.out.println("El cliente no se ha encontrado");
        } 
        return cli;
    }

    @Override
    public List consultarCuentaCliente(Customer cust) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearCuenta(Customer cust) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarClienteCuenta(Account acco, Customer cust) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Account consultarDatosCuenta(Account acco) {
        //Lo hace adrian
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void realizarMovimiento(Account acco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List consultarMovimientos(Account acco) {
        
        List <Movement> movements = new ArrayList<>();
        ResultSet rs = null;
       
          try {
            con = connection.openConnection();
        } catch (ConnectException ex) {
            Logger.getLogger(DaoImplementationJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
            stat = con.prepareStatement(buscarMovimientos);
            stat.setLong(1, acco.getId());
            rs = stat.executeQuery();
            
            while(rs.next()){
                
                Movement mov = new Movement();
                
                mov.setId(rs.getLong("movement.id"));
                mov.setAmount(rs.getLong("movement.amount"));
                mov.setBalance(rs.getFloat("movement.balance"));
                mov.setDescription(rs.getString("movement.description"));
                mov.setTimeStamp(rs.getDate("movement.timestamp").toLocalDate());
                
                movements.add(mov);
                 
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoImplementationJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            connection.closeConnection(stat, con);
        } catch (ConnectException ex) {
            Logger.getLogger(DaoImplementationJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return movements;
    }
    
    
    
    
    
}
