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
			ps.setString(1, prov.getNombreprov());
			ps.setString(2, prov.getEmailprov());
			ps.setString(3, prov.getDireccionprov());
			ps.setInt(4, prov.getTelefonoprov());
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
				proveedores.setIdproveedores(rs.getInt("idproveedores"));
				proveedores.setNombreprov(rs.getString("nombre"));
				proveedores.setEmailprov(rs.getString("email"));
				proveedores.setDireccionprov(rs.getString("direccion"));
				proveedores.setTelefonoprov(rs.getInt("telefono"));
				lista.add(proveedores);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public boolean eliminarProveedores(int idprov) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("DELETE FROM proveedores WHERE idproveedores =?");
			ps.setInt(1, idprov);
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
		ps = cx.conectar().prepareStatement("UPDATE proveedores  SET nombre=?,email=?,direccion=?,telefono=? WHERE idproveedores?");
		ps.setString(1, prov.getNombreprov());
		ps.setString(2, prov.getEmailprov());
		ps.setString(3, prov.getDireccionprov());
		ps.setInt(4, prov.getTelefonoprov());
		ps.setInt(5, prov.getIdproveedores());
		ps.executeUpdate();
		cx.desconectar();
		return true;
	} catch (SQLException e) {

		e.printStackTrace();

		return false;
	}

}
}


