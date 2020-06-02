package es.uji.ei1027.clubesportiu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.clubesportiu.model.Contrato;
import es.uji.ei1027.clubesportiu.model.Empresa;
import es.uji.ei1027.clubesportiu.model.Peticion;

@Repository
public class ContratoDao {
	   static JdbcTemplate jdbcTemplate;

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
	   
	   public List<Contrato> getContratosFromEmpresa(String cif) {
	       try {
	           return jdbcTemplate.query("SELECT * FROM Contrato where cif_empresa=? and fecha_fin is null", new ContratoRowMapper(),cif);
	       }
	       catch(NullPointerException e) {
	           return new ArrayList<Contrato>();
	       }
	   }
	   public List<Contrato> getHistoricoContratos(String cif){
		   try {
	           return jdbcTemplate.query("SELECT * FROM Contrato where cif_empresa=?", new ContratoRowMapper(),cif);
	       }
	       catch(NullPointerException e) {
	           return new ArrayList<Contrato>();
	       }
	   }
	   
	   
	   public Empresa getEmpresaLibre() { 
		   try {
			   String sql = "select cif from empresa left join contrato on empresa.cif=contrato.cif_empresa where fecha_fin is null";
			   String cif = (String) jdbcTemplate.queryForObject(sql,String.class);
			   System.out.println("Encontrado el cif " + cif);
			   EmpresaDao empresaDao = new EmpresaDao();
			   Empresa empresa = empresaDao.getEmpresa(cif);
			   System.out.println("Encontrado empresa  -> " + empresa.toString());
			   return empresa;
	           //return jdbcTemplate.query("select * from empresa left join contrato on empresa.cif=contrato.cif_empresa where fecha_fin is null;   ", new ContratoRowMapper(),cif);
	       }
	       catch(NullPointerException e) {
	    	   System.out.println("Excepcion " + e.toString());
	           return new Empresa();
	       }
	   }
	   
	   public void anadirContrato(Contrato contrato) {
		   try{
			   System.out.println("Contrato nuevo " + contrato.toString());
			   List<Contrato> pet = getContratos();
			   int maximo=0;
			   for(int i=0; i<pet.size();i++) {
				   if(pet.get(i).getNumero()> maximo) {
					   maximo=pet.get(i).getNumero();
				   }
			   }
			   maximo++;
			   System.out.println("Maximo " + maximo);
			   
			   jdbcTemplate.update("INSERT INTO Contrato (numero, fecha_inicio, tipo_servicio, cif_empresa) VALUES (?,?,?,?)",
					   maximo, contrato.getFecha_inicio(), contrato.getTipo_servicio(), contrato.getCif_empresa());
		   }
		   catch(Exception ex) {
			   System.out.println("Excepcion " + ex);
		   }
	   }

}
