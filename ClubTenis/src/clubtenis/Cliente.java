/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubtenis;

import java.util.ArrayList;

/**
 *
 * @author macbook
 */
public class Cliente {
    
    private ArrayList<Multa> multas;
    private String rut;
    private String nombre;
    private String apellido;
    
    public Cliente(String rut, String nombre, String apellido) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.multas = new ArrayList();
    }
    
    public void addMulta(Multa m)
    {
        this.multas.add(m);
    }
    
    
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void imprimirMultas()
    {
        for(Multa m : this.multas)
        {
            if(m.getEstado().endsWith("NoPagada"))
            {
                String id = String.valueOf(m.getIdMulta());
                String descripcion = m.getDescripcion();
                String monto = String.valueOf(m.getMonto());
                System.out.println(" ID MULTA : " + id + "  Dscripcion :" + descripcion + "  monto:" + monto);
            }
        }
    
    }
    
    public void pagarMulta(String idMulta)
    {
        int id = Integer.parseInt(idMulta);
        for(Multa m : this.multas)
        {
            if(m.getIdMulta()==id)
            {
                m.pagar();
            }
        }
    }
    
    
    
    
    
    
    
}
