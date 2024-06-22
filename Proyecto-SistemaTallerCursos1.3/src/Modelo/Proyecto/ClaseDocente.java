package Modelo.Proyecto;

public class ClaseDocente {
	private String iddocente;
	private String dni;
	private String nombre;
	private String apellido;
	private String correo;
	private String telefono;
	private String estadodocente;
	
	public ClaseDocente() {

	}

	public ClaseDocente(String iddocente, String dni, String nombre, String apellido, String correo, String telefono,
			String estadodocente) {
		this.iddocente = iddocente;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
		this.estadodocente = estadodocente;
	}

	public String getIddocente() {
		return iddocente;
	}

	public void setIddocente(String iddocente) {
		this.iddocente = iddocente;
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

	public String getEstadodocente() {
		return estadodocente;
	}

	public void setEstadodocente(String estadodocente) {
		this.estadodocente = estadodocente;
	}
}
