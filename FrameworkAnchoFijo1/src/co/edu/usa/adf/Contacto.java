package co.edu.usa.adf;

public class Contacto{

	String nombre;
	String celular;
	String email;
	String direccion;
	Integer edad;
	long cedula;
	
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