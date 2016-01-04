import static org.junit.Assert.*;

import org.junit.Test;

public class TestColero {

	@Test
	public void ColeroDebeTenerNombreYTelefono() {
		String nombre="Oscar";
		String telefono ="75520286";
		
		Colero oColero = new Colero(nombre,telefono);
		
		assertEquals(nombre,oColero.getNombre());
		assertEquals(telefono,oColero.getTelefono());
		
	}

}
