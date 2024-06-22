package Interface.Proyecto;

import java.util.List;

import Modelo.Proyecto.ClaseCurso;

public interface IntCurseable {
	void RegistrarCurso(ClaseCurso clsCur);
	void ActualizarCurso(ClaseCurso clsCur);
	void EliminarCurso(ClaseCurso clsCur);
	ClaseCurso BuscarCurso(ClaseCurso clsCur);
	ClaseCurso BuscarCursoID(ClaseCurso clsCur);
	List<ClaseCurso> ListarCursoGeneral();
}
