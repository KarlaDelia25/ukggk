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

	public boolean insertarInventario(Inventario ven) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("INSERT INTO Inventario VALUES(null,?,?,?,?,?)");
			ps.setString(1, ven.getDescripcion());
			ps.setDouble(2, ven.getPrecio());
			ps.setInt(3, ven.getCantidad());
			ps.setInt(4, ven.getImporte());
			ps.setInt(5, ven.getExistencia());
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
			ps = cx.conectar().prepareStatement("SELECT * FROM Inventario");
			rs = ps.executeQuery();
			while (rs.next()) {
				Inventario Inventario = new Inventario();
				Inventario.setCodigo(rs.getInt("codigo"));
				Inventario.setDescripcion(rs.getString("descripcion"));
				Inventario.setPrecio(rs.getDouble("precio"));
				Inventario.setCantidad(rs.getInt("Cantidad"));
				Inventario.setImporte(rs.getInt("Importe"));
				Inventario.setImporte(rs.getInt("Existencia"));
			
				lista.add(Inventario);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public boolean eliminarCaracteristica(int codigo) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("DELETE FROM Inventario WHERE id =?");
			ps.setInt(1, codigo);
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

public boolean editarCaracteristica(Inventario carac) {
	PreparedStatement ps = null;
	try {
		ps = cx.conectar().prepareStatement("UPDATE Inventario  SET descripcion=?,precio=?,cantidad=?,importe=?,existencia=? WHERE codigo=?");
		ps.setString(2, carac.getDescripcion());
		ps.setDouble(3, carac.getPrecio());
		ps.setInt(4, carac.getCantidad());
		ps.setInt(4, carac.getImporte());
		ps.setInt(4, carac.getExistencia());
		ps.executeUpdate();
		cx.desconectar();
		return true;
	} catch (SQLException e) {

		e.printStackTrace();

		return false;
	}

}
}
