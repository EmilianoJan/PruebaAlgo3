package fiuba.algo3.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.Calendario;
import fiuba.algo3.modelo.Evento;
import fiuba.algo3.modelo.Fecha;
import fiuba.algo3.modelo.RecursoOcupadoException;

public class SistemaNotasTests {

		// TESTEOS DE LA CLASE: Fecha
		@Test
		public void testCompararFechasDiferentesPeroValidas() {
			
			Fecha fecha1 = new Fecha();
			Fecha fecha2 = new Fecha();
			
			fecha1.establecer(2016, 4, 17, 15);
			fecha2.establecer(2016, 7, 17, 15);
			
			Assert.assertFalse( fecha1.esIgualAFecha(fecha2));
		}
		
		@Test
		public void testCompararFechasIgualesPeroValidas() {
			
			Fecha fecha1 = new Fecha();
			Fecha fecha2 = new Fecha();
			
			fecha1.establecer(2016, 4, 17, 15);
			fecha2.establecer(2016, 4, 17, 15);
			
			Assert.assertTrue(fecha1.esIgualAFecha(fecha2));
		}
		
		@Test
		public void testCompararFechasDiferentesPeroInvalidas() {

			Fecha fecha1 = new Fecha();
			Fecha fecha2 = new Fecha();
			
			fecha1.establecer(2016, 13, 17, 15);
			fecha2.establecer(2016, 14, 17, 15);
			
			Assert.assertFalse( fecha1.esIgualAFecha(fecha2));
		}
		
		@Test
		public void testCompararFechasIgualesPeroInvalidas() {
			
			Fecha fecha1 = new Fecha();
			Fecha fecha2 = new Fecha();
			
			fecha1.establecer(2016, 24, 17, 15);
			fecha2.establecer(2016, 24, 17, 15);
			
			Assert.assertTrue(fecha1.esIgualAFecha(fecha2));
		}
		
		@Test
		public void testComprobarUnaFechaValida(){
			Fecha fecha = new Fecha();
			String fechaIngresada;
			String fechaCorregida;
			
			fecha.establecer(2016, 4, 17, 15);
			fechaIngresada = "Año: 2016" + " en mes: 4" + " en día: 17" + " en hora: 15";
			fechaCorregida = fecha.devolverFecha();
			
			Assert.assertTrue(fechaIngresada.equals(fechaCorregida));
			Assert.assertTrue( fecha.laFechaEsValida());
		}
		
		@Test
		public void testComprobarCorreccionDeFechaInvalida(){
			Fecha fecha = new Fecha();
			String fechaIngresada;
			String fechaCorregida;
			
			fecha.establecer(2016, 4, 77, 15);
			fechaIngresada = "Año: 2016" + " en mes: 4" + " en día: 77" + " en hora: 15";
			fechaCorregida = fecha.devolverFecha();
			
			Assert.assertFalse(fechaIngresada.equals(fechaCorregida)); //Corroboro que las fechas son diferentes debido a que se auto-corrigen al ingresar
			Assert.assertTrue( fecha.laFechaEsValida());
		}
		
		@Test
		public void testCorroborrarAnioBisiesto(){
			Fecha fecha = new Fecha();
			String fechaIngresada;
			String fechaCorregida;
			
			fecha.establecer(2016, 2, 29, 15);
			fechaIngresada = "Año: 2016" + " en mes: 2" + " en día: 29" + " en hora: 15";
			fechaCorregida = fecha.devolverFecha();
			
			Assert.assertTrue(fechaIngresada.equals(fechaCorregida)); //Corroboro que las fechas son diferentes debido a que se auto-corrigen al ingresar
		}
		@Test
		public void testCorroborrarAnioNoBisiesto(){
			Fecha fecha = new Fecha();
			String fechaIngresada;
			String fechaCorregida;
			
			fecha.establecer(2015, 2, 29, 15);
			fechaIngresada = "Año: 2016" + " en mes: 2" + " en día: 29" + " en hora: 15";
			fechaCorregida = fecha.devolverFecha();
			
			Assert.assertFalse(fechaIngresada.equals(fechaCorregida)); 
		}
		@Test
		public void testCorreccionesDeFechaInvalida_ErrorHoras() {
			Fecha fecha = new Fecha();
			String fechaIngresada;
			String fechaCorregida;
			
			fecha.establecer(2016, 2, 29, 25);
			fechaIngresada = "Año: 2016" + " en mes: 3" + " en día: 1" + " en hora: 1";
			fechaCorregida = fecha.devolverFecha();
			Assert.assertTrue(fechaIngresada.equals(fechaCorregida)); 
		}
		@Test
		public void testCorreccionesDeFechaInvalida_ErrorDias() {
			Fecha fecha = new Fecha();
			String fechaIngresada;
			String fechaCorregida;
			
			fecha.establecer(2016, 2, 30, 1);
			fechaIngresada = "Año: 2016" + " en mes: 3" + " en día: 1" + " en hora: 1";
			fechaCorregida = fecha.devolverFecha();
			Assert.assertTrue(fechaIngresada.equals(fechaCorregida)); 
		}
		
