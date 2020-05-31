package es.uji.ei1027.clubesportiu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.clubesportiu.model.Peticion;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Repository // En Spring els DAOs van anotats amb @Repository
public class PeticionDao {

   static JdbcTemplate jdbcTemplate;

   // Obté el jdbcTemplate a partir del Data Source
   @Autowired
   public void setDataSource(DataSource dataSource) {
       jdbcTemplate = new JdbcTemplate(dataSource);
   }

   
   public void addPeticion(Peticion peticion) {
       jdbcTemplate.update("INSERT INTO Peticion values(?,?,?,?,?,?,?,?,?,?)", 
    		   peticion.getNumero(), peticion.getTipo_servicio(), peticion.getFecha_creacion(), peticion.getEstado(),
    		   peticion.getFecha_aprobacion(), peticion.getFecha_rechazado(), peticion.getComentarios(), peticion.getFecha_finalizacion(),
    		   peticion.getDni_personaMayor(), peticion.getNumero_contrato());
   }
   
   public void anadirPeticion(Peticion peticion) {
	   try{
		   String estado = "pendiente";
		   System.out.println("que esta pasando");
		   List<Peticion> pet = getPeticiones();
		   int maximo=0;
		   for(int i=0; i<pet.size();i++) {
			   if(pet.get(i).getNumero()> maximo) {
				   maximo=pet.get(i).getNumero();
			   }
		   }
		   System.out.println("Maximo " + maximo);
		   maximo++;
		   jdbcTemplate.update("INSERT INTO Peticion (numero, tipo_servicio, dni_personamayor, estado) VALUES (?,?,?,?)",
				   maximo, peticion.getTipo_servicio(), peticion.getDni_personaMayor(), estado);
	   }
	   catch(Exception ex) {
		   System.out.println("Excepcion " + ex);
	   }
   }
   
   void deletePeticion(Peticion peticion) {
       jdbcTemplate.update("DELETE FROM Peticion WHERE numero=?",peticion.getNumero());
   }

   
	void updatePeticion(Peticion peticion) {
		jdbcTemplate.update("UPDATE Peticion set tipo_servicio=?, fecha_creacion=?, estado=?, fecha_aprobacion=?, fecha_rechazado=?, "
				+ "comentarios=?, fecha_finalizacion=?, dni_personaMayor=?,  numero_contrato=?",
				peticion.getTipo_servicio(), peticion.getFecha_creacion(), peticion.getEstado(),
	    		   peticion.getFecha_aprobacion(), peticion.getFecha_rechazado(), peticion.getComentarios(), peticion.getFecha_finalizacion(),
	    		   peticion.getDni_personaMayor(), peticion.getNumero_contrato());
	}
   
	
	Peticion getPeticion(int numero) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM Peticion where numero=?", new PeticionRowMapper(), numero);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
   
   public List<Peticion> getPeticiones() {
       try {
           return jdbcTemplate.query("SELECT * from Peticion", new PeticionRowMapper());
       }
       catch(NullPointerException e) {
           return new ArrayList<Peticion>();
       }
   }
   public List<Peticion> getPeticionesFromUser(String dni){
	   try {
		   List<Peticion> resultado = jdbcTemplate.query("SELECT * from Peticion where dni_personaMayor=?", new PeticionRowMapper(), dni);
           return resultado;
       }
       catch(NullPointerException e) {
           return new ArrayList<Peticion>();
       }
   }
   
   public List<Peticion> getPeticionesFromEmpresa(String cif){
	   try {
		   List<Peticion> resultado = jdbcTemplate.query("SELECT * from Peticion where cif_empresa=?", new PeticionRowMapper(), cif);
           return resultado;
       }
       catch(NullPointerException e) {
           return new ArrayList<Peticion>();
       }
   }
   
}