/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoadt.conection;

import bancoadt.clases.Account;
import bancoadt.clases.Customer;
import java.util.List;

/**
 *
 * @author 2dam
 */
public interface Dao {
    
    public int crearCliente();
    public Customer consultarCliente(int id);
    public List consultarCuentaCliente(Customer cust);
    public void crearCuenta(Customer cust);
    public void agregarClienteCuenta(Account acco, Customer cust);
    public Account consultarCuenta(int id);
    public void realizarMovimiento(Account acco);
    public List consultarMovimientos(Account acco);
    
}
