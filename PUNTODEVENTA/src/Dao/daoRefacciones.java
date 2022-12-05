package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.conexion;
import Modelo.Refacciones;


public class daoRefacciones{
	conexion cx;

	public daoRefacciones() {
		cx = new conexion();
	}

	public boolean insertarProductos(Refacciones produc) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("INSERT INTO productos VALUES(null,?,?,?)");
			ps.setString(1, produc.getDescripccion());
			ps.setDouble(2, produc.getPrecio());
			ps.setDouble(3, produc.getPrecioventa());
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

	public ArrayList<Refacciones> consultaProductoss() {
		ArrayList<Refacciones> lista = new ArrayList<Refacciones>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = cx.conectar().prepareStatement("SELECT * FROM productos");
			rs = ps.executeQuery();
			while (rs.next()) {
				Refacciones productos = new Refacciones();
				productos.setIdproductos(rs.getInt("idproductos"));
				productos.setDescripccion(rs.getString("descripcion"));
				productos.setPrecio(rs.getDouble("precio"));
				productos.setPrecioventa(rs.getDouble("precioventa"));
				lista.add(productos);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public boolean eliminarProductos(int idproductos) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("DELETE FROM productos WHERE idproductos =?");
			ps.setInt(1, idproductos);
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

public boolean editarProductos(Refacciones produc) {
	PreparedStatement ps = null;
	try {
		ps = cx.conectar().prepareStatement("UPDATE productos  SET descripcion=?,precio=?,precioventa=? WHERE idproductos=?");
		ps.setString(1, produc.getDescripccion());
		ps.setDouble(2, produc.getPrecio());
		ps.setDouble(3, produc.getPrecioventa());
		ps.setInt(5, produc.getIdproductos());
		ps.executeUpdate();
		cx.desconectar();
		return true;
	} catch (SQLException e) {

		e.printStackTrace();

		return false;
	}

}
}


