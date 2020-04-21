package es.uji.ei1027.clubesportiu.model;

import java.sql.Time;
import java.util.Date;

public class Disponibilidad {
	private int id;
	private Date fecha;
	private Time hora_inicio;
	private Time hora_fin;
	private boolean estado_disponible;
	private String usuario;
	private String dni_personaMayor;
	public Disponibilidad() {
		super();
	}
	public Disponibilidad(int id, Date fecha, Time hora_inicio, Time hora_fin, boolean estado_disponible,
			String usuario, String dni_personaMayor) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
		this.estado_disponible = estado_disponible;
		this.usuario = usuario;
		this.dni_personaMayor = dni_personaMayor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Time getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(Time hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public Time getHora_fin() {
		return hora_fin;
	}
	public void setHora_fin(Time hora_fin) {
		this.hora_fin = hora_fin;
	}
	public boolean isEstado_disponible() {
		return estado_disponible;
	}
	public void setEstado_disponible(boolean estado_disponible) {
		this.estado_disponible = estado_disponible;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getDni_personaMayor() {
		return dni_personaMayor;
	}
	public void setDni_personaMayor(String dni_personaMayor) {
		this.dni_personaMayor = dni_personaMayor;
	}
	@Override
	public String toString() {
		return "Disponibilidad [id=" + id + ", fecha=" + fecha + ", hora_inicio=" + hora_inicio + ", hora_fin="
				+ hora_fin + ", estado_disponible=" + estado_disponible + ", usuario=" + usuario + ", dni_personaMayor="
				+ dni_personaMayor + "]";
	}
}
