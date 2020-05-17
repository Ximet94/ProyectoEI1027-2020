package es.uji.ei1027.clubesportiu;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ClubesportiuApplication implements CommandLineRunner {

	private static final Logger log = Logger.getLogger(ClubesportiuApplication.class.getName());
    
	public JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		 new SpringApplicationBuilder(ClubesportiuApplication.class).run(args);
        // En primer lloc, ens assegurem que el driver de PostgreSQL està disponible
        System.out.println("Prova de connexió a PostgreSQL amb JDBC");
        
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("El driver de JDBC no està al Classpath!");
            e.printStackTrace();
            return;
        }
        System.out.println("Driver JDBC de PostgreSQL registrat");

        // A continuació, creem la connexió
        // En el següent bloc, has de canviar:
        // * En la cadena 'url', substitueix BD pel nom de la base de dades on tens les taules de pràctiques
        // * En les propietats "user" i "password" has de posar el teu usuari i contrasenya
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

    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Apéndice de método generado automáticamente
		
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}


}
