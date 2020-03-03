package es.uji.ei1027.clubesportiu;

import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ClubesportiuApplication implements CommandLineRunner {

	private static final Logger log = Logger.getLogger(ClubesportiuApplication .class.getName());

	public static void main(String[] args) {
		// Auto-configura l'aplicació
		new SpringApplicationBuilder(ClubesportiuApplication .class).run(args);
	}

	// Funció principal
	public void run(String... strings) throws Exception {
		/*log.info("Ací va el meu codi");
		log.info("Selecciona la nadadora Gemma Mengual");
		Nadador n1 = jdbcTemplate.queryForObject(
		     "SELECT * FROM Nadador WHERE nom = 'Gemma Mengual'",
		     new NadadorRowMapper());
		log.info(n1.toString());
		log.info("Selecciona la nadadora Gemma Mengual (amb paràmetre)");
		Nadador n2 = jdbcTemplate.queryForObject(
		     "SELECT * FROM Nadador WHERE nom =?",
		     new NadadorRowMapper(),
		     "Gemma Mengual");
		log.info(n2.toString());*/
		
		//Exercici 3
		log.info("Actualitza l'edat de la nadadora Ariadna Edo a 21 anys");
		jdbcTemplate.update("UPDATE nadador SET edat=? Where nom='Ariadna Edo' ",21);
		log.info("I comprova que s'haja modificat correctament");
		mostraNadador("Ariadna Edo");

		log.info("Esborra la nadadora Ariadna Edo");
		jdbcTemplate.update("DELETE from nadador Where nom='Ariadna Edo' ");
		log.info("I comprova que s'haja esborrat correctament");
		mostraNadador("Ariadna Edo");

		provaNadadorDao();
	}	
	// Configura l'accés a la base de dades (DataSource)
	// a partir de les propietats a src/main/resources/applications.properties
	// que comencen pel prefix spring.datasource
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
	  return DataSourceBuilder.create().build();
	}
	
	// Plantilla per a executar operacions sobre la conexió 
	private JdbcTemplate jdbcTemplate;

	// Crea el jdbcTemplate a partir del DataSource que hem configurat
	@Autowired
	public void setDataSource(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	void mostraNadador(String nomNadador) {
		try {
            log.info(jdbcTemplate.queryForObject("SELECT * from Nadador WHERE nom=?",
                    new NadadorRowMapper(), nomNadador).toString());
        }
        catch(EmptyResultDataAccessException e) {
            log.info("El nadador " + nomNadador  + " no es troba a la base de dades");
        }
	}
	
	// Demana a Spring que ens proporcione una instància de NadadorDAO
	// mitjanjant injecció de dependencies
	@Autowired
	NadadorDao nadadorDao;

	void provaNadadorDao() {
	  log.info("Provant NadadorDao");
	  log.info("Tots els nadadors");

	  for (Nadador n: nadadorDao.getNadadors()) {
	     log.info(n.toString());
	  }

	  log.info("Dades de Gemma Mengual");
	  Nadador n = nadadorDao.getNadador("Gemma Mengual");
	  log.info(n.toString());

	  Nadador aEdo = new Nadador();
	  aEdo.setNom("Ariadna Edo");
	  aEdo.setEdat(21);
	  log.info("Nou: Ariadna Edo");
	  nadadorDao.addNadador(aEdo);
	  log.info(nadadorDao.getNadador("Ariadna Edo").toString());

	  log.info("Actualitzat: Ariadna Edo");
	  aEdo.setPais("Espanya");
	  aEdo.setGenere("Femení");
	  nadadorDao.updateNadador(aEdo);

	  log.info("Esborrat: Ariadna Edo");
	  nadadorDao.deleteNadador(aEdo);
	  if (nadadorDao.getNadador("Ariadna Edo") == null) {
	     log.info("Esborrada correctament");
	  }
	}
}
