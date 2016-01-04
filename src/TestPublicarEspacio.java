import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestPublicarEspacio {

	private Colero oColero;
	@Test
	public void coleroDebePoderPublicarUnEspacioEnLaCola() {
		ReservadorDeEspacio reservador = new ReservadorDeEspacio();
		LocalDate fechaEspacio = LocalDate.now();
		Espacio oEspacio= new Espacio(1, 2.50,fechaEspacio,oColero);
		reservador.publicarEspacioCola(oEspacio);
		assertEquals(1, reservador.cantidadEspaciosReservados());
		
	}
	
	@Test
	public void coleroDebePoderPublicarMasdeUnEspaciosEnLaCola(){
		ReservadorDeEspacio reservador = new ReservadorDeEspacio();
		LocalDate fechaEspacio = LocalDate.now();
		Espacio oEspacio1= new Espacio(1, 2.50,fechaEspacio,oColero);
		Espacio oEspacio2= new Espacio(2, 2.50,fechaEspacio,oColero);
		reservador.publicarEspacioCola(oEspacio1);
		reservador.publicarEspacioCola(oEspacio2);
		assertEquals(2, reservador.cantidadEspaciosReservados());
	}
	
	@Test
	public void coleroDebePoderPubicarMasdeUnEspacioEnLaColaAlMismoTiempo(){
		ReservadorDeEspacio reservador = new ReservadorDeEspacio();
		LocalDate fechaEspacio = LocalDate.now();
		Espacio oEspacio1= new Espacio(1, 2.50,fechaEspacio,oColero);
		Espacio oEspacio2= new Espacio(2, 2.50,fechaEspacio,oColero);
		Espacio oEspacio3= new Espacio(3, 2.50,fechaEspacio,oColero);
		
		List<Espacio> espacios = new ArrayList<Espacio>();
		reservador.publicarEspacioCola(oEspacio1);
		reservador.publicarEspacioCola(oEspacio2);
		reservador.publicarEspacioCola(oEspacio3);
		
		reservador.publicarEspaciosCola(espacios);
		int espaciosReservados = reservador.cantidadEspaciosReservados();
		assertEquals(3, espaciosReservados);
		
	}
	
	
	//EL QUE PUBLICA EL ESPACIO DEBE SER UN COLERO REGISTRADO
	// NO SE PUEDEN PUBLICAR ESPACIOS REPETIDOS CON LA MISMA NUMERACION
	@Test
	public void reservadorEspaciosNoDebePermitirPublicarEspaciosConMismaNumeracion()
	{
		ReservadorDeEspacio reservador = new ReservadorDeEspacio();
		LocalDate fechaEspacio = LocalDate.now();
		Espacio oEspacio1= new Espacio(1, 2.50,fechaEspacio,oColero);
		Espacio oEspacio2= new Espacio(1, 2.50,fechaEspacio,oColero);
		
		reservador.publicarEspacioCola(oEspacio1);
	
		int cantidadEspaciosReservados=reservador.cantidadEspaciosReservados();
		
		try {
			reservador.publicarEspacioCola(oEspacio2);
			fail();
		} catch (Exception e) {
			assertEquals("espacio ya reservado",e.getMessage());
			assertEquals(cantidadEspaciosReservados,reservador.cantidadEspaciosReservados());
		}
		
	}
	
	
	//EL QUE PUBLICA EL ESPACIO DEBE SER UN COLERO REGISTRADO
	@Test
	public void elEspacioDebeSerHabilitadoPorUnColero()
	{
		
		
	}
	
	
	//VER LA POSIBILIDAD DE PUBLICAR ESPACIOS PARA DISTINTOS ORGANIZACIONES CNS CPS, ET TODAVIA NO
	
	@Before
	public void setUp(){
		crearColero();
	}
	private void crearColero() {
		oColero = new Colero("Oscar","75520286");
	}

}