package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.conexion;
import Modelo.Productos;


public class daoProductos{
	conexion cx;

	public daoProductos() {
		cx = new conexion();
	}

	public boolean insertarProductos(Productos produc) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("INSERT INTO Productoss VALUES(null,?,?,?,?)");
			ps.setString(1, produc.getDescripccion());
			ps.setDouble(2, produc.getPrecio());
			ps.setDouble(3, produc.getPrecioventa());
			ps.setString(4, produc.getImg());
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

	public ArrayList<Productos> consultaProductoss() {
		ArrayList<Productos> lista = new ArrayList<Productos>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = cx.conectar().prepareStatement("SELECT * FROM Productoss");
			rs = ps.executeQuery();
			while (rs.next()) {
				Productos productos = new Productos();
				productos.setId(rs.getInt("id"));
				productos.setDescripccion(rs.getString("descripcion"));
				productos.setPrecio(rs.getDouble("precio"));
				productos.setPrecio(rs.getDouble("precioventa"));
				productos.setImg(rs.getString("img"));
				lista.add(productos);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public boolean eliminarProductos(int id) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("DELETE FROM Productoss WHERE id =?");
			ps.setInt(1, id);
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

public boolean editarProductos(Productos produc) {
	PreparedStatement ps = null;
	try {
		ps = cx.conectar().prepareStatement("UPDATE Productoss  SET descripcion=?,precio=?precioventa=?,img=? WHERE id=?");
		ps.setString(1, produc.getDescripccion());
		ps.setDouble(3, produc.getPrecio());
		ps.setString(4, produc.getImg());
		ps.setInt(4, produc.getId());
		ps.executeUpdate();
		cx.desconectar();
		return true;
	} catch (SQLException e) {

		e.printStackTrace();

		return false;
	}

}
}


