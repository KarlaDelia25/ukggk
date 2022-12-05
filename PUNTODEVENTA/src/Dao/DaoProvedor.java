package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.conexion;
import Modelo.Proveedor;



public class DaoProvedor {

    public conexion cx;

    public DaoProvedor() {
        cx = new conexion();
    }

	public ArrayList<Proveedor> buscar(String palabra) {
        ArrayList<Proveedor> lista2 = new ArrayList<Proveedor>();
        try {
            String sql = "SELECT * FROM proveedor WHERE "
                    + "(nombre_proveedor LIKE ?) OR "
                    + "(nombre_contacto LIKE ?) OR"
                    + "(telefono_proveedor LIKE ?) OR "
                    + "(ciudad_proveedor LIKE ?); ";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, "%" + palabra + "%");
            ps.setString(2, "%" + palabra + "%");
            ps.setString(3, "%" + palabra + "%");
            ps.setString(4, "%" + palabra + "%");
            //System.out.println("CONSULTA" + ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setIdProveedor(rs.getInt("idproveedor"));
                p.setNombreProveedor(rs.getString("nombre_proveedor"));
                p.setNombreContacto(rs.getString("nombre_contacto"));
                p.setTelefonoProveedor(rs.getString("telefono_proveedor"));
                p.setCiudadProveedor(rs.getString("ciudad_proveedor"));
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

    public boolean create(Proveedor p) {
        try {
            String sql = "INSERT INTO proveedor(nombre_proveedor,nombre_contacto, telefono_proveedor, ciudad_proveedor) VALUES(?,?,?,?)";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, p.getNombreProveedor());
            ps.setString(2, p.getNombreContacto());
            ps.setString(3, p.getTelefonoProveedor());
            ps.setString(4, p.getCiudadProveedor());
           // System.out.println("" + ps.toString());
            ps.execute();
            ps.close();
            ps = null;
            cx.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al insertar");
            return false;
        }

    }

    public ArrayList<Proveedor> read() {
        ArrayList<Proveedor> lista2 = new ArrayList<Proveedor>();
        try {

            String sql = "SELECT * FROM Proveedor";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setIdProveedor(rs.getInt("idproveedor"));
                p.setNombreProveedor(rs.getString("nombre_proveedor"));
                p.setNombreContacto(rs.getString("nombre_contacto"));
                p.setTelefonoProveedor(rs.getString("telefono_proveedor"));
                p.setCiudadProveedor(rs.getString("ciudad_proveedor"));
                lista2.add(p);
            }
            ps.close();
            ps = null;
            cx.desconectar();
        } catch (SQLException ex) {
            System.out.println("Fallo metodo read");
        }
        return lista2;

    }

    public boolean delete(int id) {
        try {
            String sql = "DELETE FROM proveedor WHERE idproveedor=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            ps = null;
            cx.desconectar();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean update(Proveedor p) {
        try {
            String sql = "UPDATE  proveedor SET nombre_proveedor=?,nombre_contacto=?,telefono_proveedor=?, ciudad_proveedor=? WHERE idproveedor=? ";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, p.getNombreProveedor());
            ps.setString(2, p.getNombreContacto());
            ps.setString(3, p.getTelefonoProveedor());
            ps.setString(4, p.getCiudadProveedor());
            ps.setInt(5, p.getIdProveedor());
            ps.execute();
            ps.close();
            ps = null;
            cx.desconectar();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public Proveedor read(int id) {
        Proveedor p = new Proveedor();
        try {

            String sql = "SELECT * FROM proveedor WHERE idproveedor=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setIdProveedor(rs.getInt("idproveedor"));
                p.setNombreProveedor(rs.getString("nombre_proveedor"));
                p.setNombreContacto(rs.getString("nombre_contacto"));
                p.setTelefonoProveedor(rs.getString("telefono_proveedor"));
                p.setCiudadProveedor(rs.getString("ciudad_proveedor"));
            }
            ps.close();
            ps = null;
            cx.desconectar();
        } catch (SQLException ex) {
            System.out.println("Fallo metodo read Proveedor");
        }
        return p;

    }
}
