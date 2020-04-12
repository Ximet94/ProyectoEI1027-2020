package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Pagada;

public class PagadaRowMapper implements RowMapper<Pagada> {

	@Override
	public Pagada mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pagada pagada= new Pagada();
		pagada.setNumero_peticion(rs.getInt("numero_peticion"));
		pagada.setNumero_factura(rs.getInt("numero_factura"));;
		   
		return pagada;
	}

}
