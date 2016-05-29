package fiuba.algo3.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.Calendario;
import fiuba.algo3.modelo.Evento;
import fiuba.algo3.modelo.Fecha;
import fiuba.algo3.modelo.RecursoOcupadoException;

public class PruebasIntegradoras {
	
	// TESTEOS DE LA CLASE: Fecha
			@Test
			public void testCompararFechasDiferentesPeroValidasNuevoEnMiBranch() {
				
				Fecha fecha1 = new Fecha();
				Fecha fecha2 = new Fecha();
				
				fecha1.establecer(2016, 4, 17, 15);
				fecha2.establecer(2016, 7, 17, 15);
				
				Assert.assertFalse( fecha1.esIgualAFecha(fecha2));
			}

}
