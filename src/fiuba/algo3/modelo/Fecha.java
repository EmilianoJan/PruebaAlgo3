package fiuba.algo3.modelo;

import java.util.Date;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.util.GregorianCalendar;

public class Fecha {
	private int anioInstancia;
	private int mesInstancia;
	private int diaInstancia;
	private int horaInstancia;
	public void establecer (int anio, int mes, int dia, int hora) {
		
		this.anioInstancia = anio;
		this.mesInstancia = mes;
		this.diaInstancia = dia;
		this.horaInstancia = hora;
		this.CorregirFecha(); //en caso de que la fecha no sea correcta se corrige con la esperable (ver tests de fechas)
	}
	
	public boolean esIgualAFecha(Fecha Otra){
		
		String miFecha;
		String suFecha;
		boolean salida;
		
		miFecha = this.devolverFecha();
		suFecha = Otra.devolverFecha();
		
		salida = (miFecha.equals(suFecha));
		return(salida);
	}
	
	public String devolverFecha(){
		
		String ret;
		ret = "Año: " + this.anioInstancia + " en mes: " + this.mesInstancia + " en día: " + this.diaInstancia + " en hora: " + this.horaInstancia;
		return(ret);
	}
	
	public boolean laFechaEsValida(){
		// creo una fecha usando GregorianCalendar y corroborro que la 
		// fecha cargada al sistema sea igual a la del calendario
	
		Calendar calendar = new GregorianCalendar(this.anioInstancia, (this.mesInstancia-1), this.diaInstancia, this.horaInstancia,0,0);

	    int anio = calendar.get(Calendar.YEAR);
	    int mes = (calendar.get(Calendar.MONTH) +1); // GregorianCalendar asume que enero = 0.
	    int dia = calendar.get(Calendar.DAY_OF_MONTH);
		int hora = calendar.get(Calendar.HOUR_OF_DAY);
		
		String fechaCorrecta;
		String fechaIngresada;
		fechaCorrecta = "Año: " + anio + " en mes: " + mes + " en día: " + dia + " en hora: " + hora;
		fechaIngresada = this.devolverFecha();
		//System.out.print(fechaCorrecta + "\n"); //<< para visualizar la fecha de GregorianCalendar
		return((fechaIngresada.equals(fechaCorrecta)));
	}
	
	public void CorregirFecha(){
		Calendar calendar = new GregorianCalendar(this.anioInstancia, (this.mesInstancia-1), this.diaInstancia, this.horaInstancia,0,0);

	    int anio = calendar.get(Calendar.YEAR);
	    int mes = (calendar.get(Calendar.MONTH) +1); // GregorianCalendar asume que enero = 0.
	    int dia = calendar.get(Calendar.DAY_OF_MONTH);
		int hora = calendar.get(Calendar.HOUR_OF_DAY);
		this.anioInstancia = anio;
		this.mesInstancia = mes;
		this.diaInstancia = dia;
		this.horaInstancia = hora;
	}

}
