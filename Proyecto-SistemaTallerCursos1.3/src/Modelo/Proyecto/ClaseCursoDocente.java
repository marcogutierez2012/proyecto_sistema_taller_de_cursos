package Modelo.Proyecto;

public class ClaseCursoDocente {
	private String iddocente;
	private String idcurso;
	private String dnidocente;
	private String nomdocente;
	private String nomcurso;
	private String diacurso;
	private String horinicurso;
	private String horfincurso;
	
	public ClaseCursoDocente() {

	}

	public ClaseCursoDocente(String iddocente, String idcurso, String dnidocente, String nomdocente, String nomcurso,
			String diacurso, String horinicurso, String horfincurso) {
		this.iddocente = iddocente;
		this.idcurso = idcurso;
		this.dnidocente = dnidocente;
		this.nomdocente = nomdocente;
		this.nomcurso = nomcurso;
		this.diacurso = diacurso;
		this.horinicurso = horinicurso;
		this.horfincurso = horfincurso;
	}

	public String getIddocente() {
		return iddocente;
	}

	public void setIddocente(String iddocente) {
		this.iddocente = iddocente;
	}

	public String getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(String idcurso) {
		this.idcurso = idcurso;
	}
	
	public String getDnidocente() {
		return dnidocente;
	}

	public void setDnidocente(String dnidocente) {
		this.dnidocente = dnidocente;
	}

	public String getNomdocente() {
		return nomdocente;
	}

	public void setNomdocente(String nomdocente) {
		this.nomdocente = nomdocente;
	}

	public String getNomcurso() {
		return nomcurso;
	}

	public void setNomcurso(String nomcurso) {
		this.nomcurso = nomcurso;
	}

	public String getDiacurso() {
		return diacurso;
	}

	public void setDiacurso(String diacurso) {
		this.diacurso = diacurso;
	}

	public String getHorinicurso() {
		return horinicurso;
	}

	public void setHorinicurso(String horinicurso) {
		this.horinicurso = horinicurso;
	}

	public String getHorfincurso() {
		return horfincurso;
	}

	public void setHorfincurso(String horfincurso) {
		this.horfincurso = horfincurso;
	}	
}
