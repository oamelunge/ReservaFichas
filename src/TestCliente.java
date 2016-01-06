import static org.junit.Assert.*;

import org.junit.Test;

public class TestCliente {

	@Test
	public void clienteDebeTenerNombreYTelefono() {
		String nombre="Oscar";
		String telefono="75520286";
		Cliente oCliente = new Cliente("Oscar","75520286");
		assertEquals(nombre,oCliente.getNombre());
		assertEquals(telefono,oCliente.getTelefono());
	}

}
