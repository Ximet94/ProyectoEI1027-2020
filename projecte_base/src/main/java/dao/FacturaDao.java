package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Factura;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Repository // En Spring els DAOs van anotats amb @Repository
public class FacturaDao {

   private JdbcTemplate jdbcTemplate;

   // Obté el jdbcTemplate a partir del Data Source
   @Autowired
   public void setDataSource(DataSource dataSource) {
       jdbcTemplate = new JdbcTemplate(dataSource);
   }

   
   void addFactura(Factura factura) {
       jdbcTemplate.update("INSERT INTO Factura values(?,?,?,?,?)", 
    		   factura.getNumero(), factura.getFecha(), factura.getCantidad(), factura.getConcepto(), factura.getDni_personaMayor());
   }
   
   
   void deleteFactura(Factura factura) {
       jdbcTemplate.update("DELETE FROM Factura WHERE numero=?",factura.getNumero());
   }

	void updateFactura(Factura factura) {
		jdbcTemplate.update("UPDATE Factura set numero=?, fecha=?, cantidad=?, concepto=?, dni_personaMayor=?",
				factura.getFecha(), factura.getCantidad(), factura.getConcepto(), factura.getDni_personaMayor());
	}
	
	Factura getFactura(int numero) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM Factura where numero=?", new FacturaRowMapper(), numero);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
   /* Obtiene todos los trabajadores sociales.*/
   List<Factura> getFacturas() {
       try {
           return jdbcTemplate.query("SELECT * from Factura", new FacturaRowMapper());
       }
       catch(EmptyResultDataAccessException e) {
           return new ArrayList<Factura>();
       }
   }
}