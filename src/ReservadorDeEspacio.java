import java.util.ArrayList;
import java.util.List;

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

}
