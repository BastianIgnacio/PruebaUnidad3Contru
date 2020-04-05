/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubtenis;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author macbook
 */
public class MainSistema {

    
    
    private ArrayList<Cliente> clientes;
    private ArrayList<Reserva> reservas;
    private ArrayList<Pago> pagos;
    
    private int multa;
    
    
    
    
    public MainSistema() {
        this.clientes = new ArrayList();
        this.reservas = new ArrayList();
        this.pagos = new ArrayList();
        this.multa = 1;
        
    }
    
    
    public void iniciar()
    {   
        String opc;
        Scanner teclado = new Scanner(System.in);
        while(true)
        {
            System.out.println("************************");
            mostrarMenu();
            System.out.print("Introduzca opcion : ");
            opc = teclado.nextLine();
            if(opc.equals("0"))
            {
                System.out.println("salida");
                break;
            }
            if(opc.equals("1"))
            {
                verificarSocio();
            }
            if(opc.equals("2"))
            {
                ingresarCliente();
            }
            if(opc.equals("3"))
            {
                 ingresarMulta();
            }
            if(opc.equals("4"))
            {
                realizarReserva();
            }
            if(opc.equals("5"))
            {
                cancelarReserva();
            }
            if(opc.equals("6"))
            {
                mostrarMultasNoPagadas();
            }
            if(opc.equals("7"))
            {
                pagarMulta();
            }
            if(opc.equals("8"))
            {
                realizarPago();
            }
        }
        
    }
    
    private void mostrarMenu()
    {
        System.out.println("Opciones : ");
        System.out.println("0) Salir ");
        System.out.println("1) Verificar Cliente ");
        System.out.println("2) Ingresar Nuevo Cliente");
        System.out.println("3) Ingresar Multa");
        System.out.println("4) Ingresar Nueva Reserva");
        System.out.println("5) Cancelar reserva");
        System.out.println("6) Mostrar Multas No Pagadas");
        System.out.println("7) Pagar una Multa");
        System.out.println("8) Pagar membresia y multas");
    }

