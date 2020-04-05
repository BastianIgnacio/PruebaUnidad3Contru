/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubtenis;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author macbook
 */
public class Reserva {

    private Cliente cliente;
    private int cancha;
    private int hora;
    private LocalDate fecha;
    private int monto;
    private String estado;
    
    public Reserva(Cliente cliente, int cancha, int hora, LocalDate fecha, int monto, String estado) {
        this.cliente = cliente;
        this.cancha = cancha;
        this.hora = hora;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCancha() {
        return cancha;
    }

    public void setCancha(int cancha) {
        this.cancha = cancha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void cancelarReserva()
    {
        this.estado="cancelada";
    }
}
