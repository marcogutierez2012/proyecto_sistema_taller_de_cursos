package Interface.Proyecto;

import java.util.List;

import Modelo.Proyecto.ClaseCursoDocente;


public interface IntAsignable {
	void AsignarCursoDocente(ClaseCursoDocente ClsAsig);
	List<ClaseCursoDocente> ListarCursoAsignado();
	void QuitarAsignatura(ClaseCursoDocente ClsAsig);
}
