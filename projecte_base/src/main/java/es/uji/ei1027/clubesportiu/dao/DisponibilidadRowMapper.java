package es.uji.ei1027.clubesportiu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.clubesportiu.model.Disponibilidad;

public class DisponibilidadRowMapper implements RowMapper<Disponibilidad> {

	@Override
	public Disponibilidad mapRow(ResultSet rs, int rowNum) throws SQLException {
		Disponibilidad disponibilidad = new Disponibilidad();
		disponibilidad.setId(rs.getInt("id"));
		disponibilidad.setFecha(rs.getDate("fecha"));
		disponibilidad.setHora_inicio(rs.getTime("hora_inicio"));
		disponibilidad.setHora_fin(rs.getTime("hora_fin"));
		disponibilidad.setEstado_disponible(rs.getBoolean("estado_disponible"));
		disponibilidad.setUsuario(rs.getString("usuario"));
		disponibilidad.setDni_personaMayor(rs.getString("dni_personaMayor"));
		
		return disponibilidad;
	}

}
