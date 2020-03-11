package es.uji.ei1027.clubesportiu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Repository // En Spring els DAOs van anotats amb @Repository
public class PersonaMayorDao {

   private JdbcTemplate jdbcTemplate;

   // Obté el jdbcTemplate a partir del Data Source
   @Autowired
   public void setDataSource(DataSource dataSource) {
       jdbcTemplate = new JdbcTemplate(dataSource);
   }

   void addPersonaMayor(PersonaMayor persona) {
       jdbcTemplate.update("INSERT INTO PersonaMayor values(?,?,?,?,?,?,?,?,?,?,?,?,?)", 
    		   persona.getDni(), persona.getNombre(), persona.getApellidos(), persona.getFecha_ncto(), persona.getDireccion(),
    		   persona.getTelefono(), persona.getNumero_cuenta(), persona.getEmail(), persona.getUserPwd(), 
    		   persona.getFecha_creacion(), persona.getAlergias(), persona.getEnfermedades(), persona.getUsuarioCAS());
   }

   void deletePersonaMayor(PersonaMayor persona) {
       jdbcTemplate.update("DELETE FROM PersonaMayor WHERE dni=?",persona.getDni());
   }

   
	void updatePersonaMayor(PersonaMayor persona) {
		jdbcTemplate.update("UPDATE PersonaMayor set nombre=?, apellidos=?, fecha_ncto=?, direccion=?, telefono=?, numero_cuenta=?,"
				+ "email=?, userPwd=?, fecha_creacion=?, alergias=?, enfermedades=?, usuarioCAS",
				 persona.getNombre(), persona.getApellidos(), persona.getFecha_ncto(), persona.getDireccion(),
	    		   persona.getTelefono(), persona.getNumero_cuenta(), persona.getEmail(), persona.getUserPwd(), 
	    		   persona.getFecha_creacion(), persona.getAlergias(), persona.getEnfermedades(), persona.getUsuarioCAS());
	}
   
	
	PersonaMayor getPersonaMayor(String dni) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM PersonaMayor where dni=?", new PersonaMayorRowMapper(), dni);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
  
   List<PersonaMayor> getPersonasMayores() {
       try {
           return jdbcTemplate.query("SELECT * from PersonaMayor", new PersonaMayorRowMapper());
       }
       catch(EmptyResultDataAccessException e) {
           return new ArrayList<PersonaMayor>();
       }
   }
}