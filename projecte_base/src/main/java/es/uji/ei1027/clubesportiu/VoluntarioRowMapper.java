package es.uji.ei1027.clubesportiu;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VoluntarioRowMapper implements RowMapper<Voluntario> {

	@Override
	public Voluntario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Voluntario voluntario = new Voluntario();
		voluntario.setUsuario(rs.getString("usuario"));
		voluntario.setPwd(rs.getString("pwd"));
		voluntario.setNombre(rs.getString("nombre"));
		voluntario.setTelefono(rs.getString("telefono"));
		voluntario.setEmail(rs.getString("email"));
		voluntario.setHobbies(rs.getString("hobbies"));
		voluntario.setFecha_aplicacion(rs.getDate("fecha_aplicacion"));
		voluntario.setFecha_aceptacion(rs.getDate("fecha_aceptacion"));
		voluntario.setEstado(rs.getString("estado"));
		voluntario.setFecha_ncto(rs.getDate("fecha_ncto"));

		return voluntario;
	}

}