		@Test
		public void testCorreccionesDeFechaInvalida_ErrorMes() {
			Fecha fecha = new Fecha();
			String fechaIngresada;
			String fechaCorregida;
			
			fecha.establecer(2016, 13, 31, 1);
			fechaIngresada = "Año: 2017" + " en mes: 1" + " en día: 31" + " en hora: 1";
			fechaCorregida = fecha.devolverFecha();
			Assert.assertTrue(fechaIngresada.equals(fechaCorregida)); 
		}
		
		// TESTEOS DE LA CLASE: Evento
		
		@Test
		public void testCorroborrarQueTodosLosInvitadosSeEncuentrenEnElEvento(){
			ArrayList<String> invitados = new ArrayList<>();
			invitados.add("juan");
			invitados.add("proyector");

			Evento evento = new Evento();
			Fecha fecha = new Fecha();
			
			fecha.establecer( 2016, 5, 11, 10);
			
			evento.establecerNombre("nombreDePrueba");
			evento.establecerListadoDeInvitados(invitados);
			evento.establecerFechaDeEvento(fecha);
			
			Assert.assertTrue(evento.tieneComoInvitadoA("juan") && evento.tieneComoInvitadoA("proyector") );
		}
		
		@Test
		public void testCargaCorrectamenteLaFecha(){
			Fecha fecha = new Fecha();
			Fecha fechaOtra = new Fecha();
			Evento evento = new Evento();
			
			fecha.establecer( 2016, 5, 11, 10);
			fechaOtra.establecer( 2016, 5, 11, 11);
			evento.establecerFechaDeEvento(fecha);
			
			Assert.assertTrue(evento.esEnFecha(fecha));
			Assert.assertFalse(evento.esEnFecha(fechaOtra));
		}
		
		// TESTEOS DE LA CLASE: Calendario
		
		@Test(expected=RecursoOcupadoException.class)
		public void testAsignarUnRecursoADosEventosSimultaneos(){
			//Se generan dos eventos simulatáneos que poseen un recurso en común. Se deben generar ambos eventos.
			
			ArrayList<String> inviEvento1 = new ArrayList<>();
			inviEvento1.add("juan");
			inviEvento1.add("Proyector");
			
			ArrayList<String> inviEvento2 = new ArrayList<>();
			inviEvento2.add("Romina");
			inviEvento2.add("Proyector");

			Calendario cal = new Calendario();
			cal.agregarPersona("juan");
			cal.agregarPersona("Romina");
			
			cal.agregarRecurso("Proyector");
			
			cal.agregarEvento("Estudiar Algebra", inviEvento1, 2016, 5, 4, 10);
			
			Assert.assertTrue(cal.estaOcupado("juan", 2016, 5, 4, 10));
			Assert.assertTrue(cal.estaOcupado("Proyector", 2016, 5, 4, 10));
			Assert.assertFalse(cal.estaOcupado("Romina", 2016, 5, 4, 10));
			
			cal.agregarEvento("Mirar Partido", inviEvento2, 2016, 5, 4, 10);
			
			Assert.assertTrue(cal.estaOcupado("Romina", 2016, 5, 4, 10)); //se genera el evento con Romina
			
		}
		
