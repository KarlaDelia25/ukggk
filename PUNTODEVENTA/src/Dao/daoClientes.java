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
			ps.setString(1, prov.getNombrecliente());
			ps.setString(2, prov.getEmailcliente());
			ps.setString(3, prov.getDireccioncliente());
			ps.setInt(4, prov.getTelefonocliente());
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
				clientes.setIdClientes(rs.getInt("idclientes"));
				clientes.setNombrecliente(rs.getString("nombre"));
				clientes.setEmailcliente(rs.getString("email"));
				clientes.setDireccioncliente(rs.getString("direccion"));
				clientes.setTelefonocliente(rs.getInt("telefono"));
				lista.add(clientes);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public boolean eliminarclientes(int idclientes) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("DELETE FROM clientes WHERE idclientes=?");
			ps.setInt(1, idclientes);
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
		ps = cx.conectar().prepareStatement("UPDATE clientes SET nombre=?,email=?,direccion=?,telefono=? WHERE idclientes=?");
		ps.setString(1, clien.getNombrecliente());
		ps.setString(2, clien.getEmailcliente());
		ps.setString(3, clien.getDireccioncliente());
		ps.setInt(4, clien.getTelefonocliente());
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

