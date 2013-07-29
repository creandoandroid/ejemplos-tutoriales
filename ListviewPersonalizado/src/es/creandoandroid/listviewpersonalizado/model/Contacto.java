package es.creandoandroid.listviewpersonalizado.model;

public class Contacto {

	int imagen;
	String nombre;

	public Contacto(int imagen, String nombre) {
		super();
		this.imagen = imagen;
		this.nombre = nombre;
	}

	public int getImagen() {
		return imagen;
	}

	public void setImagen(int imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



}
