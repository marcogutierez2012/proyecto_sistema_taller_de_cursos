package Modelo.Proyecto;

public class ClaseUsuario {
	private int idusuario;
	private String nomusuario;
	private String password;
	
	public ClaseUsuario() {

	}

	public ClaseUsuario(int idusuario, String nomusuario, String password) {
		this.idusuario = idusuario;
		this.nomusuario = nomusuario;
		this.password = password;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNomusuario() {
		return nomusuario;
	}

	public void setNomusuario(String nomusuario) {
		this.nomusuario = nomusuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
