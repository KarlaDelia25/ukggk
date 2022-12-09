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

	public boolean insertarClientes(Clientes cl) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("INSERT INTO empleados VALUES(null,?,?,?,?,?)");
			ps.setString(1, cl.getNombrecliente());
			ps.setString(2, cl.getEmailcliente());
			ps.setString(3, cl.getDireccioncliente());
			ps.setInt(4, cl.getTelefonocliente());
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

	public ArrayList<Clientes> consultacliente() {
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = cx.conectar().prepareStatement("SELECT * FROM empleados");
			rs = ps.executeQuery();
			while (rs.next()) {
				Clientes cl = new Clientes();
				cl.setIdClientes(rs.getInt("idempleados"));
				cl.setNombrecliente(rs.getString("nombre"));
				cl.setEmailcliente(rs.getString("email"));
				cl.setDireccioncliente(rs.getString("direccion"));
				cl.setTelefonocliente(rs.getInt("telefono"));
				lista.add(cl);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public boolean eliminarCliente(int id) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("DELETE FROM empleados WHERE idempleados=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

public boolean editarcliente(Clientes cl) {
	PreparedStatement ps = null;
	try {
		ps = cx.conectar().prepareStatement("UPDATE empleados SET nombre=?,email=?,direccion=?,telefono=?,rfc=? WHERE idempleados=?");
		ps.setString(1, cl.getNombrecliente());
		ps.setString(2, cl.getEmailcliente());
		ps.setString(3, cl.getDireccioncliente());
		ps.setInt(4, cl.getTelefonocliente());
		ps.setInt(5, cl.getIdClientes());
		ps.executeUpdate();
		cx.desconectar();
		return true;
	} catch (SQLException e) {

		e.printStackTrace();

		return false;
	}

}
}