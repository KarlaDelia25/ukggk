package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.conexion;
import Modelo.Taller;

public class daoTaller {
	conexion cx;

	public daoTaller() {
		cx = new conexion();
	}

	public boolean insertarTaller(Taller tall) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("INSERT INTO taller VALUES(null,?,?,?,?,?)");
			ps.setString(1, tall.getDetalles());
			ps.setString(2, tall.getRefacciones());
			ps.setDouble(3, tall.getCostototal());
			ps.setString(4, tall.getMecanico());
			ps.setString(5, tall.getCliente());
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

	public ArrayList<Taller> consultaTaller() {
		ArrayList<Taller> lista = new ArrayList<Taller>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = cx.conectar().prepareStatement("SELECT * FROM taller");
			rs = ps.executeQuery();
			while (rs.next()) {
				Taller taller = new Taller();
				taller.setIdtaller(rs.getInt("idtaller"));
				taller.setDetalles(rs.getString("detalles"));
				taller.setRefacciones(rs.getString("refacciones"));
				taller.setCostototal(rs.getDouble("costototal"));
				taller.setMecanico(rs.getString("mecanico"));
				taller.setCliente(rs.getString("cliente"));
			
				lista.add(taller);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public boolean eliminarTaller(int idtaller) {
		PreparedStatement ps = null;
		try {
			ps = cx.conectar().prepareStatement("DELETE FROM taller WHERE idtaller =?");
			ps.setInt(1, idtaller);
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

public boolean editarTaller(Taller tall) {
	PreparedStatement ps = null;
	try {
		ps = cx.conectar().prepareStatement("UPDATE taller  SET detalles=?,refacciones=?,costototal=?,mecanico=?,cliente=? WHERE idtaller=?");
		ps.setString(1, tall.getDetalles());
		ps.setString(2, tall.getRefacciones());
		ps.setDouble(3, tall.getCostototal());
		ps.setString(4, tall.getMecanico());
		ps.setString(5, tall.getCliente());
		ps.setInt(6, tall.getIdtaller());
		ps.executeUpdate();
		cx.desconectar();
		return true;
	} catch (SQLException e) {

		e.printStackTrace();

		return false;
	}

}
}