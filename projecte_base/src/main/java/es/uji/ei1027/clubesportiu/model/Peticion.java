package es.uji.ei1027.clubesportiu.model;

import java.util.Date;

public class Peticion {
   private int numero;
   private String tipo_servicio;
   private Date fecha_creacion;
   private String estado;
   private Date fecha_aprobacion;
   private Date fecha_rechazado;
   private String comentarios;
   private Date fecha_finalizacion;
   private String dni_personaMayor;
   private int numero_factura;
   private int numero_contrato;

   public Peticion() {

	}

	public Peticion(int numero, String tipo_servicio, Date fecha_creacion, String estado, Date fecha_aprobacion,
			Date fecha_rechazado, String comentarios, Date fecha_finalizacion, String dni_personaMayor,
			int numero_factura, int numero_contrato) {
		super();
		this.numero = numero;
		this.tipo_servicio = tipo_servicio;
		this.fecha_creacion = fecha_creacion;
		this.estado = estado;
		this.fecha_aprobacion = fecha_aprobacion;
		this.fecha_rechazado = fecha_rechazado;
		this.comentarios = comentarios;
		this.fecha_finalizacion = fecha_finalizacion;
		this.dni_personaMayor = dni_personaMayor;
		this.numero_factura = numero_factura;
		this.numero_contrato = numero_contrato;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTipo_servicio() {
		return tipo_servicio;
	}

	public void setTipo_servicio(String tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha_aprobacion() {
		return fecha_aprobacion;
	}

	public void setFecha_aprobacion(Date fecha_aprobacion) {
		this.fecha_aprobacion = fecha_aprobacion;
	}

	public Date getFecha_rechazado() {
		return fecha_rechazado;
	}

	public void setFecha_rechazado(Date fecha_rechazado) {
		this.fecha_rechazado = fecha_rechazado;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Date getFecha_finalizacion() {
		return fecha_finalizacion;
	}

	public void setFecha_finalizacion(Date fecha_finalizacion) {
		this.fecha_finalizacion = fecha_finalizacion;
	}

	public String getDni_personaMayor() {
		return dni_personaMayor;
	}

	public void setDni_personaMayor(String dni_personaMayor) {
		this.dni_personaMayor = dni_personaMayor;
	}

	public int getNumero_factura() {
		return numero_factura;
	}

	public void setNumero_factura(int numero_factura) {
		this.numero_factura = numero_factura;
	}

	public int getNumero_contrato() {
		return numero_contrato;
	}

	public void setNumero_contrato(int numero_contrato) {
		this.numero_contrato = numero_contrato;
	}

	@Override
	public String toString() {
		return "Peticion [numero=" + numero + ", tipo_servicio=" + tipo_servicio + ", fecha_creacion=" + fecha_creacion
				+ ", estado=" + estado + ", fecha_aprobacion=" + fecha_aprobacion + ", fecha_rechazado="
				+ fecha_rechazado + ", comentarios=" + comentarios + ", fecha_finalizacion=" + fecha_finalizacion
				+ ", dni_personaMayor=" + dni_personaMayor + ", numero_factura=" + numero_factura + ", numero_contrato="
				+ numero_contrato + "]";
	}

}
