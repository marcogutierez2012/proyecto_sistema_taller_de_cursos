package Dao.Proyecto;

import java.util.List;

import Modelo.Proyecto.ClaseCurso;

public class TestCursoImp {

	public static void main(String[] args) {
		
		ClaseCurso clscur=new ClaseCurso();
		
		CursoImp curimp=new CursoImp();
		
		/*clscur.setNomcurso("Manualidades");
		clscur.setDescripcion("Creacion de artes manuales");
		clscur.setHorinicio("10:00");
		clscur.setHorafin("12:00");
		clscur.setVacantes(20);
		curimp.RegistrarCurso(clscur);*/
		
		/*clscur.setNomcurso("Manualidades");
		clscur.setDescripcion("Creacion de artes manuales y origami");
		clscur.setHorinicio("09:00");
		clscur.setHorafin("11:00");
		clscur.setVacantes(20);
		curimp.ActualizarCurso(clscur);*/
		
		clscur.setIdcurso("C012");
		curimp.EliminarCurso(clscur);
		
		/*List<ClaseCurso> listado=curimp.ListarCursoGeneral();
		for(ClaseCurso listar:listado){
			System.out.println("Codigo: "+listar.getIdcurso()+" Nombre: "+listar.getNomcurso()
			+" Descripcion: "+listar.getDescripcion()+" Dia: "+listar.getDia()+" Hora de inicio: "+listar.getHorinicio()+" Hora de fin: "+listar.getHorafin()
			+" Vacantes: "+listar.getVacantes()+" Asignado: "+listar.getEstado());
		}*/
			
		/*clscur.setNomcurso("mat");
		ClaseCurso busqueda=curimp.BuscarCurso(clscur);
			System.out.println("Codigo: "+busqueda.getIdcurso()+" Nombre: "+busqueda.getNomcurso()
			+" Descripcion: "+busqueda.getDescripcion()+" Dia: "+busqueda.getDia()+" Hora de inicio: "+busqueda.getHorinicio()+" Hora de fin: "+busqueda.getHorafin()
			+" Vacantes: "+busqueda.getVacantes()+" Asignado: "+busqueda.getEstado());*/
		

	}

}
