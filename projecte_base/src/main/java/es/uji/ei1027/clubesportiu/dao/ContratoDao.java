package es.uji.ei1027.clubesportiu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.clubesportiu.model.Contrato;

@Repository
public class ContratoDao {
	   private JdbcTemplate jdbcTemplate;

	   @Autowired
	   public void setDataSource(DataSource dataSource) {
	       jdbcTemplate = new JdbcTemplate(dataSource);
	   }

	   void addContrato(Contrato contrato) {
	       jdbcTemplate.update("INSERT INTO Contrato VALUES(?,?,?,?,?,?,?,?,?)", contrato.getNumero(), contrato.getFecha_inicio(),
	    		   contrato.getFecha_fin(), contrato.getDescripcion(), contrato.getTipo_servicio(), contrato.getCantidad_servicios(),
	    		   contrato.getUnidades_de_medida(), contrato.getPrecio_unidad(), contrato.getCif_empresa());
	   }

	   void deleteContrato(Contrato contrato) {
	       jdbcTemplate.update("DELETE FROM Contrato WHERE numero=?", contrato.getNumero());
	   }

		void updateContrato(Contrato contrato) {
			jdbcTemplate.update("UPDATE Contrato SET fecha_inicio=?, fecha_fin=?, descripcion=?, tipo_servicio=?, cantidad_servicios=?, unidades_de_medida=?, precio_unidad=?, cif_empresa=?",
					contrato.getFecha_inicio(), contrato.getFecha_fin(), contrato.getDescripcion(),
					contrato.getTipo_servicio(), contrato.getCantidad_servicios(), contrato.getUnidades_de_medida(),
					contrato.getPrecio_unidad(), contrato.getCif_empresa());
		}
	   
		Contrato getContrato(int numero) {
			try {
				return jdbcTemplate.queryForObject("SELECT * FROM Contrato WHERE numero=?", new ContratoRowMapper(), numero);
			} catch (EmptyResultDataAccessException e) {
				return null;
			}
		}
		
	   public List<Contrato> getContratos() {
	       try {
	           return jdbcTemplate.query("SELECT * FROM Contrato", new ContratoRowMapper());
	       }
	       catch(EmptyResultDataAccessException e) {
	           return new ArrayList<Contrato>();
	       }
	   }

}
