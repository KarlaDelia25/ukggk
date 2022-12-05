package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.conexion;
import Modelo.Buscar;

public class daoBuscar {
	conexion cx;

public  daoBuscar () {
	cx = new conexion();
}

	public ArrayList<Buscar> buscar(String palabra) {
		ArrayList<Buscar> lista2 = new ArrayList<Buscar>();
		try {
			String sql = "SELECT * FROM buscar WHERE " + "(descripcion LIKE ?) OR " + "(precio LIKE ?) OR"
					+ "(precioventa LIKE ?) OR ";

			PreparedStatement ps = cx.conectar().prepareStatement(sql);
			ps.setString(1, "%" + palabra + "%");
			ps.setString(2, "%" + palabra + "%");
			ps.setString(3, "%" + palabra + "%");
			ps.setString(4, "%" + palabra + "%");
			// System.out.println("CONSULTA" + ps.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Buscar p = new Buscar();
				p.setIdproductos(rs.getInt("idproveedor"));
				p.setDescripccion(rs.getString("descripcion"));
				p.setPrecio(rs.getDouble("precio"));
				p.setPrecioventa(rs.getDouble("precioventa"));

				lista2.add(p);
			}
			ps.close();
			ps = null;
			cx.desconectar();
		} catch (SQLException ex) {
			System.out.println("Error en BUSCAR");
		}
		return lista2;

	}

}
