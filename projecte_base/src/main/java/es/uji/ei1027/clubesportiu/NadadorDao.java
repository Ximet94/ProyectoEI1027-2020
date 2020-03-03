package es.uji.ei1027.clubesportiu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Repository // En Spring els DAOs van anotats amb @Repository
public class NadadorDao {

   private JdbcTemplate jdbcTemplate;

   // Obté el jdbcTemplate a partir del Data Source
   @Autowired
   public void setDataSource(DataSource dataSource) {
       jdbcTemplate = new JdbcTemplate(dataSource);
   }

   /* Afegeix el nadador a la base de dades */
   void addNadador(Nadador nadador) {
       jdbcTemplate.update("INSERT INTO Nadador values(?,?,?,?,?)", nadador.getNom(),nadador.getNumFederat(), nadador.getPais(),
    		   nadador.getEdat(), nadador.getGenere());
   }

   /* Esborra el nadador de la base de dades */
   void deleteNadador(Nadador nadador) {
       jdbcTemplate.update("DELETE from Nadador Where nom=?",nadador.getNom());
   }

   /* Actualitza els atributs del nadador
      (excepte el nom, que és la clau primària) */
   void updateNadador(Nadador nadador) {
       jdbcTemplate.update("UPDATE Nadador set num_federat=?, pais=?, edat=?, sexe=? where nom=?",
    		   nadador.getNumFederat(), nadador.getPais(), nadador.getEdat(), nadador.getGenere(), nadador.getNom());
   }

   /* Obté el nadador amb el nom donat. Torna null si no existeix. */
   Nadador getNadador(String nomNadador) {
       try {
           return jdbcTemplate.queryForObject("SELECT * FROM Nadador where nom=?", new NadadorRowMapper(), nomNadador);
       }
       catch(EmptyResultDataAccessException e) {
           return null;
       }
   }

   /* Obté tots els nadadors. Torna una llista buida si no n'hi ha cap. */
   List<Nadador> getNadadors() {
       try {
           return jdbcTemplate.query("SELECT * from Nadador", new NadadorRowMapper());
       }
       catch(EmptyResultDataAccessException e) {
           return new ArrayList<Nadador>();
       }
   }
}