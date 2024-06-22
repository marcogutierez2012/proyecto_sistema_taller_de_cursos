package Dao.Proyecto;

import java.util.List;

import Modelo.Proyecto.ClaseDocente;
import Modelo.Proyecto.ClaseEstudiante;

public class TestEstudianteImp {

	public static void main(String[] args) {

		ClaseEstudiante clsEst=new ClaseEstudiante();
		
		EstudianteImp estimp=new EstudianteImp();
		
		/*clsEst.setDni("75899124");
		clsEst.setNombre("Luis");
		clsEst.setApellido("Gonzales");
		clsEst.setCorreo("luisgonzales@gmail.com");
		clsEst.setTelefono("998512457");
		estimp.RegistrarEstudiante(clsEst);*/
		
		
		/*clsEst.setIdestudiante("E000000002");
		clsEst.setDni("7894554");
		clsEst.setNombre("Luis Aurelio");
		clsEst.setApellido("Gonzales Quispe");
		clsEst.setCorreo("luisgonzales15@gmail.com");
		clsEst.setTelefono("998512456");
		estimp.ActualizarEstudiante(clsEst);*/
		
		/*clsEst.setIdestudiante("E000000002");
		estimp.EliminarEstudiante(clsEst);*/
		
		/*List<ClaseEstudiante> listado=estimp.ListarEstudianteGeneral();
		for(ClaseEstudiante listar:listado){
			System.out.println("Codigo: "+listar.getIdestudiante()+" Dni: "+listar.getDni()+" Nombre: "+listar.getNombre()
			+" Apellido: "+listar.getApellido()+" Correo: "+listar.getCorreo()+" Telefono: "+listar.getTelefono()+" Asignado: "+listar.getEstado());
		}*/
			
		clsEst.setDni("78");
		ClaseEstudiante listar=estimp.BuscarEstudiante(clsEst);
		System.out.println("Codigo: "+listar.getIdestudiante()+" Dni: "+listar.getDni()+" Nombre: "+listar.getNombre()
		+" Apellido: "+listar.getApellido()+" Correo: "+listar.getCorreo()+" Telefono: "+listar.getTelefono()+" Asignado: "+listar.getEstado());

	}

}
