package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.conexion;
import Modelo.Proveedores;


public class daoProveedores {
	conexion cx;

	public daoProveedores() {
		cx = new conexion();
	}

	public boolean insertarProveedores(Proveedores prov) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("INSERT INTO proveedores VALUES(null,?,?,?,?)");
			ps.setString(1, prov.getNombre());
			ps.setString(2, prov.getEmail());
			ps.setString(3, prov.getDireccion());
			ps.setInt(4, prov.getTelefono());
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

	public ArrayList<Proveedores> consultaProveedores() {
		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = cx.conectar().prepareStatement("SELECT * FROM proveedores");
			rs = ps.executeQuery();
			while (rs.next()) {
				Proveedores proveedores = new Proveedores();
				proveedores.setId(rs.getInt("id"));
				proveedores.setNombre(rs.getString("nombre"));
				proveedores.setEmail(rs.getString("email"));
				proveedores.setDireccion(rs.getString("direccion"));
				proveedores.setTelefono(rs.getInt("telefono"));
				lista.add(proveedores);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public boolean eliminarProveedores(int id) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("DELETE FROM proveedores WHERE id =?");
			ps.setInt(1, id);
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

public boolean editarProveedores(Proveedores prov) {
	PreparedStatement ps = null;
	try {
		ps = cx.conectar().prepareStatement("UPDATE proveedores  SET nombre=?,email=?,direccion=?,telefono=? WHERE id=?");
		ps.setString(1, prov.getNombre());
		ps.setString(2, prov.getEmail());
		ps.setString(3, prov.getDireccion());
		ps.setInt(4, prov.getTelefono());
		ps.setInt(5, prov.getId());
		ps.executeUpdate();
		cx.desconectar();
		return true;
	} catch (SQLException e) {

		e.printStackTrace();

		return false;
	}

}
}


