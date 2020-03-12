package es.uji.ei1027.clubesportiu;

import java.util.Date;

public class Contrato {
	private int numero;
	private Date fecha_inicio;
	private Date fecha_fin;
	private String descripcion;
	private String tipo_servicio; // TODO: cambiar a enumeración ServicioEnum
	private int cantidad_servicios;
	private String unidades_de_medida;
	private double precio_unidad;
	private String cif_empresa;
	public Contrato() {
		super();
	}
	public Contrato(int numero, Date fecha_inicio, Date fecha_fin, String descripcion, String tipo_servicio,
			int cantidad_servicios, String unidades_de_medida, double precio_unidad, String cif_empresa) {
		super();
		this.numero = numero;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.descripcion = descripcion;
		this.tipo_servicio = tipo_servicio;
		this.cantidad_servicios = cantidad_servicios;
		this.unidades_de_medida = unidades_de_medida;
		this.precio_unidad = precio_unidad;
		this.cif_empresa = cif_empresa;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipo_servicio() {
		return tipo_servicio;
	}
	public void setTipo_servicio(String tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}
	public int getCantidad_servicios() {
		return cantidad_servicios;
	}
	public void setCantidad_servicios(int cantidad_servicios) {
		this.cantidad_servicios = cantidad_servicios;
	}
	public String getUnidades_de_medida() {
		return unidades_de_medida;
	}
	public void setUnidades_de_medida(String unidades_de_medida) {
		this.unidades_de_medida = unidades_de_medida;
	}
	public double getPrecio_unidad() {
		return precio_unidad;
	}
	public void setPrecio_unidad(double precio_unidad) {
		this.precio_unidad = precio_unidad;
	}
	public String getCif_empresa() {
		return cif_empresa;
	}
	public void setCif_empresa(String cif_empresa) {
		this.cif_empresa = cif_empresa;
	}
	@Override
	public String toString() {
		return "Contrato [numero=" + numero + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin
				+ ", descripcion=" + descripcion + ", tipo_servicio=" + tipo_servicio + ", cantidad_servicios="
				+ cantidad_servicios + ", unidades_de_medida=" + unidades_de_medida + ", precio_unidad=" + precio_unidad
				+ ", cif_empresa=" + cif_empresa + "]";
	}
}
