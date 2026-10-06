package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class InsertVehiculo {
	
	private static final Logger log = LogManager.getLogger(InsertVehiculo.class);

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = """
				INSERT INTO vehiculos(placa, marca, modelo, anio, precio, color, disponible)
				VALUES(?,?,?,?,?,?,?)
			""";
		
		try {

			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			

			ps.setString(1, "DDD-123");
			ps.setString(2, "Toyota");
			ps.setString(3, "GT-85");
			ps.setInt(4, 1985);
			ps.setDouble(5, 90000);
			ps.setString(6, "Negro");
			ps.setBoolean(7, true);
			
			int filas = ps.executeUpdate();	
			log.info("Vehiculos agregados: "+filas);
			
		}catch(SQLException e){
			log.error("Error en la coneccion: "+e.getMessage());
		}finally {
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
