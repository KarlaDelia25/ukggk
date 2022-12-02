package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.conexion;
import Modelo.Clientes;
import Modelo.Empleados;



public class daoEmpleados {
	conexion cx;

	public daoEmpleados() {
		cx = new conexion();
	}

	public boolean insertarEmpleado(Empleados em) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("INSERT INTO empleados VALUES(null,?,?,?,?,?)");
			ps.setString(1, em.getNombre());
			ps.setString(2, em.getEmail());
			ps.setString(3, em.getDireccion());
			ps.setInt(4, em.getTelefono());
			ps.setInt(5, em.getRfc());
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

	public ArrayList<Empleados> consultaempleados() {
		ArrayList<Empleados> lista = new ArrayList<Empleados>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = cx.conectar().prepareStatement("SELECT * FROM empleados");
			rs = ps.executeQuery();
			while (rs.next()) {
				Empleados empleados = new Empleados();
				empleados.setIdEmpleados(rs.getInt("id"));
				empleados.setNombre(rs.getString("nombre"));
				empleados.setEmail(rs.getString("email"));
				empleados.setDireccion(rs.getString("direccion"));
				empleados.setTelefono(rs.getInt("telefono"));
				empleados.setRfc(rs.getInt("rfc"));
				lista.add(empleados);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public boolean eliminarEmpleados(int id) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("DELETE FROM empleados WHERE id =?");
			ps.setInt(1, id);
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

public boolean editarempleados(Empleados em) {
	PreparedStatement ps = null;
	try {
		ps = cx.conectar().prepareStatement("UPDATE empleados SET nombre=?,email=?,direccion=?,telefono=?,rfc=? WHERE id=?");
		ps.setString(1, em.getNombre());
		ps.setString(2, em.getEmail());
		ps.setString(3, em.getDireccion());
		ps.setInt(4, em.getTelefono());
		ps.setInt(5, em.getRfc());
		ps.setInt(6, em.getIdEmpleados());
		ps.executeUpdate();
		cx.desconectar();
		return true;
	} catch (SQLException e) {

		e.printStackTrace();

		return false;
	}

}
}
