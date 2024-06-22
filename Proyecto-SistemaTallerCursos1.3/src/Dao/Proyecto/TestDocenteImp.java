package Dao.Proyecto;

import java.util.List;

import Modelo.Proyecto.ClaseCurso;
import Modelo.Proyecto.ClaseDocente;

public class TestDocenteImp {

	public static void main(String[] args) {
		
		ClaseDocente clsDoc=new ClaseDocente();
		
		DocenteImp docimp=new DocenteImp();
		
		/*clsDoc.setDni("45788745");
		clsDoc.setNombre("Juan");
		clsDoc.setApellido("Martinez");
		clsDoc.setCorreo("juanmartinez@gmail.com");
		clsDoc.setTelefono("956478214");
		docimp.RegistrarDocente(clsDoc);*/
		
		
		/*clsDoc.setIddocente("D003");
		clsDoc.setDni("45788745");
		clsDoc.setNombre("Juan Miguel");
		clsDoc.setApellido("Martinez Ramirez");
		clsDoc.setCorreo("juanmartinez40@gmail.com");
		clsDoc.setTelefono("956478214");
		docimp.ActualizarDocente(clsDoc);*/
		
		clsDoc.setIddocente("D003");
		docimp.EliminarDocente(clsDoc);
		
		/*List<ClaseDocente> listado=docimp.ListarDocenteGeneral();
		for(ClaseDocente listar:listado){
			System.out.println("Codigo: "+listar.getIddocente()+"Dni: "+listar.getDni()+" Nombre: "+listar.getNombre()
			+" Apellido: "+listar.getApellido()+" Correo: "+listar.getCorreo()+" Telefono: "+listar.getTelefono()+" Asignado: "+listar.getEstadodocente());
		}*/
		
		/*clsDoc.setDni("7487");
		ClaseDocente listar=docimp.BuscarDocente(clsDoc);
		System.out.println("Codigo: "+listar.getIddocente()+"Dni: "+listar.getDni()+" Nombre: "+listar.getNombre()
		+" Apellido: "+listar.getApellido()+" Correo: "+listar.getCorreo()+" Telefono: "+listar.getTelefono()+" Asignado: "+listar.getEstadodocente());*/
		
	}

}
