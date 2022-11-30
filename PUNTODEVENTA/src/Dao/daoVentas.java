package Dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.conexion;
import Modelo.Ventas;

public class daoVentas {
	conexion cx;

	public daoVentas() {
		cx = new conexion();
	}

	public boolean insertarVentas(Ventas ven) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("INSERT INTO ventas VALUES(null)");
			ps.setInt(1, ven.getCodigo());
		
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

	public ArrayList<Ventas> consultaVentas() {
		ArrayList<Ventas> lista = new ArrayList<Ventas>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = cx.conectar().prepareStatement("SELECT * FROM ventas");
			rs = ps.executeQuery();
			while (rs.next()) {
				Ventas Ventas = new Ventas();
				Ventas.setCodigo(rs.getInt("codigo"));
		
				lista.add(Ventas);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public boolean eliminarCaracteristica(int codigo) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("DELETE FROM ventas WHERE id =?");
			ps.setInt(1, codigo);
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}
}


