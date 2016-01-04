import java.util.List;

public class ManejadorCola {
	public List<Object> _cola;

	public ManejadorCola(List<Object> _cola) {
		this._cola = _cola;
	}
	
	public int espaciosReservados() {
		return _cola.size();
	}

}