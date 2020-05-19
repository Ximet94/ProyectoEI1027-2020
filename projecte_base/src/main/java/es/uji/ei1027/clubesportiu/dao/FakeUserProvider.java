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
import es.uji.ei1027.clubesportiu.model.Empresa;
import es.uji.ei1027.clubesportiu.model.PersonaMayor;
import es.uji.ei1027.clubesportiu.model.TrabajadorSocial;

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
	  System.out.println(passwordEncryptor.encryptPassword(password));
	  try {
		  PersonaMayor pm = jdbcTemplate.queryForObject("SELECT * FROM personaMayor where dni=?",new PersonaMayorRowMapper(), username);
		  if(pm != null) {
			  System.out.println("Es una persona mayor");
			  //La persona que se ha logueado es una personaMayor
			  user.setUsername(username);
			  if(passwordEncryptor.checkPassword(password, pm.getUserPwd())){
				  // Es deuria esborrar de manera segura el camp password abans de tornar-lo
				  user.setPassword(password);
				  user.setRole("personaMayor");
				  return user;
			  } 
			  else {
				  return null; // bad login!
			  }
		  }
	  }
	  catch(Exception ex) {
	  }
	  
	  try {
		  Voluntario voluntario = jdbcTemplate.queryForObject("SELECT * FROM voluntario where dni=?", new VoluntarioRowMapper(), username);
		  if(voluntario != null) {
			  System.out.println("Encontrado voluntario");
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
	  }
	  catch(Exception ex) {
		  
	  }
	  
	  try {
		  TrabajadorSocial trabajador= jdbcTemplate.queryForObject("SELECT * FROM trabajador where dni=?", new TrabajadorSocialRowMapper(), username);
		  if(trabajador != null) {
			  System.out.println("Encontrado voluntario");
			  //La persona que se ha logueado es un voluntario
			  user.setUsername(username);
			  if (passwordEncryptor.checkPassword(password, trabajador.getPwd())) {
					 // Es deuria esborrar de manera segura el camp password abans de tornar-lo
				  	user.setPassword(password);
				  	user.setRole("voluntario");
				  	return user;
			  } 
			  else {
					 return null; // bad login!
			  }
		  }
	  }
	  catch(Exception ex) {
		  
	  }
	  
	  try {
		  Empresa empresa = jdbcTemplate.queryForObject("SELECT * FROM empresa where cif=?", new EmpresaRowMapper(), username);
		  if(empresa != null) {
			  //La persona que se ha logueado es un voluntario
			  user.setUsername(username);
			  if (passwordEncryptor.checkPassword(password, empresa.getPwd())) {
					 // Es deuria esborrar de manera segura el camp password abans de tornar-lo
				  	user.setPassword(password);
				  	user.setRole("voluntario");
				  	return user;
			  } 
			  else {
					 return null; // bad login!
			  }
		  }
	  }
	  catch(Exception ex) {
		  
	  }
	  
	  return null;
  }

  @Override 
  public Collection<UserDetails> listAllUsers() {
	 return knownUsers.values();
  }
}