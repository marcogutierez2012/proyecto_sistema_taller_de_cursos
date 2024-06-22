package Modelo.Proyecto;

public class ClaseCurso {
	private String idcurso;
	private String nomcurso;
	private String descripcion;
	private String dia;
	private String horinicio;
	private String horafin;
	private int vacantes;
	private String estado;
	
	public ClaseCurso() {
		
	}

	public ClaseCurso(String idcurso, String nomcurso, String descripcion, String dia, String horinicio, String horafin,
			int vacantes, String estado) {
		this.idcurso = idcurso;
		this.nomcurso = nomcurso;
		this.descripcion = descripcion;
		this.dia = dia;
		this.horinicio = horinicio;
		this.horafin = horafin;
		this.vacantes = vacantes;
		this.estado = estado;
	}
	
	public String getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(String idcurso) {
		this.idcurso = idcurso;
	}

	public String getNomcurso() {
		return nomcurso;
	}

	public void setNomcurso(String nomcurso) {
		this.nomcurso = nomcurso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHorinicio() {
		return horinicio;
	}

	public void setHorinicio(String horinicio) {
		this.horinicio = horinicio;
	}

	public String getHorafin() {
		return horafin;
	}

	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}

	public int getVacantes() {
		return vacantes;
	}

	public void setVacantes(int vacantes) {
		this.vacantes = vacantes;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}	
}
