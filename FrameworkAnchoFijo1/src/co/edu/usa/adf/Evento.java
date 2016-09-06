package co.edu.usa.adf;

import java.util.Date;

public class Evento {

	private String nombre;
	private Date fecha;
	private String descripcion;
	
	public Evento() {
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Eventos [nombre=" + nombre + ", fecha=" + fecha + ", descripcion=" + descripcion + "]";
	}
}
