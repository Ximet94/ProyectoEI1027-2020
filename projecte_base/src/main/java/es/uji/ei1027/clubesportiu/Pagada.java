package es.uji.ei1027.clubesportiu;

public class Pagada {
	private int numero_peticion;
	private int numero_factura;
	
	public Pagada(int numero_peticion, int numero_factura) {
		super();
		this.numero_peticion = numero_peticion;
		this.numero_factura = numero_factura;
	}

	public Pagada() {
		super();
	}

	public int getNumero_peticion() {
		return numero_peticion;
	}

	public void setNumero_peticion(int numero_peticion) {
		this.numero_peticion = numero_peticion;
	}

	public int getNumero_factura() {
		return numero_factura;
	}

	public void setNumero_factura(int numero_factura) {
		this.numero_factura = numero_factura;
	}

	@Override
	public String toString() {
		return "Pagadas [numero_peticion=" + numero_peticion + ", numero_factura=" + numero_factura + "]";
	}
	
	
}
