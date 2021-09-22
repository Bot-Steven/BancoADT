/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoadt;

import bancoadt.conection.DaoImplementationJDBC;

/**
 *
 * @author 2dam
 */
public class BancoADT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int menu;
        DaoImplementationJDBC daoI = new DaoImplementationJDBC();
        
        do{
        
            System.out.println("---------MENU---------");
            System.out.println("1.- Crear un cliente");
            System.out.println("2.- Consultar datos de un cliente");
            System.out.println("3.- Consultar cuentas de un cliente");
            System.out.println("4.- Crear cuenta para un cliente");
            System.out.println("5.- Agregar cliente a cuenta");
            System.out.println("6.- Consultar datos de una cuenta");
            System.out.println("7.- Realizar movimiento");
            System.out.println("8.- Consultar movimientos");
            System.out.println("0.- Salir");
            menu = Util.leerInt("--> ");

            while(menu<0 || menu>8){
                System.out.println("Opcion no disponible. Vuelve a intentarlo");
                menu = Util.leerInt("--> ");
            }
            
            switch(menu){

                case 1:
                    daoI.crearCliente();
                    break;

                case 2:
                    daoI.consultarCliente();
                    break;

                case 3:
                    daoI.consultarCuentaCliente();
                    break;

                case 4:
                    daoI.crearCuenta();
                    break;

                case 5:
                    daoI.agregarClienteCuenta();
                    break;

                case 6:
                    daoI.consultarCuenta();
                    break;

                case 7:
                    daoI.realizarMovimiento();
                    break;

                case 8:
                    daoI.consultarMovimientos();
                    break;
            }
        }while(menu!=0);
    }
    
}
