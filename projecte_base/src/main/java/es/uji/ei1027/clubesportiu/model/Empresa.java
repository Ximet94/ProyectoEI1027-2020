package es.uji.ei1027.clubesportiu.model;

public class Empresa implements Comparable<Empresa>{
	private String cif;
	private String nombre;
	private String direccion;
	private String nombre_contacto;
	private String telefono_contacto;
	private String email_contacto;
	private String pwd;
	private String tipo_servicio; // TODO: cambiar a enumeración ServicioEnum
	public Empresa() {
		super();
	}
	public Empresa(String cif, String nombre, String direccion, String nombre_contacto, String telefono_contacto,
			String email_contacto, String tipo_servicio, String pwd) {
		super();
		this.cif = cif;
		this.nombre = nombre;
		this.direccion = direccion;
		this.nombre_contacto = nombre_contacto;
		this.telefono_contacto = telefono_contacto;
		this.email_contacto = email_contacto;
		this.pwd = pwd;
		this.tipo_servicio = tipo_servicio;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getNombre() {
		return nombre;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombre_contacto() {
		return nombre_contacto;
	}
	public void setNombre_contacto(String nombre_contacto) {
		this.nombre_contacto = nombre_contacto;
	}
	public String getTelefono_contacto() {
		return telefono_contacto;
	}
	public void setTelefono_contacto(String telefono_contacto) {
		this.telefono_contacto = telefono_contacto;
	}
	public String getEmail_contacto() {
		return email_contacto;
	}
	public void setEmail_contacto(String email_contacto) {
		this.email_contacto = email_contacto;
	}
	public String getTipo_servicio() {
		return tipo_servicio;
	}
	public void setTipo_servicio(String tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}
	@Override
	public String toString() {
		return "Empresa [cif=" + cif + ", nombre=" + nombre + ", direccion=" + direccion + ", nombre_contacto="
				+ nombre_contacto + ", telefono_contacto=" + telefono_contacto + ", email_contacto=" + email_contacto
				+ ", tipo_servicio=" + tipo_servicio + "]";
	}
	@Override
	public int compareTo(Empresa o) {
		// TODO Apéndice de método generado automáticamente
		return this.getCif().compareTo(o.getCif());
	}
}