    // opcion 1
    private void verificarSocio()
    {
        System.out.println("Mostrando FOTO.....");
    
    }
    // opcion 2
    private void ingresarCliente()
    {
  
        String nombre;
        String apellido;
        String rut;
        
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Rut: ");
        rut = teclado.nextLine();
        
        for(Cliente cli : this.clientes)
        {
            if(cli.getRut().equals(rut))
            {
                System.out.println("************************");
                System.out.println("NO ES POSIBLE INGRESAR CLIENT, Ya existe el cliente con rut : " + rut);
                System.out.println("************************");
                return;
            }
        }
        
        System.out.print("Nombre: ");
        nombre = teclado.nextLine();
        
        System.out.print("Apellido: ");
        apellido = teclado.nextLine();
        
        Cliente c = new Cliente(rut,nombre,apellido);
        
        System.out.println("************************");
        System.out.println("Cliente ingresado satisfactoriamente ");
        System.out.println("************************");
        this.clientes.add(c);
    }
    // opcion 3
    private void ingresarMulta()
    {
        int montoMulta;
        String rut;
        String descripcion;
        
        
        Scanner teclado = new Scanner(System.in);
        System.out.print("Rut Cliente Multado: ");
        rut = teclado.nextLine();
        
         Cliente cliente = null;
        for(Cliente cli : this.clientes)
        {
            if(cli.getRut().equals(rut))
            {
                cliente = cli;
            }
        }
        if(cliente!=null)
        {
            System.out.print("Ingresar Multa: ");
            String ms = teclado.nextLine();
            montoMulta = Integer.valueOf(ms);

            System.out.println("Descripcion de la multa: ");
            descripcion = teclado.nextLine();
            
            Date d = new Date();
            Multa objMulta = new Multa(this.multa,descripcion,montoMulta,d,"NoPagada");
            cliente.addMulta(objMulta);
            this.multa++;
            System.out.println("***************");
            System.out.println("Multa Agregada Satisfactoriamente");
            System.out.println("***************");
            return;
            

        }
        else
        {
            System.out.println("***************");
            System.out.println("Cliente no existe");
            System.out.println("***************");
            return;
        }
    }
    // opcion 4
    private void realizarReserva()
    {
        int hora;
        int cancha;
        LocalDate fecha;
        int monto;
        
        String rut;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Rut Cliente a reservar: ");
        rut = teclado.nextLine();
        
        Cliente cliente = null;
        for(Cliente cli : this.clientes)
        {
            if(cli.getRut().equals(rut))
            {
                cliente = cli;
            }
        }
        if(cliente!=null)
        {
            hora = leerHora("Ingresar Hora :");
            cancha = leerCancha("Ingresar Cancha: ");
            System.out.println("Ingresar fecha de reserva (yyyy-MM-dd): ");
            String sf = teclado.nextLine();
            fecha = LocalDate.parse(sf);
            monto = calcularMonto(hora,fecha);
            
            if(horarioDisponible(cancha,hora,sf))
            {
                Reserva r = new Reserva(cliente,cancha,hora,fecha,monto,"reservada");
                this.reservas.add(r);
                System.out.println("***************");
                System.out.println("Reserva ingresada correctamente");
                System.out.println("***************");
                
            }
            else
            {
                System.out.println("no se puede agregar");
            }
            
        }
        else
        {
            System.out.println("***************");
            System.out.println("Cliente no existe");
            System.out.println("***************");
            return;
        }
        
        
    
    }
    // opcion 5
    private void cancelarReserva()
    {
        int hora;
        int cancha;
        LocalDate fecha;
        int monto;
        
        String rut;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Rut Cliente a cancelar: ");
        rut = teclado.nextLine();
        
        Cliente cliente = null;
        for(Cliente cli : this.clientes)
        {
            if(cli.getRut().equals(rut))
            {
                cliente = cli;
            }
        }
        if(cliente!=null)
        {
            hora = leerHora("Ingresar Hora :");
            cancha = leerCancha("Ingresar Cancha: ");
            System.out.println("Ingresar fecha de reserva (yyyy-MM-dd): ");
            String sf = teclado.nextLine();
            fecha = LocalDate.parse(sf);
            cancelarReservaDeCliente(cliente,fecha,cancha,hora);
        }
        
    
    }
    // opcion 6
    private void mostrarMultasNoPagadas()
    {
        String rut;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Rut Cliente a cancelar: ");
        rut = teclado.nextLine();
        
        Cliente cliente = null;
        for(Cliente cli : this.clientes)
        {
            if(cli.getRut().equals(rut))
            {
                cliente = cli;
            }
        }
        if(cliente!=null)
        {
            cliente.imprimirMultas();
        }
    }
    // opcion 7
    private void pagarMulta()
    {
        String rut;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Rut Cliente a cancelar: ");
        rut = teclado.nextLine();
        
        Cliente cliente = null;
        for(Cliente cli : this.clientes)
        {
            if(cli.getRut().equals(rut))
            {
                cliente = cli;
            }
        }
        if(cliente!=null)
        {
            try
            {
                String idMulta = teclado.nextLine();
                cliente.pagarMulta(idMulta);
                System.out.println("Multa Pagada Satisfactoriamente");
            }
            catch(Exception e)
            {
                System.out.println("Error, Ingresar un id como entero");
            }
        }
        else
        {
            System.out.println("***********");
            System.out.println("Cliente no existe");
            System.out.println("***********");
        }
        
    }
    // opcion 8
    private void realizarPago()
    {
        String rut;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Rut Cliente a realizar pago : ");
        rut = teclado.nextLine();
        Cliente cliente = null;
        for(Cliente cli : this.clientes)
        {
            if(cli.getRut().equals(rut))
            {
                cliente = cli;
            }
        }
        if(cliente!=null)
        {
            System.out.println("Ingresar fecha de reserva (yyyy-MM-dd): ");
            String sf = teclado.nextLine();
            LocalDate fecha = LocalDate.parse(sf);
            int ano = fecha.getYear();
            int month = fecha.getMonthValue();
            int day = fecha.getDayOfMonth();
            
            int montoDeuda = cliente.getMontoDeuda() + 20000;
            
            for(Reserva r : this.reservas)
            {
                if(r.getCliente().equals(cliente))
                {
                    LocalDate ldr = r.getFecha();
                    
                    if(ano==ldr.getYear() && month==ldr.getMonthValue())
                    {
                        if(r.getEstado().equals("reservada"))
                        {
                            montoDeuda = montoDeuda + r.getMonto();
                        }
                    }
                }
            }
            
            int real = (montoDeuda * 11) / 10; 
            
            Pago pago = new Pago(cliente,month,ano,montoDeuda,true,real);
            this.pagos.add(pago);
            cliente.pagarTodasMultas();
        }
        else
        {
            System.out.println("***********");
            System.out.println("Cliente no existe");
            System.out.println("***********");
        }
    
    }
    
    
    private int leerCancha(String string)
    {
        int can;
        while(true)
        {
            Scanner teclado = new Scanner(System.in);
            System.out.print(string);
            String sCancha= teclado.nextLine();
            try
            {
                can = Integer.valueOf(sCancha);
                if(can>0 && can<5)
                {
                    return can;
                }
                else
                {
                    System.out.println("Ingresar una cancha correspondiente entre 1 y 4");
                }
            }
            catch(Exception e)
            {
                System.out.println("***********");
                System.out.println("Ingresar Una cancha especifica");
                System.out.println("***********");
            }
        }
    
    }
    
    private int leerHora(String string)
    {
        int hora;
        while(true)
        {
            Scanner teclado = new Scanner(System.in);
            System.out.print(string);
            String sHora= teclado.nextLine();
            try
            {
                hora = Integer.valueOf(sHora);
                if(hora>=8 && hora<24)
                {
                    return hora;
                }
                else
                {
                    System.out.println("Ingresar una Hora Correspondiente entre 8 a 23");
                }
            }
            catch(Exception e)
            {
                System.out.println("***********");
                System.out.println("Ingresar Una hora especifica");
                System.out.println("***********");
                
            }
        }
    }
    
    private boolean horarioDisponible(int cancha,int hora,String fecha)
    {
        
        LocalDate ld = LocalDate.parse(fecha);
        for(Reserva r : this.reservas)
        {
            LocalDate ldr = r.getFecha();
            
            
            //Es la misma fecha
            if(ld.isEqual(ldr))
            {
                if(cancha == r.getCancha() && hora==r.getHora())
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    private int calcularMonto(int hora,LocalDate local)
    {
        int dia = local.getDayOfWeek().getValue();
        if(dia>0 && dia<6)
        {
            if(hora>=8 && hora<18)
            {
                return 5000;
            
            }
            else
            {
                return 4000;
            }
            
        }
        if(dia ==6 || dia ==7)
        {
            if(hora>=8 && hora<18)
            {
                return 7000;
            
            }
            else
            {
                return 6000;
            }
        
        }
        return 0;
    }
    
    private void cancelarReservaDeCliente(Cliente c, LocalDate fecha, int cancha, int hora )
    {
        for(Reserva r : this.reservas)
        {
            if(r.getCliente().equals(c))
            {
                if(fecha.equals(r.getFecha()) && cancha==r.getCancha() && hora==r.getHora())
                {
                    r.cancelarReserva();
                    System.out.println("Reserva Cancelada");
                    return;
                }
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
