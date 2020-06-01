package es.uji.ei1027.clubesportiu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.clubesportiu.model.Empresa;

@Repository
public class EmpresaDao {
	   
	static JdbcTemplate jdbcTemplate;

	   @Autowired
	   public void setDataSource(DataSource dataSource) {
	       jdbcTemplate = new JdbcTemplate(dataSource);
	   }

	   public void addEmpresa(Empresa empresa) {
	       jdbcTemplate.update("INSERT INTO Empresa VALUES(?,?,?,?,?,?,?)", empresa.getCif(), empresa.getNombre(), empresa.getDireccion(),
	    		   empresa.getNombre_contacto(), empresa.getTelefono_contacto(), empresa.getEmail_contacto(), empresa.getTipo_servicio());
	   }

	   void deleteEmpresa(Empresa empresa) {
	       jdbcTemplate.update("DELETE FROM Empresa WHERE cif=?", empresa.getCif());
	   }

	   public void deleteEmpresa(String cif) {
	       jdbcTemplate.update("DELETE FROM Empresa WHERE cif=?", cif);
	   }
		public void updateEmpresa(Empresa empresa) {
			jdbcTemplate.update("UPDATE Empresa SET nombre=?, direccion=?, nombre_contacto=?, telefono_contacto=?, email_contacto=?, tipo_servicio=?",
					empresa.getNombre(), empresa.getDireccion(), empresa.getNombre_contacto(), empresa.getTelefono_contacto(),
					empresa.getEmail_contacto(), empresa.getTipo_servicio());
		}
	   
		public Empresa getEmpresa(String cif) {
			try {
				return jdbcTemplate.queryForObject("SELECT * FROM Empresa WHERE cif=?", new EmpresaRowMapper(), cif);
			} catch (EmptyResultDataAccessException e) {
				return null;
			}
		}
		
	   public List<Empresa> getEmpresas() {
	       try {
	    	   List<Empresa> empresas = jdbcTemplate.query("SELECT * FROM Empresa", new EmpresaRowMapper());
	    	   System.out.println(empresas.toString());
	    	   return empresas;
	       }
	       catch(EmptyResultDataAccessException e) {
	           return new ArrayList<Empresa>();
	       }
	   }

}
