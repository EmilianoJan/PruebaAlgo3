package fiuba.algo3.modelo;

import java.util.ArrayList;

public class Evento {
	
	private  ArrayList<String> invitados = new ArrayList<String>();
	private Fecha fecha = new Fecha();
	private String nombre;
	
	public void establecerFechaDeEvento(Fecha fechaIn){
		
		this.fecha = fechaIn;
	}
	
	public void establecerListadoDeInvitados( ArrayList<String> listadoDeInvitados){
		
		this.invitados = listadoDeInvitados;
	}
	
	public void establecerNombre(String nombreEvento){
		
		this.nombre = nombreEvento;
	}
	
	public boolean tieneComoInvitadoA( String nombreTipo){
		
		return (invitados.contains(nombreTipo));
	}

	public boolean esEnFecha(Fecha otra){
		
		boolean salida;
		salida = this.fecha.esIgualAFecha(otra);
		return (salida);
	}

}
