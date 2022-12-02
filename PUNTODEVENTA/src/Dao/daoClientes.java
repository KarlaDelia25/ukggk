package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.conexion;
import Modelo.Clientes;



public class daoClientes {
	conexion cx;

	public daoClientes() {
		cx = new conexion();
	}

	public boolean insertarclientes(Clientes prov) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("INSERT INTO clientes VALUES(null,?,?,?,?)");
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

	public ArrayList<Clientes> consultaclientes() {
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = cx.conectar().prepareStatement("SELECT * FROM clientes");
			rs = ps.executeQuery();
			while (rs.next()) {
				Clientes clientes = new Clientes();
				clientes.setIdClientes(rs.getInt("id"));
				clientes.setNombre(rs.getString("nombre"));
				clientes.setEmail(rs.getString("email"));
				clientes.setDireccion(rs.getString("direccion"));
				clientes.setTelefono(rs.getInt("telefono"));
				lista.add(clientes);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public boolean eliminarclientes(int id) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("DELETE FROM clientes WHERE id =?");
			ps.setInt(1, id);
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

public boolean editarclientes(Clientes clien) {
	PreparedStatement ps = null;
	try {
		ps = cx.conectar().prepareStatement("UPDATE clientes SET nombre=?,email=?,direccion=?,telefono=? WHERE id=?");
		ps.setString(1, clien.getNombre());
		ps.setString(2, clien.getEmail());
		ps.setString(3, clien.getDireccion());
		ps.setInt(4, clien.getTelefono());
		ps.setInt(5, clien.getIdClientes());
		ps.executeUpdate();
		cx.desconectar();
		return true;
	} catch (SQLException e) {

		e.printStackTrace();

		return false;
	}

}
}

