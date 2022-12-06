package Dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Conexion.conexion;
import Modelo.Refacciones;


public class daoRefacciones {

    conexion cx = new conexion();

    public daoRefacciones() {

    }

    public boolean create(Refacciones a) {
        try {
            String sql = "INSERT INTO refacciones (idrefacciones,descripcion,precio,precioventa,marca,imagen) VALUES(null,?,?,?,?,?)";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, a.getDescripcion());
            ps.setDouble(2, a.getPrecio());
            ps.setDouble(3, a.getPrecioventa());
            ps.setString(4, a.getMarca());
            ps.setString(5, a.getImagen());
            ps.execute();
            ps.close();
            ps = null;
            cx.desconectar();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(daoRefacciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

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
                a.setImagen(rs.getString("imagen"));
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

    public Refacciones read(int idauto) {
        Refacciones a = new Refacciones();
        try {
            String sql = "SELECT * FROM refacciones WHERE idrefaccion=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, idauto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                a.setIdrefaccion(rs.getInt("idauto"));
                a.setDescripcion(rs.getString("marca"));
                a.setPrecio(rs.getDouble("precio"));
                a.setPrecioventa(rs.getDouble("precioventa"));
                a.setMarca(rs.getString("marca"));
                a.setImagen(rs.getString("imagen"));
            }
            ps.close();
            ps = null;
            cx.desconectar();
        } catch (SQLException ex) {
            System.out.println("Fallo metodo read categoria");
        }
        return a;
    }

    public boolean update(Refacciones a) {
        try {
            String sql = "UPDATE refacciones SET "
                    + "descripcion=?,"
                    + "precio=?,"
                    + "precioventa=?,"
                    + "marca=?,"
                    + "imagen=?"
                    + "WHERE idauto=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, a.getDescripcion());
            ps.setDouble(2, a.getPrecio());
            ps.setDouble(3, a.getPrecioventa());
            ps.setString(4, a.getMarca());
            ps.setString(5, a.getImagen());
            ps.setInt(6, a.getIdrefaccion());
            ps.execute();
            ps.close();
            ps = null;
            cx.desconectar();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean delete(int idrefaccion) {
        try {
            String sql = "DELETE FROM auto WHERE idrefaacion=?";
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
