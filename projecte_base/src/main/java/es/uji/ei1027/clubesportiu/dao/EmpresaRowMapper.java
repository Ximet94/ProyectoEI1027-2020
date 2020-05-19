package es.uji.ei1027.clubesportiu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.clubesportiu.model.Empresa;

public class EmpresaRowMapper implements RowMapper<Empresa> {


	@Override
	public Empresa mapRow(ResultSet rs, int rowNum) throws SQLException {
		Empresa empresa = new Empresa();
		empresa.setCif(rs.getString("cif"));
		empresa.setNombre(rs.getString("nombre"));
		empresa.setDireccion(rs.getString("direccion"));
		empresa.setNombre_contacto(rs.getString("nombre_contacto"));
		empresa.setTelefono_contacto(rs.getString("telefono_contacto"));
		empresa.setEmail_contacto(rs.getString("email_contacto"));
		empresa.setTipo_servicio(rs.getString("tipo_servicio"));
		empresa.setPwd(rs.getString("pwd"));
		return empresa;
	}

}
