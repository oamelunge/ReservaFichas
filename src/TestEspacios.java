import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class TestEspacios {


	
	private Colero oColero;

	@Test
	public void espacioDebeTenerUnValor(){
		Espacio oEspacio = new Espacio(1,2.60,LocalDate.now(),oColero);
		assertEquals(1,oEspacio.getNumeracion());
		assertEquals(2.60,oEspacio.getValor(),0.002);
		assertEquals(LocalDate.now(),oEspacio.getFechaEspacio());		
	}
	
	@Test
	public void laNumeraciondelEspacioDebeSerMayorA0()
	{
		testsConExcepciones(0,2.60,LocalDate.now(),"numeracion debe ser un valor positivo");		
	}
	@Test
	public void elValordelEspacioDebeSerMayorA0()
	{		
		testsConExcepciones(2,(double) 0,LocalDate.now(),"el valor debe ser positivo");				
	}
	
	@Test
	public void laFechaDelEspacioNoPuedeSerAnteriorAlDiaDeHoy()
	{
	
		testsConExcepciones(2,(double) 1,LocalDate.now().plusDays(-1),"fecha de espacio vencida");
	}
	
	@Test
	public void laFechaDelEspacioNoPuedeSerPosteriorAlDiaDeHoy()
	{
		testsConExcepciones(2,(double) 1,LocalDate.now().plusDays(1),"fecha de espacio no habilitada");
	}
	
	public void testsConExcepciones(int numeracion, double valor, LocalDate fecha, String mensajeError)
	{
		try {
			Espacio oEspacio = new Espacio(numeracion,valor,fecha,oColero);
			fail();
		} catch (Exception e) {
			assertEquals(mensajeError,e.getMessage());
		}
	}
	
	@Test
	public void elEspacioDebeSerReservadoPorUnColero()
	{
	
		Espacio oEspacio = new Espacio(1,2.50,LocalDate.now(),oColero);
	}

	@Before
	public void setUp(){
		crearColero();
	}
	private void crearColero() {
		oColero = new Colero("Oscar","75520286");
	}
	
}
