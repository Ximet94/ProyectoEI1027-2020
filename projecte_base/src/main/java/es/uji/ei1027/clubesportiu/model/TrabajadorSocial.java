package es.uji.ei1027.clubesportiu.model;

public class TrabajadorSocial implements Comparable<TrabajadorSocial>{
   private String usuarioCAS;
   private String nombre;
   private String pwd;
   private String telefono;
   private String email;
   private String dni;

   public TrabajadorSocial(String usuarioCAS, String nombre, String pwd, String telefono, String email, String dni) {
		super();
		this.usuarioCAS = usuarioCAS;
		this.nombre = nombre;
		this.pwd = pwd;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
   }

   public TrabajadorSocial() {
	   
   }

	public String getUsuarioCAS() {
		return usuarioCAS;
	}

	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public void setUsuarioCAS(String usuarioCAS) {
		this.usuarioCAS = usuarioCAS;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	@Override
	public String toString() {
		return "TrabajadorSocial [usuarioCAS=" + usuarioCAS + ", nombre=" + nombre + ", pwd=" + pwd + ", telefono="
				+ telefono + ", email=" + email + "]";
	}

	@Override
	public int compareTo(TrabajadorSocial o) {
		//Ordenamos por usuarioCAS
		return this.getUsuarioCAS().compareTo(o.getUsuarioCAS());
	}

}
