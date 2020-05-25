package es.uji.ei1027.clubesportiu.model;

public class UserDetails {
	String username;
	String password; 
	String role;
	public String getUsername() {
		return username; 
	}

	public void setUsername(String username) {
	    this.username = username; 
	}

	public String getPassword() {
	   return password; 
	}

	public void setPassword(String password) {
	   this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String toString() {
		return "Usuario" + username + ", role " + role;
	}
	
}