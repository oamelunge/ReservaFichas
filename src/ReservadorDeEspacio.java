import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReservadorDeEspacio {

	private List<Espacio> _cola = new ArrayList<Espacio>();

	public void publicarEspacioCola(Espacio espacioCola) {
		if(_cola.stream().anyMatch(espacio -> espacio.getNumeracion()==espacioCola.getNumeracion()))
			throw new RuntimeException("espacio ya reservado");
		_cola.add(espacioCola);
		
	}

	public int cantidadEspaciosReservados() {
		return _cola.size();
	}

	public void publicarEspaciosCola(List<Espacio> espacios) {
		_cola.addAll(espacios);
		
	}

	public List<Espacio> obtenerEspaciosPublicados() {
		return _cola;
	}

	public void reservar(int numeracion, Cliente cliente) {
		Espacio espacioConCliente = espacioConCliente(numeracion, cliente);
		_cola=_cola.stream()
			 .filter(espacio->espacio.getNumeracion()!=numeracion)
			 .collect(Collectors.toList())
			  ;
		_cola.add(espacioConCliente);
		
	}

	private Espacio espacioConCliente(int numeracion, Cliente cliente) {
		return _cola.stream()
					.filter(espacio-> espacio.getNumeracion()==numeracion)
					.findFirst().get()
					.asignarCliente(cliente);
	}

}
