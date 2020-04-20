package es.uji.ei1027.clubesportiu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import es.uji.ei1027.clubesportiu.model.Pagada;

public class PagadaDao {
	  private JdbcTemplate jdbcTemplate;

	  public void setDataSource(DataSource dataSource) {
	      jdbcTemplate = new JdbcTemplate(dataSource);
	  }

	  void addPagada(Pagada pagada) {
	      jdbcTemplate.update("INSERT INTO Pagadas values(?,?)", 
	      pagada.getNumero_peticion(), pagada.getNumero_factura());
	  }

	  void deletePagada(Pagada pagada) {
	      jdbcTemplate.update("DELETE FROM Pagadas WHERE numero_peticion=? and numero_factura=?",
	    		  pagada.getNumero_peticion(), pagada.getNumero_factura());
	  }

	   
	void updatePagadas(Pagada pagada) {
		jdbcTemplate.update("UPDATE Pagadas set numero_peticion=?, numero_factura=?",
		pagada.getNumero_peticion(), pagada.getNumero_factura());
	}
	   

	Pagada getPagada(int numero_peticion, int numero_factura) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM Pagadas where numero_peticion=? and numero_factura=?", 
					new PagadaRowMapper(), numero_peticion, numero_factura);
		} 
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	 
	  List<Pagada> getPagadas() {
	      try {
	          return jdbcTemplate.query("SELECT * from Pagadas", new PagadaRowMapper());
	      }
	      catch(EmptyResultDataAccessException e) {
	          return new ArrayList<Pagada>();
	      }
	  }

	}
