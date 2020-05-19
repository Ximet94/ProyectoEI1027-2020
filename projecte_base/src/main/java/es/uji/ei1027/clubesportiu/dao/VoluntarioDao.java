package es.uji.ei1027.clubesportiu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.clubesportiu.model.Voluntario;

@Repository
public class VoluntarioDao {
	   private static JdbcTemplate jdbcTemplate;

	   @Autowired
	   public void setDataSource(DataSource dataSource) {
	       jdbcTemplate = new JdbcTemplate(dataSource);
	   }

	   public void addVoluntario(Voluntario voluntario) {
	       jdbcTemplate.update("INSERT INTO Voluntario VALUES(?,?,?,?,?,?,?,?,?,?,?)", voluntario.getUsuario(), voluntario.getPwd(),
	    		   voluntario.getNombre(), voluntario.getTelefono(), voluntario.getEmail(), voluntario.getHobbies(), voluntario.getFecha_aplicacion(),
	    		   voluntario.getFecha_aceptacion(), voluntario.getEstado(), voluntario.getFecha_ncto(), voluntario.getDni());
	   }

	   void deleteVoluntario(Voluntario voluntario) {
	       jdbcTemplate.update("DELETE FROM Voluntario WHERE usuario=?", voluntario.getUsuario());
	   }
	   
	   public void deleteVoluntario(String usuario) {
		   jdbcTemplate.update("DELETE FROM Voluntario WHERE usuario=?", usuario);
	   }

		public void updateVoluntario(Voluntario voluntario) {
			jdbcTemplate.update("UPDATE Voluntario SET pwd=?, nombre=?, telefono=?, email=?, hobbies=?, fecha_aplicacion=?, fecha_aceptacion=?, estado=?, fecha_ncto=?",
					voluntario.getPwd(), voluntario.getNombre(), voluntario.getTelefono(), voluntario.getEmail(),
					voluntario.getHobbies(), voluntario.getFecha_aplicacion(), voluntario.getFecha_aceptacion(),
					voluntario.getEstado(), voluntario.getFecha_ncto());
		}
	   
		public static Voluntario getVoluntario(String usuario) {
			try {
				return jdbcTemplate.queryForObject("SELECT * FROM Voluntario WHERE usuario=?", new VoluntarioRowMapper(), usuario);
			} catch (EmptyResultDataAccessException e) {
				return null;
			}
		}
		
	   public List<Voluntario> getVoluntarios() {
	       try {
	           return jdbcTemplate.query("SELECT * FROM Voluntario", new VoluntarioRowMapper());
	       }
	       catch(EmptyResultDataAccessException e) {
	           return new ArrayList<Voluntario>();
	       }
	   }

}
