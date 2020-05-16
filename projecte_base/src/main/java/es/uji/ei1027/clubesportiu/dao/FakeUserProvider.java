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

import org.jasypt.util.password.BasicPasswordEncryptor; 
import org.springframework.stereotype.Repository;
import es.uji.ei1027.clubesportiu.model.UserDetails;

@Repository
public class FakeUserProvider implements UserDao {
  final Map<String, UserDetails> knownUsers = new HashMap<String, UserDetails>();

  public FakeUserProvider() throws SQLException {
	BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor(); 
	/*UserDetails userAlice = new UserDetails();
	userAlice.setUsername("alice"); 
	userAlice.setPassword(passwordEncryptor.encryptPassword("alice")); 
	knownUsers.put("alice", userAlice);
   UserDetails userBob = new UserDetails(); 
   userBob.setUsername("bob"); 
   userBob.setPassword(passwordEncryptor.encryptPassword("bob")); 
   knownUsers.put("bob", userBob);*/
   
   Connection connection = null;
   try {
       String url = "jdbc:postgresql://db-aules.uji.es:5432/ei102719cp";
       Properties props = new Properties();
       props.setProperty("user", "ei102719cp");
       props.setProperty("password","ei102719cp");
       connection = DriverManager.getConnection(url, props);
   } catch (SQLException e) {
       System.out.println("Error de connexió");
       e.printStackTrace();
       return;
   }
   if (connection != null) {
       System.out.println("Connectat correctament!");
   } else {
       System.out.println("La connexió ha fallat!");
   }
   ResultSet resultSet = null;
   Statement statement = null;
   try {
       System.out.println("Executant la consulta...");
       statement = connection.createStatement();

       String sql = "SELECT nombre, userPwd, dni FROM personaMayor";

       resultSet = statement.executeQuery(sql);
       System.out.println("Personas Mayores ");
       if (resultSet != null) { // Si result == null no hi ha dades que mostrar
           while (resultSet.next()) // amb este while processem totes les tuples que hi ha en el ResultSet
           {   
        	   UserDetails user = new UserDetails(); 
        	   user.setUsername(resultSet.getString(1)); 
        	   user.setPassword(passwordEncryptor.encryptPassword(resultSet.getString(1))); 
               knownUsers.put(resultSet.getString(1),user);
           }
       }
   }
   catch (SQLException e) {
       System.out.println("No ha segut possible executar la consulta.... ");
       e.printStackTrace();
       return;
   }
   System.out.println(knownUsers.toString());
  }

  @Override
  public UserDetails loadUserByUsername(String username, String password) { 
	  UserDetails user = knownUsers.get(username.trim());
	  if (user == null)
		  return null; // Usuari no trobat
	  // Contrasenya
	 BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor(); 
	 if (passwordEncryptor.checkPassword(password, user.getPassword())) {
	 // Es deuria esborrar de manera segura el camp password abans de tornar-lo
		 
		 return user; 
        } 
	 else {
		 return null; // bad login!
	 }
  }

  @Override 
  public Collection<UserDetails> listAllUsers() {
	 return knownUsers.values();
  }
}