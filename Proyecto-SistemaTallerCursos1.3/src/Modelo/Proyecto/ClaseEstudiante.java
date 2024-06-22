package Modelo.Proyecto;

public class ClaseEstudiante {
	private String idestudiante;
	private String dni;
	private String nombre;
	private String apellido;
	private String correo;
	private String telefono;
	private String estado;
	
	public ClaseEstudiante() {

	}

	public ClaseEstudiante(String idestudiante, String dni, String nombre, String apellido, String correo,
			String telefono, String estado) {
		this.idestudiante = idestudiante;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
		this.estado = estado;
	}

	public String getIdestudiante() {
		return idestudiante;
	}

	public void setIdestudiante(String idestudiante) {
		this.idestudiante = idestudiante;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