		@Test(expected=RecursoOcupadoException.class)
		public void testAsignarUnRecursoADosEventosSimultaneosUnoDeLosCualesEsSemanal(){
			//La idea de este test es corroborrar que si en una semana se superponen los recursos, no condiciona para la próxima semana.
			
			ArrayList<String> inviEvento1 = new ArrayList<>();
			inviEvento1.add("juan");
			inviEvento1.add("Proyector");
			
			ArrayList<String> inviEvento2 = new ArrayList<>();
			inviEvento2.add("Romina");
			inviEvento2.add("Proyector");

			Calendario cal = new Calendario();
			cal.agregarPersona("juan");
			cal.agregarPersona("Romina");
			
			cal.agregarRecurso("Proyector");
			
			cal.agregarEvento("Estudiar Algebra", inviEvento1, 2016, 5, 4, 10);
			
			Assert.assertTrue(cal.estaOcupado("juan", 2016, 5, 4, 10));
			Assert.assertTrue(cal.estaOcupado("Proyector", 2016, 5, 4, 10));
			Assert.assertFalse(cal.estaOcupado("Romina", 2016, 5, 4, 10));
			
			Assert.assertFalse(cal.estaOcupado("Proyector", 2016, 5, (4+7), 10)); // No debería estár ocupado el proyector en la semana 2
			
			cal.agregarEventoSemanal("Mirar Partido",2 , inviEvento2, 2016, 5, 4, 10);
			Assert.assertTrue(cal.estaOcupado("Romina", 2016, 5, 4, 10)); //se genera el evento con Romina
			
			Assert.assertTrue(cal.estaOcupado("Romina", 2016, 5, (4+7), 10)); //se genera el evento con Romina en la siguiente semana
			Assert.assertTrue(cal.estaOcupado("Proyector", 2016, 5, (4+7), 10)); // y dispone del proyector (es de Romina)
		}
		
		@Test(expected=RecursoOcupadoException.class)
		public void testAsignarDosRecursosADosEventosSimultaneos(){
			// Se corroborra que se eliminen los recursos duplicados únicamente
			
			ArrayList<String> inviEvento1 = new ArrayList<>();
			inviEvento1.add("juan");
			inviEvento1.add("Proyector");
			inviEvento1.add("Netbook");
			inviEvento1.add("Microfono");
			
			ArrayList<String> inviEvento2 = new ArrayList<>();
			inviEvento2.add("Romina");
			inviEvento2.add("Proyector");
			inviEvento2.add("Netbook");
			inviEvento2.add("Facturas");

			Calendario cal = new Calendario();
			cal.agregarPersona("juan");
			cal.agregarPersona("Romina");
			
			cal.agregarRecurso("Proyector");
			cal.agregarRecurso("Netbook");
			cal.agregarRecurso("Facturas");
			cal.agregarRecurso("Microfono");
			
			cal.agregarEvento("Estudiar Algebra", inviEvento1, 2016, 5, 4, 10);
			
			Assert.assertTrue(cal.estaOcupado("juan", 2016, 5, 4, 10));
			Assert.assertTrue(cal.estaOcupado("Proyector", 2016, 5, 4, 10));
			Assert.assertTrue(cal.estaOcupado("Netbook", 2016, 5, 4, 10));
			Assert.assertTrue(cal.estaOcupado("Microfono", 2016, 5, 4, 10));
			Assert.assertFalse(cal.estaOcupado("Facturas", 2016, 5, 4, 10));
			Assert.assertFalse(cal.estaOcupado("Romina", 2016, 5, 4, 10));
			
			cal.agregarEvento("Mirar Partido", inviEvento2, 2016, 5, 4, 10);
			
			Assert.assertTrue(cal.estaOcupado("Romina", 2016, 5, 4, 10)); //se genera el evento con Romina
			Assert.assertTrue(cal.estaOcupado("Facturas", 2016, 5, 4, 10));
			
		}
		
