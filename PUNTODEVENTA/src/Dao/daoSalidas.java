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
import Modelo.Salidas;
import Modelo.Usuario;

public class daoSalidas {
	conexion cx = null;

	public daoSalidas() {
		cx = new conexion();

	}

	public boolean insertarSalidas(Salidas sa) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("INSERT INTO salidas VALUES(null,?,?)");
			ps.setDouble(1, sa.getCantidads());
			ps.setString(2, sa.getFechas());
			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}

	}

	public ArrayList<Salidas> fetchSalidas() {
		ArrayList<Salidas> lista = new ArrayList<Salidas>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = cx.conectar().prepareStatement("SELECT * FROM salidas");
			rs = ps.executeQuery();
			while (rs.next()) {
			 Salidas u = new Salidas();
				u.setIdsalida(rs.getInt("idsalida"));
				u.setCantidads(rs.getDouble("cantidads"));
				u.setFechas(rs.getString("fechas"));
				lista.add(u);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public boolean eliminarSalidas(int Idsalida) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("DELETE FROM salidas WHERE idsalida=?");
			ps.setInt(1, Idsalida);
			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}
	}

	public boolean editarSalida(Salidas sa) {
		PreparedStatement ps = null;
		try {

			ps = cx.conectar().prepareStatement("UPDATE salida SET cantidad=?,fecha=? WHERE idsalida=?");
			ps.setDouble(1, sa.getCantidads());
			ps.setString(2, sa.getFechas());
			ps.setInt(3, sa.getIdsalida());
			ps.executeUpdate();
			cx.desconectar();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}
	}
}
