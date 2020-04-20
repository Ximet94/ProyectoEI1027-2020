package es.uji.ei1027.clubesportiu.model;

import java.util.Date;

public class PersonaMayor {
   private String dni;
   private String nombre;
   private String apellidos;
   private Date fecha_ncto;
   private String direccion;
   private String telefono;
   private String numero_cuenta;
   private String email;
   private String userPwd;
   private Date fecha_creacion;
   private String alergias;
   private String enfermedades;
   private String usuarioCAS;

	public PersonaMayor(String dni, String nombre, String apellidos, Date fecha_ncto, String direccion, String telefono,
			String numero_cuenta, String email, String userPwd, Date fecha_creacion, String alergias,
			String enfermedades, String usuarioCAS) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_ncto = fecha_ncto;
		this.direccion = direccion;
		this.telefono = telefono;
		this.numero_cuenta = numero_cuenta;
		this.email = email;
		this.userPwd = userPwd;
		this.fecha_creacion = fecha_creacion;
		this.alergias = alergias;
		this.enfermedades = enfermedades;
		this.usuarioCAS = usuarioCAS;
	}
	
	public PersonaMayor() {
		
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFecha_ncto() {
		return fecha_ncto;
	}

	public void setFecha_ncto(Date fecha_ncto) {
		this.fecha_ncto = fecha_ncto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setNumero_cuenta(String numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getEnfermedades() {
		return enfermedades;
	}

	public void setEnfermedades(String enfermedades) {
		this.enfermedades = enfermedades;
	}

	public String getUsuarioCAS() {
		return usuarioCAS;
	}

	public void setUsuarioCAS(String usuarioCAS) {
		this.usuarioCAS = usuarioCAS;
	}

	@Override //En este toString no hemos puesto el atributo userPwd
	public String toString() {
		return "PersonaMayor [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha_ncto="
				+ fecha_ncto + ", direccion=" + direccion + ", telefono=" + telefono + ", numero_cuenta="
				+ numero_cuenta + ", email=" + email + ", fecha_creacion=" + fecha_creacion + ", alergias=" + alergias
				+ ", enfermedades=" + enfermedades + ", usuarioCAS=" + usuarioCAS + "]";
	}

}
