package es.uji.ei1027.clubesportiu;

import java.util.Date;

public class Voluntario {
	private String usuario;
	private String pwd;
	private String nombre;
	private String telefono;
	private String email;
	private String hobbies;
	private Date fecha_aplicacion;
	private Date fecha_aceptacion;
	private String estado;
	private Date fecha_ncto;
	
	
	public Voluntario() {
		super();
	}


	public Voluntario(String usuario, String pwd, String nombre, String telefono, String email, String hobbies,
			Date fecha_aplicacion, Date fecha_aceptacion, String estado, Date fecha_ncto) {
		super();
		this.usuario = usuario;
		this.pwd = pwd;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.hobbies = hobbies;
		this.fecha_aplicacion = fecha_aplicacion;
		this.fecha_aceptacion = fecha_aceptacion;
		this.estado = estado;
		this.fecha_ncto = fecha_ncto;
	}


	public String getUsuario() {
		return usuario;
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
}

