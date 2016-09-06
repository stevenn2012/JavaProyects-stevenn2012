package co.edu.usa.adf;

import Fanfid.FixedWidthField;

public class Contacto{

	@FixedWidthField(width=30) String nombre;
	@FixedWidthField(width=20) String celular;
	@FixedWidthField(width=30) String email;
	@FixedWidthField(width=50) String direccion;
	@FixedWidthField(width= 3) Integer edad;
	@FixedWidthField(width=15) long cedula;
	
	public Contacto() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", celular=" + celular
				+ ", email=" + email + ", direccion=" + direccion + ", edad="
				+ edad + ", cedula=" + cedula + "]";
	}
}
