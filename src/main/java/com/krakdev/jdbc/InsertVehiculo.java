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
				INSERT INTO vehiculos(placa, marca, modelo, anio, precio, color, disponible, kilometraje)
				VALUES(?,?,?,?,?,?,?,?)
			""";
		
		try {

			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			

			ps.setString(1, "FFF-123");
			ps.setString(2, "Ferrari");
			ps.setString(3, "296 GT3");
			ps.setInt(4, 2023);
			ps.setDouble(5, 650000);
			ps.setString(6, "Rojo Corsa");
			ps.setBoolean(7, true);
			ps.setInt(8, 1000);
			
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
