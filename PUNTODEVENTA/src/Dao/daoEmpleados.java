package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.conexion;
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
			ps.setString(1, em.getNombreem());
			ps.setString(2, em.getEmailem());
			ps.setString(3, em.getDireccionem());
			ps.setInt(4, em.getTelefonoem());
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
				empleados.setIdEmpleados(rs.getInt("idempleados"));
				empleados.setNombreem(rs.getString("nombre"));
				empleados.setEmailem(rs.getString("email"));
				empleados.setDireccionem(rs.getString("direccion"));
				empleados.setTelefonoem(rs.getInt("telefono"));
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

public boolean editarempleados(Empleados em) {
	PreparedStatement ps = null;
	try {
		ps = cx.conectar().prepareStatement("UPDATE empleados SET nombre=?,email=?,direccion=?,telefono=?,rfc=? WHERE idempleados=?");
		ps.setString(1, em.getNombreem());
		ps.setString(2, em.getEmailem());
		ps.setString(3, em.getDireccionem());
		ps.setInt(4, em.getTelefonoem());
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
