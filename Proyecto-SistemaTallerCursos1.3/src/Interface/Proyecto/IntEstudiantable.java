package Interface.Proyecto;

import java.util.List;

import Modelo.Proyecto.ClaseEstudiante;

public interface IntEstudiantable {
	void RegistrarEstudiante(ClaseEstudiante clsEst);
	void ActualizarEstudiante(ClaseEstudiante clsEst);
	void EliminarEstudiante(ClaseEstudiante clsEst);
	ClaseEstudiante BuscarEstudiante(ClaseEstudiante clsEst);
	List<ClaseEstudiante> ListarEstudianteGeneral();
}
