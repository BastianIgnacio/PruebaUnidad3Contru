/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubtenis;

/**
 *
 * @author macbook
 */
public class Pago {

    private Cliente cliente;
    private int mes;
    private int ano;
    private int monto;
    private boolean pagoAtrasado;
    private  int pagoReal;
    
    public Pago(Cliente cliente, int mes, int ano, int monto, boolean pagoAtrasado, int pagoReal) {
        this.cliente = cliente;
        this.mes = mes;
        this.ano = ano;
        this.monto = monto;
        this.pagoAtrasado = pagoAtrasado;
        this.pagoReal = pagoReal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public boolean isPagoAtrasado() {
        return pagoAtrasado;
    }

    public void setPagoAtrasado(boolean pagoAtrasado) {
        this.pagoAtrasado = pagoAtrasado;
    }

    public int getPagoReal() {
        return pagoReal;
    }

    public void setPagoReal(int pagoReal) {
        this.pagoReal = pagoReal;
    }
    
    
    
    
    
}
