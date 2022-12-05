package Modelo;

public class Proveedor {

    int IdProveedor;
    String nombreProveedor;
    String nombreContacto;
    String ciudadProveedor;
    String telefonoProveedor;

    public Proveedor() {
    }

    public Proveedor(String nombreProveedor, String nombreContacto, String ciudadProveedor, String telefonoProveedor) {
        this.nombreProveedor = nombreProveedor;
        this.nombreContacto = nombreContacto;
        this.ciudadProveedor = ciudadProveedor;
        this.telefonoProveedor = telefonoProveedor;
    }

    public Proveedor(int IdProveedor, String nombreProveedor, String nombreContacto, String cuidadProveedor, String telefonoProveedor) {
        this.IdProveedor = IdProveedor;
        this.nombreProveedor = nombreProveedor;
        this.nombreContacto = nombreContacto;
        this.ciudadProveedor = cuidadProveedor;
        this.telefonoProveedor = telefonoProveedor;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getCiudadProveedor() {
        return ciudadProveedor;
    }

    public void setCiudadProveedor(String cuidadProveedor) {
        this.ciudadProveedor = cuidadProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "IdProveedor=" + IdProveedor + ", nombreProveedor=" + nombreProveedor + ", nombreContacto=" + nombreContacto + ", cuidadProveedor=" + ciudadProveedor + ", telefonoProveedor=" + telefonoProveedor + '}';
    }

    public boolean validaProveedor() {
        if (!this.nombreProveedor.equals("") && !this.nombreContacto.equals("") && !this.telefonoProveedor.equals("") && !this.ciudadProveedor.equals("")) {
            return true;
        } else {
            return false;
        }
    }

}
