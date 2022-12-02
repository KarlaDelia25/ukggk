package Modelo;


public class Refacciones {
	int id;
	String descripccion;
	Double precioventa;
	Double precio;
	String img;
	public Refacciones() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripccion() {
		return descripccion;
	}
	public void setDescripccion(String descripccion) {
		this.descripccion = descripccion;
	}
	public Double getPrecioventa() {
		return precioventa;
	}
	public void setPrecioventa(Double precioventa) {
		this.precioventa = precioventa;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
}
