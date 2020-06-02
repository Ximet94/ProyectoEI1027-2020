package es.uji.ei1027.clubesportiu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.clubesportiu.model.InformacionContrato;

public class InformacionContratoRowMapper  implements RowMapper<InformacionContrato>{
	public InformacionContrato mapRow(ResultSet rs, int rowNum) throws SQLException {
		InformacionContrato info= new InformacionContrato();
			info.setNumeroContrato(rs.getInt("numeroContrato"));
			info.setFecha_inicio(rs.getDate("fecha_inicio"));
			info.setFecha_fin(rs.getDate("fecha_fin"));
			info.setEstado(rs.getString("estado"));
			info.setComentarios(rs.getString("comentarios"));
			info.setDni_personaMayor(rs.getString("dni_personaMayor"));
			info.setNombre(rs.getString("nombre"));
			info.setApellidos(rs.getString("apellidos"));
			info.setTelefono(rs.getString("telefono"));
			info.setEmail(rs.getString("email"));
			info.setAlergias(rs.getString("alergias"));
			info.setEnfermedades(rs.getString("enfermedades"));
	       return info;
	   }
}

