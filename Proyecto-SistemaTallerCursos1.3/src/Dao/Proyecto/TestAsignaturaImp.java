package Dao.Proyecto;

import java.util.List;

import Modelo.Proyecto.ClaseCursoDocente;

public class TestAsignaturaImp {

	public static void main(String[] args) {
		ClaseCursoDocente clscurdoc=new ClaseCursoDocente();
		AsignaturaImp asimp=new AsignaturaImp();
		
		clscurdoc.setIddocente("D006");
		clscurdoc.setIdcurso("C010");
		asimp.AsignarCursoDocente(clscurdoc);
		
		/*List<ClaseCursoDocente> listado=asimp.ListarCursoAsignado();
		for(ClaseCursoDocente listar:listado){
			System.out.println("Dni: "+listar.getDnidocente()+" Nombre: "+listar.getNomdocente()
			+" Curso: "+listar.getNomcurso()+" Dia: "+listar.getDiacurso()+" Hora de inicio: "+listar.getHorinicurso()+
			" Hora de fin: "+listar.getHorfincurso());
		}*/
		
	}

}
