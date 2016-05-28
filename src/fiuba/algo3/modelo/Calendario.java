package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Calendario {

	private ArrayList<PersonaRecurso> personas = new ArrayList<PersonaRecurso>();
	private ArrayList<PersonaRecurso> recursos = new ArrayList<PersonaRecurso>();
	private ArrayList<Evento> eventos = new ArrayList<Evento>();

	public void agregarEvento (String nombreEvento,  ArrayList<String> invitados, int anio,int mes,int  dia, int hora){		
		
		boolean duplicado = false;
		
		Fecha fecha = new Fecha();
		fecha.establecer(anio, mes, dia, hora);
		
		Iterator<String> nombreIterator = invitados.iterator();
		
		while(nombreIterator.hasNext()){
			
			boolean auxiliar;
			boolean recursoOcupado;
			String elemento = nombreIterator.next();
			auxiliar = this.existeRecurso(elemento);
			if (auxiliar){
				recursoOcupado = this.estaOcupado(elemento, anio, mes, dia, hora);
				duplicado = duplicado || recursoOcupado;
				if(recursoOcupado){
					invitados.remove(elemento);
				}
			}
		}
		
		Evento evento = new Evento();
		evento.establecerNombre(nombreEvento);
		evento.establecerListadoDeInvitados(invitados);
		evento.establecerFechaDeEvento(fecha);
		this.eventos.add(evento);
		
		if (duplicado){
			throw new RecursoOcupadoException();
		}
	}
	
	public void agregarEventoSemanal (String nombre, int semanas, ArrayList<String> invitados, int anio,int mes,int  dia, int hora){

		for(int j= 0 ; j < semanas ; j++){
			this.agregarEvento(nombre, invitados, anio, mes, (dia +(j*7)) , hora);
		}
	}
	
	public void agregarPersona(String nombre){
		PersonaRecurso nuevo = new PersonaRecurso();
		nuevo.establecerNombre(nombre);
		this.personas.add(nuevo);
	}
	
	public void agregarRecurso(String nombre) {
		PersonaRecurso nuevo = new PersonaRecurso();
		nuevo.establecerNombre(nombre);
		this.recursos.add(nuevo);
	}
	
	public boolean estaOcupado(String tipo, int  anio, int  mes, int dia, int hora){
		
		boolean salida = false;
		Fecha fecha = new Fecha();
		fecha.establecer(anio, mes, dia, hora);
		
		Iterator<Evento> nombreIterator = this.eventos.iterator();
		
		while(nombreIterator.hasNext()){
			
			boolean auxiliar;
			Evento evento = nombreIterator.next();
			auxiliar = evento.esEnFecha(fecha);
			salida = salida || (auxiliar && evento.tieneComoInvitadoA(tipo));			
		}
		
		return(salida);
	}
	
	public boolean existePersona(String nombre){
		PersonaRecurso nuevo = new PersonaRecurso();
		nuevo.establecerNombre(nombre);
		boolean devolver;
		devolver = this.personas.contains(nuevo);
		return(devolver);
	}
	
	public boolean existeRecurso(String nombre){
		PersonaRecurso nuevo = new PersonaRecurso();
		nuevo.establecerNombre(nombre);
		boolean devolver;
		devolver = this.recursos.contains(nuevo);
		return(devolver);
	}
	

}