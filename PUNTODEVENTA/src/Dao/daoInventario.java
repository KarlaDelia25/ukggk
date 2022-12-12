package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.conexion;
import Modelo.Inventario;


public class daoInventario {
	conexion cx;

	public daoInventario() {
		cx = new conexion();
	}

	public boolean insertarInventario(Inventario inv) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("INSERT INTO inventario VALUES(null,?,?,?)");
			ps.setInt(1, inv.getExistencia());
			ps.setInt(2, inv.getCantidad());
			ps.setInt(3, inv.getImporte());
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

	public ArrayList<Inventario> consultaInventario() {
		ArrayList<Inventario> lista = new ArrayList<Inventario>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = cx.conectar().prepareStatement("SELECT * FROM inventario");
			rs = ps.executeQuery();
			while (rs.next()) {
				Inventario inventario = new Inventario();
				inventario.setIdinventario(rs.getInt("idinventario"));
				inventario.setExistencia(rs.getInt("existencia"));
				inventario.setCantidad(rs.getInt("cantidad"));
				inventario.setImporte(rs.getInt("importe"));
				lista.add(inventario);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public boolean eliminarInventario(int idinventario) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("DELETE FROM inventario WHERE idinventario=?");
			ps.setInt(1, idinventario);
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

public boolean editarInventario(Inventario inv) {
	PreparedStatement ps = null;
	try {
		ps = cx.conectar().prepareStatement("UPDATE inventario  SET exitencia=?,cantidad=?,importe=? WHERE idinventario=?");
		ps.setInt(1, inv.getExistencia());
		ps.setInt(2, inv.getCantidad());
		ps.setInt(3, inv.getImporte());
		ps.executeUpdate();
		cx.desconectar();
		return true;
	} catch (SQLException e) {

		e.printStackTrace();

		return false;
	}

}
}
