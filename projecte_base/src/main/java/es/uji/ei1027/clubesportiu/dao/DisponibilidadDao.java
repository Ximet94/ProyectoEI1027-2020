package es.uji.ei1027.clubesportiu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import es.uji.ei1027.clubesportiu.model.Disponibilidad;

public class DisponibilidadDao {
	   private JdbcTemplate jdbcTemplate;

	   @Autowired
	   public void setDataSource(DataSource dataSource) {
	       jdbcTemplate = new JdbcTemplate(dataSource);
	   }

	   void addDisponibilidad(Disponibilidad disponibilidad) {
	       jdbcTemplate.update("INSERT INTO Disponibilidad VALUES(?,?,?,?,?,?,?)", disponibilidad.getId(), disponibilidad.getFecha(),
	    		   disponibilidad.getHora_inicio(), disponibilidad.getHora_fin(), disponibilidad.isEstado_disponible(),
	    		   disponibilidad.getUsuario(), disponibilidad.getDni_personaMayor());
	   }

	   void deleteDisponibilidad(Disponibilidad disponibilidad) {
	       jdbcTemplate.update("DELETE FROM Disponibilidad WHERE id=?", disponibilidad.getId());
	   }

		void updateDisponibilidad(Disponibilidad disponibilidad) {
			jdbcTemplate.update("UPDATE Disponibilidad SET fecha=?, hora_inicio=?, hora_fin=?, estado_disponible=?, usuario=?, dni_personaMayor=?",
					disponibilidad.getFecha(), disponibilidad.getHora_inicio(), disponibilidad.getHora_fin(),
					disponibilidad.isEstado_disponible(), disponibilidad.getUsuario(), disponibilidad.getDni_personaMayor());
		}
	   
		Disponibilidad getDisponibilidad(int id) {
			try {
				return jdbcTemplate.queryForObject("SELECT * FROM Disponibilidad WHERE id=?", new DisponibilidadRowMapper(), id);
			} catch (EmptyResultDataAccessException e) {
				return null;
			}
		}
		
	   List<Disponibilidad> getDisponibilidades() {
	       try {
	           return jdbcTemplate.query("SELECT * FROM Disponibilidad", new DisponibilidadRowMapper());
	       }
	       catch(EmptyResultDataAccessException e) {
	           return new ArrayList<Disponibilidad>();
	       }
	   }

}
