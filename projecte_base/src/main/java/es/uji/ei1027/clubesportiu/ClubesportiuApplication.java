package es.uji.ei1027.clubesportiu;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClubesportiuApplication implements CommandLineRunner {

	private static final Logger log = Logger.getLogger(ClubesportiuApplication .class.getName());
	
    public static void main(String[] argv) {
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

        // Ara, anem a fer una consulta per a extraure
        // les dades de la taula Nadador
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            System.out.println("Executant la consulta...");
            statement = connection.createStatement();

            String sql = "SELECT * FROM trabajador";

            resultSet = statement.executeQuery(sql);
            System.out.println("Dades trobades...");
            // Mostrar el ResultSet
            if (resultSet != null) { // Si result == null no hi ha dades que mostrar
                while (resultSet.next()) // amb este while processem totes les tuples que hi ha en el ResultSet
                {   /* Per a cada columna hem de buscar la seua dada:*/
                    System.out.println("Nombre del usuarioCAS: " + resultSet.getString(1));  //en este cas accedim per número de columna
                    System.out.println("Nombre del usuario: " + resultSet.getString(2));
                    System.out.println("Password del usuario " + resultSet.getString(3));
                    System.out.println("Teléfono del usuario" + resultSet.getInt(4));
                    System.out.println("Email del usuario" + resultSet.getString(5));
                    System.out.println("----------------------------------");
                }
                //while(true) {}
            }
        }
        catch (SQLException e) {
            System.out.println("No ha segut possible executar la consulta.... ");
            e.printStackTrace();
            return;
        }
        finally {
            // Cal alliberar explícitament tots els recursos
            System.out.println("Alliberant recursos...");
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fet!");
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Apéndice de método generado automáticamente
		log.info("Ací va el meu codi");
	}

}
