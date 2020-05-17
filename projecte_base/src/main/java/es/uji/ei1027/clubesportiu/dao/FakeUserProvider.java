package es.uji.ei1027.clubesportiu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap; 
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import es.uji.ei1027.clubesportiu.model.UserDetails;
import es.uji.ei1027.clubesportiu.model.Voluntario;
import es.uji.ei1027.clubesportiu.model.PersonaMayor;

@Repository
public class FakeUserProvider implements UserDao {
  final Map<String, UserDetails> knownUsers = new HashMap<String, UserDetails>();
  JdbcTemplate jdbcTemplate;
  

  	@Autowired
	public void setDataSource(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}
  
  @Override
  public UserDetails loadUserByUsername(String username, String password) {
	  UserDetails user = new UserDetails();
	  BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor(); 
	  PersonaMayor pm = jdbcTemplate.queryForObject("SELECT * FROM personaMayor where nombre=?",new PersonaMayorRowMapper(), username);
	  if(pm != null) {
		  //La persona que se ha logueado es una personaMayor
		  user.setUsername(username);
		  System.out.println(password);
		  System.out.println(pm.getUserPwd());
		  //if (passwordEncryptor.checkPassword(password, pm.getUserPwd())) {
		  if (password.equals(pm.getUserPwd())) {
				 // Es deuria esborrar de manera segura el camp password abans de tornar-lo
			  	user.setPassword(password);
			  	user.setRole("personaMayor");
			  	return user;
		  } 
		  else {
				 return null; // bad login!
		  }
	  }
	  
	  Voluntario voluntario = jdbcTemplate.queryForObject("SELECT * FROM voluntario where usuario=?", new VoluntarioRowMapper(), username);
	  if(voluntario != null) {
		  //La persona que se ha logueado es un voluntario
		  user.setUsername(username);
		  if (passwordEncryptor.checkPassword(password, voluntario.getPwd())) {
				 // Es deuria esborrar de manera segura el camp password abans de tornar-lo
			  	user.setPassword(password);
			  	user.setRole("voluntario");
			  	return user;
		  } 
		  else {
				 return null; // bad login!
		  }
	  }
	  return null;
  }

  @Override 
  public Collection<UserDetails> listAllUsers() {
	 return knownUsers.values();
  }
}