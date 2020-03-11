package es.uji.ei1027.clubesportiu;

import java.util.Date;

public class Factura {
   private int numero;
   private Date fecha;
   private int cantidad;
   private String concepto;
   private String dni_personaMayor;

   public Factura() {
	   
   }

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getDni_personaMayor() {
		return dni_personaMayor;
	}

	public void setDni_personaMayor(String dni_personaMayor) {
		this.dni_personaMayor = dni_personaMayor;
	}

	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", fecha=" + fecha + ", cantidad=" + cantidad + ", concepto=" + concepto
				+ ", dni_personaMayor=" + dni_personaMayor + "]";
	}

	public Factura(int numero, Date fecha, int cantidad, String concepto, String dni_personaMayor) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.concepto = concepto;
		this.dni_personaMayor = dni_personaMayor;
	}

}
