package Dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.conexion;
import Modelo.Refacciones;
import Modelo.Ventas;

public class daoVentas {
	conexion cx;

	public daoVentas() {
		cx = new conexion();
	}

	
	 public ArrayList<Refacciones> read() {
	        ArrayList<Refacciones> lista = new ArrayList<Refacciones>();
	        try {
	            String sql = "SELECT * FROM refacciones";
	            PreparedStatement ps = cx.conectar().prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Refacciones a = new Refacciones();
	                a.setIdrefaccion(rs.getInt("idrefaccion"));
	                a.setDescripcion(rs.getString("descripcion"));
	                a.setPrecio(rs.getDouble("precio"));
	                a.setPrecioventa(rs.getDouble("precioventa"));
	                a.setMarca(rs.getString("marca"));
	                lista.add(a);
	            }
	            ps.close();
	            ps = null;
	            cx.desconectar();
	        } catch (SQLException ex) {
	            System.out.println("Fallo metodo read categoria");
	        }
	        return lista;
	    }

	    public Refacciones readn(int idrefaccion) {
	        Refacciones a = new Refacciones();
	        try {
	            String sql = "SELECT * FROM refacciones WHERE idrefaccion=?";
	            PreparedStatement ps = cx.conectar().prepareStatement(sql);
	            ps.setInt(1, idrefaccion);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                a.setIdrefaccion(rs.getInt("idrefaccion"));
	                a.setMarca(rs.getString("descripcion"));
	                a.setPrecio(rs.getDouble("precio"));
	                a.setPrecioventa(rs.getDouble("precioventa"));
	                a.setMarca(rs.getString("marca"));
	            }
	            ps.close();
	            ps = null;
	            cx.desconectar();
	        } catch (SQLException ex) {
	            System.out.println("Fallo metodo read categoria");
	        }
	        return a;
	    }

	 
	    public boolean delete(int idrefaccion) {
	        try {
	            String sql = "DELETE FROM refacciones WHERE idrefaccion=?";
	            PreparedStatement ps = cx.conectar().prepareStatement(sql);
	            ps.setInt(1, idrefaccion);
	            ps.execute();
	            ps.close();
	            ps = null;
	            cx.desconectar();
	            return true;
	        } catch (SQLException ex) {
	            return false;
	        }
	    }

	}



