package Interface.Proyecto;

import java.util.List;

import Modelo.Proyecto.ClaseInscripcion;

public interface IntInscripcionable {
	void GenerarInscripcion(ClaseInscripcion ClsIns);
	List<ClaseInscripcion> ListarInscripcion();
	ClaseInscripcion BuscarInscripcion(ClaseInscripcion clsIns);
	void EliminarInscripcion(ClaseInscripcion ClsIns);
}
