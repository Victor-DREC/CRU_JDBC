package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class UpdateVehiculo {
	

	private static final Logger log = LogManager.getLogger(UpdateVehiculo.class);

	public static void main(String[] args) {
			
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
			
				con = Conexion.getConnection();
				String sql = """
							UPDATE vehiculos SET marca = ?, modelo = ?, anio = ?, precio = ?, color = ?, disponible = ?
							WHERE placa = ? 
						"""; 
				
				ps = con.prepareStatement(sql);
				
				ps.setString(1, "Toyota");
				ps.setString(2, "GT-85");
				ps.setInt(3, 1985);
				ps.setDouble(4, 90000);
				ps.setString(5, "Negro");
				ps.setBoolean(6, false);
				ps.setString(7, "DDD-123");
				
				int filas = ps.executeUpdate();	
				log.info("Vehiculos editados: "+filas);
			
			}catch(Exception e) {
				log.error("Error al actualizar "+e.getMessage());
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