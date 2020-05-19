package es.uji.ei1027.clubesportiu.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Voluntario implements Comparable<Voluntario> {
	private String usuario;
	private String pwd;
	private String dni;
	private String nombre;
	private String telefono;
	private String email;
	private String hobbies;
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)  private Date fecha_aplicacion;
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)  private Date fecha_aceptacion;
	private String estado;
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)  private Date fecha_ncto;
	
	
	public Voluntario() {
		super();
	}


	public Voluntario(String usuario, String pwd, String nombre,String dni,  String telefono, String email, String hobbies,
			Date fecha_aplicacion, Date fecha_aceptacion, String estado, Date fecha_ncto) {
		super();
		this.usuario = usuario;
		this.pwd = pwd;
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.hobbies = hobbies;
		this.fecha_aplicacion = fecha_aplicacion;
		this.fecha_aceptacion = fecha_aceptacion;
		if(estado==null) {
			this.estado="pendiente";
		}
		else {
			this.estado = estado;
		}
		this.fecha_ncto = fecha_ncto;
	}


	public String getUsuario() {
		return usuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getHobbies() {
		return hobbies;
	}


	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}


	public Date getFecha_aplicacion() {
		return fecha_aplicacion;
	}


	public void setFecha_aplicacion(Date fecha_aplicacion) {
		this.fecha_aplicacion = fecha_aplicacion;
	}


	public Date getFecha_aceptacion() {
		return fecha_aceptacion;
	}


	public void setFecha_aceptacion(Date fecha_aceptacion) {
		this.fecha_aceptacion = fecha_aceptacion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getFecha_ncto() {
		return fecha_ncto;
	}


	public void setFecha_ncto(Date fecha_ncto) {
		this.fecha_ncto = fecha_ncto;
	}


	@Override
	public String toString() {
		return "Voluntario [usuario=" + usuario + ", pwd=" + pwd + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", email=" + email + ", hobbies=" + hobbies + ", fecha_aplicacion=" + fecha_aplicacion
				+ ", fecha_aceptacion=" + fecha_aceptacion + ", estado=" + estado + ", fecha_ncto=" + fecha_ncto
				+ "]";
	}


	@Override
	public int compareTo(Voluntario o) {
		// TODO Apéndice de método generado automáticamente
		return this.getUsuario().compareTo(o.getUsuario());
	}
}

