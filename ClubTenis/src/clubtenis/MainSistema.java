/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubtenis;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author macbook
 */
public class MainSistema {

    
    
    private ArrayList<Cliente> clientes;
    private ArrayList<Reserva> reservas;
    private ArrayList<Pago> pagos;
    
    
    
    
    public MainSistema() {
        this.clientes = new ArrayList();
        this.reservas = new ArrayList();
        this.pagos = new ArrayList();
        
    }
    
    
    public void iniciar()
    {   
        String opc;
        Scanner teclado = new Scanner(System.in);
        while(true)
        {
            System.out.print("Introduzca opcion : ");
            opc = teclado.nextLine();
            if(opc.equals("0"))
            {
                System.out.println("salida");
                break;
            }
            if(opc.equals("1"))
            {
                System.out.println(opc);
            }
            if(opc.equals("2"))
            {
                 System.out.println(opc);
            }
            if(opc.equals("3"))
            {
                 System.out.println(opc);
            }
            
            
            
        
        }
        
        
    
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public ArrayList<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(ArrayList<Pago> pagos) {
        this.pagos = pagos;
    }
    
    
    
}
