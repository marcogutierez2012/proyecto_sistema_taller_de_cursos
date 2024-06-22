package Modelo.Proyecto;

import java.util.Date;

public class ClaseInscripcion {
	private int nroinscrip;
	private String idestudiante;
	private String idcurso;
	private Date fechainscrip;
	private String dniestudiante;
	private String estudiante;
	private String curso;
	private String diacurso;
	private String horinicurso;
	private String horfincurso;
	
	public ClaseInscripcion() {

	}

	public ClaseInscripcion(int nroinscrip, String idestudiante, String idcurso, Date fechainscrip,
			String dniestudiante, String estudiante, String curso, String diacurso, String horinicurso,
			String horfincurso) {
		this.nroinscrip = nroinscrip;
		this.idestudiante = idestudiante;
		this.idcurso = idcurso;
		this.fechainscrip = fechainscrip;
		this.dniestudiante = dniestudiante;
		this.estudiante = estudiante;
		this.curso = curso;
		this.diacurso = diacurso;
		this.horinicurso = horinicurso;
		this.horfincurso = horfincurso;
	}

	public int getNroinscrip() {
		return nroinscrip;
	}

	public void setNroinscrip(int nroinscrip) {
		this.nroinscrip = nroinscrip;
	}

	public String getIdestudiante() {
		return idestudiante;
	}

	public void setIdestudiante(String idestudiante) {
		this.idestudiante = idestudiante;
	}

	public String getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(String idcurso) {
		this.idcurso = idcurso;
	}

	public Date getFechainscrip() {
		return fechainscrip;
	}

	public void setFechainscrip(Date fechainscrip) {
		this.fechainscrip = fechainscrip;
	}

	public String getDniestudiante() {
		return dniestudiante;
	}

	public void setDniestudiante(String dniestudiante) {
		this.dniestudiante = dniestudiante;
	}

	public String getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
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