		@Test(expected=RecursoOcupadoException.class)
		public void testAsignarDosRecursosADosEventosSimultaneosUnoDeLosCualesEsSemanal(){
			ArrayList<String> inviEvento1 = new ArrayList<>();
			inviEvento1.add("juan");
			inviEvento1.add("Proyector");
			inviEvento1.add("Netbook");
			inviEvento1.add("Microfono");
			
			ArrayList<String> inviEvento2 = new ArrayList<>();
			inviEvento2.add("Romina");
			inviEvento2.add("Proyector");
			inviEvento2.add("Netbook");
			inviEvento2.add("Facturas");

			Calendario cal = new Calendario();
			cal.agregarPersona("juan");
			cal.agregarPersona("Romina");
			
			cal.agregarRecurso("Proyector");
			cal.agregarRecurso("Netbook");
			cal.agregarRecurso("Facturas");
			cal.agregarRecurso("Microfono");
			
			cal.agregarEvento("Estudiar Algebra", inviEvento1, 2016, 5, 4, 10);
			
			Assert.assertTrue(cal.estaOcupado("juan", 2016, 5, 4, 10));
			Assert.assertTrue(cal.estaOcupado("Proyector", 2016, 5, 4, 10));
			Assert.assertTrue(cal.estaOcupado("Netbook", 2016, 5, 4, 10));
			Assert.assertTrue(cal.estaOcupado("Microfono", 2016, 5, 4, 10));
			Assert.assertFalse(cal.estaOcupado("Facturas", 2016, 5, 4, 10));
			Assert.assertFalse(cal.estaOcupado("Romina", 2016, 5, 4, 10));
			
			cal.agregarEventoSemanal("Mirar Partido",2 , inviEvento2, 2016, 5, 4, 10);
			Assert.assertTrue(cal.estaOcupado("Romina", 2016, 5, 4, 10)); //se genera el evento con Romina
			Assert.assertTrue(cal.estaOcupado("Facturas", 2016, 5, 4, 10));
			
			Assert.assertTrue(cal.estaOcupado("Romina", 2016, 5, (4+7), 10)); //se genera el evento con Romina en la siguiente semana
			Assert.assertTrue(cal.estaOcupado("Proyector", 2016, 5, (4+7), 10)); // y dispone del proyector (es de Romina)
			Assert.assertTrue(cal.estaOcupado("Netbook", 2016, 5, (4+7), 10));
			Assert.assertTrue(cal.estaOcupado("Facturas", 2016, 5, (4+7), 10));	
		}
		
		@Test
		public void testNoIndicaUnRecursoEnEvento(){
			
			ArrayList<String> inviEvento2 = new ArrayList<>();
			inviEvento2.add("Romina");
			inviEvento2.add("Proyector");
			inviEvento2.add("Facturas");

			Calendario cal = new Calendario();
			
			cal.agregarPersona("Romina");
			cal.agregarRecurso("Proyector");
		
			cal.agregarEventoSemanal("Mirar Partido",2 , inviEvento2, 2016, 5, 4, 10);
			Assert.assertTrue(cal.estaOcupado("Romina", 2016, 5, 4, 10));
			Assert.assertTrue(cal.estaOcupado("Facturas", 2016, 5, 4, 10));
			Assert.assertTrue(cal.estaOcupado("Proyector", 2016, 5, 4, 10));
			
			Assert.assertTrue(cal.estaOcupado("Romina", 2016, 5, (4+7), 10)); 
			Assert.assertTrue(cal.estaOcupado("Proyector", 2016, 5, (4+7), 10)); 
			Assert.assertTrue(cal.estaOcupado("Facturas", 2016, 5, (4+7), 10));	
		}
		
		@Test
		public void testNoIndicaUnRecursoYSeGeneranDosEventosSimultaneos(){
			//Se generan dos eventos simulatáneos que poseen un recurso no registrado en común. Se deben generar ambos eventos pero no la excepción
			
			ArrayList<String> inviEvento1 = new ArrayList<>();
			inviEvento1.add("juan");
			inviEvento1.add("Proyector");
			
			ArrayList<String> inviEvento2 = new ArrayList<>();
			inviEvento2.add("Romina");
			inviEvento2.add("Proyector");

			Calendario cal = new Calendario();
			cal.agregarPersona("juan");
			cal.agregarPersona("Romina");
			
			//cal.agregarRecurso("Proyector");
			
			cal.agregarEvento("Estudiar Algebra", inviEvento1, 2016, 5, 4, 10);
			
			Assert.assertTrue(cal.estaOcupado("juan", 2016, 5, 4, 10));
			Assert.assertTrue(cal.estaOcupado("Proyector", 2016, 5, 4, 10));
			Assert.assertFalse(cal.estaOcupado("Romina", 2016, 5, 4, 10));
			
			cal.agregarEvento("Mirar Partido", inviEvento2, 2016, 5, 4, 10);
			
			Assert.assertTrue(cal.estaOcupado("Romina", 2016, 5, 4, 10)); //se genera el evento con Romina
		}
		
		
		
}
