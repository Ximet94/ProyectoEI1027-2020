package dao;

import org.springframework.jdbc.core.RowMapper;

import model.PersonaMayor;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class PersonaMayorRowMapper implements RowMapper<PersonaMayor> {
   public PersonaMayor mapRow(ResultSet rs, int rowNum) throws SQLException {
	   PersonaMayor persona= new PersonaMayor();
	   persona.setDni(rs.getString("dni"));
	   persona.setNombre(rs.getString("nombre"));
	   persona.setApellidos(rs.getString("apellidos"));
	   persona.setFecha_ncto(rs.getDate("fecha_ncto"));
	   persona.setDireccion(rs.getString("direccion"));
	   persona.setTelefono(rs.getString("telefono"));
	   persona.setNumero_cuenta(rs.getString("numero_cuenta"));
	   persona.setEmail(rs.getString("email"));
	   persona.setUserPwd(rs.getString("userPwd"));
	   persona.setFecha_creacion(rs.getDate("fecha_creacion"));
	   persona.setAlergias(rs.getString("alergias"));
	   persona.setEnfermedades(rs.getString("enfermedades"));
	   persona.setUsuarioCAS(rs.getString("usuarioCAS"));
       return persona;
   }
}
