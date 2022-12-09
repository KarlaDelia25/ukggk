package Dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import Conexion.conexion;
import Conexion.conexion;
import Modelo.Entradas;
import Modelo.Usuario;

public class daoEntradas {
	conexion cx = null;

	public daoEntradas() {
		cx = new conexion();

	}

	public boolean insertarEntradas(Entradas en) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("INSERT INTO entradas VALUES(null,?,?)");
			ps.setDouble(1, en.getCantidad());
			ps.setString(2, en.getFecha());
			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}

	}

	public ArrayList<Entradas> fetchEntradas() {
		ArrayList<Entradas> lista = new ArrayList<Entradas>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = cx.conectar().prepareStatement("SELECT * FROM entradas");
			rs = ps.executeQuery();
			while (rs.next()) {
				Entradas u = new Entradas();
				u.setIdentradas(rs.getInt("identradas"));
				u.setCantidad(rs.getDouble("cantidad"));
				u.setFecha(rs.getString("fecha"));
				lista.add(u);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public boolean eliminarEntradas(int Identrada) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("DELETE FROM entradas WHERE identradas=?");
			ps.setInt(1, Identrada);
			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}
	}

	public boolean editarEntrada(Entradas en) {
		PreparedStatement ps = null;
		try {

			ps = cx.conectar().prepareStatement("UPDATE entradasSET cantidad=?,fecha=? WHERE identradas=?");
			ps.setDouble(1, en.getCantidad());
			ps.setString(2, en.getFecha());
			ps.setInt(3, en.getIdentradas());
			ps.executeUpdate();
			cx.desconectar();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}
	}
}

	