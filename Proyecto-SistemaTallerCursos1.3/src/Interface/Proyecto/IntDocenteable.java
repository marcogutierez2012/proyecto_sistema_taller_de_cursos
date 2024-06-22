package Interface.Proyecto;

import java.util.List;

import Modelo.Proyecto.ClaseDocente;

public interface IntDocenteable {
	void RegistrarDocente(ClaseDocente clsDoc);
	void ActualizarDocente(ClaseDocente clsDoc);
	void EliminarDocente(ClaseDocente clsDoc);
	ClaseDocente BuscarDocente(ClaseDocente clsDoc);
	List<ClaseDocente> ListarDocenteGeneral();
}
