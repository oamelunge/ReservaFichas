import java.time.LocalDate;

public class Espacio {

	private int _numeracion;
	private double _valor;
	private LocalDate _fecha;
	private Colero _colero;
	private Cliente _cliente;

	
	public Espacio(int numeracion, double valor, LocalDate fechaEspacio, Colero colero) {
		validarEspacio(numeracion, valor, fechaEspacio);				
		_numeracion=numeracion;
		_valor=valor;
		_fecha=fechaEspacio;
		_colero=colero;	
		_cliente= new Cliente("","0");
	}

	public Espacio(int numeracion, double valor, LocalDate fechaEspacio, Colero colero, Cliente cliente) {
		validarEspacio(numeracion, valor, fechaEspacio);				
		_numeracion=numeracion;
		_valor=valor;
		_fecha=fechaEspacio;
		_colero=colero;
		_cliente=cliente;
	}

	private void validarEspacio(int numeracion, double valor, LocalDate fechaEspacio) {
		validarNumeracion(numeracion);
		validarValor(valor);
		validarFecha(fechaEspacio);
	}

	private void validarFecha(LocalDate fechaEspacio) {
		fechaVencida(fechaEspacio);
		fechaNoHabilidata(fechaEspacio);
	}

	private void fechaNoHabilidata(LocalDate fechaEspacio) {
		if(fechaEspacio.isAfter(LocalDate.now()))
			throw new RuntimeException("fecha de espacio no habilitada");
	}

	private void fechaVencida(LocalDate fechaEspacio) {
		if(fechaEspacio.isBefore(LocalDate.now()))
			throw new RuntimeException("fecha de espacio vencida");
	}

	private void validarValor(double valor) {
		if(valor<1)
			throw new RuntimeException("el valor debe ser positivo");
	}

	private void validarNumeracion(int numeracion) {
		if(numeracion<1)
			throw new RuntimeException("numeracion debe ser un valor positivo");
	}

	public int getNumeracion() {		
		return _numeracion;
	}
	
	public double getValor() {
		return _valor;
	}

	public LocalDate getFechaEspacio() {
		return this._fecha;
	}

	public Espacio asignarCliente(Cliente cliente) {
		return new Espacio(this._numeracion,this._valor,this._fecha,this._colero,cliente);
		
	}

}
