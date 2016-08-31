package co.edu.usa.adf.fixedwidth.annotation;

@FixedWidthData(recordLength = 147)
public class Contacto{

	@FixedWidthField(position=1, width=30) String nombre;
	@FixedWidthField(position=2, width=20) String celular;
	@FixedWidthField(position=3, width=30) String email;
	@FixedWidthField(position=4, width=50) String direccion;
	@FixedWidthField(position=5, width=3 ) Integer edad;
	@FixedWidthField(position=6, width=15) long cedula;
	
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