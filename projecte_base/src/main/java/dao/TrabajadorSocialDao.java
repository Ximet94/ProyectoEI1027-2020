package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.TrabajadorSocial;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Repository // En Spring els DAOs van anotats amb @Repository
public class TrabajadorSocialDao {

   private JdbcTemplate jdbcTemplate;

   // Obté el jdbcTemplate a partir del Data Source
   @Autowired
   public void setDataSource(DataSource dataSource) {
       jdbcTemplate = new JdbcTemplate(dataSource);
   }

   /*Anyade el trabajadorSocial a la BBDD */
   void addTrabajadorSocial(TrabajadorSocial trabajador) {
       jdbcTemplate.update("INSERT INTO Trabajador values(?,?,?,?,?)", trabajador.getUsuarioCAS(), trabajador.getNombre(), trabajador.getPwd(), 
    		   trabajador.getTelefono(), trabajador.getEmail());
   }
   /* Borra el trabajador Social de la base de dades */
   void deleteTrabajadorSocial(TrabajadorSocial trabajador) {
       jdbcTemplate.update("DELETE FROM Trabajador WHERE usuarioCAS=?",trabajador.getUsuarioCAS());
   }

   /* Actualiza los atributos del Trabajador
   */
	void updateTrabajadorSocial(TrabajadorSocial trabajador) {
		jdbcTemplate.update("UPDATE Trabajador set nombre=?, pwd=?, telefono=?, email=?",
				trabajador.getNombre(), trabajador.getPwd(), trabajador.getTelefono(), trabajador.getEmail());
	}
   
	/* Obtiene el trabajdor por su usuarioCAS. Devuelve null si no existe. */
	TrabajadorSocial getTrabajadorSocial(String usuarioCAS) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM Trabajador where usuarioCAS=?", new TrabajadorSocialRowMapper(), usuarioCAS);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
   /* Obtiene todos los trabajadores sociales.*/
   List<TrabajadorSocial> getTrabajadoresSociales() {
       try {
           return jdbcTemplate.query("SELECT * from Trabajador", new TrabajadorSocialRowMapper());
       }
       catch(EmptyResultDataAccessException e) {
           return new ArrayList<TrabajadorSocial>();
       }
   }
}