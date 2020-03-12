package es.uji.ei1027.clubesportiu;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmpresaDao {
	   private JdbcTemplate jdbcTemplate;

	   @Autowired
	   public void setDataSource(DataSource dataSource) {
	       jdbcTemplate = new JdbcTemplate(dataSource);
	   }

	   void addEmpresa(Empresa empresa) {
	       jdbcTemplate.update("INSERT INTO Empresa VALUES(?,?,?,?,?,?,?)", empresa.getCif(), empresa.getNombre(), empresa.getDireccion(),
	    		   empresa.getNombre_contacto(), empresa.getTelefono_contacto(), empresa.getEmail_contacto(), empresa.getTipo_servicio());
	   }

	   void deleteEmpresa(Empresa empresa) {
	       jdbcTemplate.update("DELETE FROM Empresa WHERE cif=?", empresa.getCif());
	   }

		void updateEmpresa(Empresa empresa) {
			jdbcTemplate.update("UPDATE Empresa SET nombre=?, direccion=?, nombre_contacto=?, telefono_contacto=?, email_contacto=?, tipo_servicio=?",
					empresa.getNombre(), empresa.getDireccion(), empresa.getNombre_contacto(), empresa.getTelefono_contacto(),
					empresa.getEmail_contacto(), empresa.getTipo_servicio());
		}
	   
		Empresa getEmpresa(String cif) {
			try {
				return jdbcTemplate.queryForObject("SELECT * FROM Empresa WHERE cif=?", new EmpresaRowMapper(), cif);
			} catch (EmptyResultDataAccessException e) {
				return null;
			}
		}
		
	   List<Empresa> getEmpresas() {
	       try {
	           return jdbcTemplate.query("SELECT * FROM Empresa", new EmpresaRowMapper());
	       }
	       catch(EmptyResultDataAccessException e) {
	           return new ArrayList<Empresa>();
	       }
	   }

}
