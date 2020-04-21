package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import model.Contrato;

public class ContratoRowMapper implements RowMapper<Contrato> {
	
	@Override
	public Contrato mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contrato contrato = new Contrato();
		contrato.setNumero(rs.getInt("numero"));
		contrato.setFecha_inicio(rs.getDate("fecha_inicio"));
		contrato.setFecha_fin(rs.getDate("fecha_fin"));
		contrato.setDescripcion(rs.getString("descripcion"));
		contrato.setTipo_servicio(rs.getString("tipo_servicio"));
		contrato.setCantidad_servicios(rs.getInt("cantidad_servicios"));
		contrato.setUnidades_de_medida(rs.getString("unidades_de_medida"));
		contrato.setPrecio_unidad(rs.getDouble("precio_unidad"));
		contrato.setCif_empresa(rs.getString("cif_empresa"));
		
		return contrato;
	}

}
