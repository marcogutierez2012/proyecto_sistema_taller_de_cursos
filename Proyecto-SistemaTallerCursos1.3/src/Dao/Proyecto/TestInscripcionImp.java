package Dao.Proyecto;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.Proyecto.ClaseCurso;
import Modelo.Proyecto.ClaseInscripcion;

public class TestInscripcionImp {

	public static void main(String[] args) {
		ClaseInscripcion clsinsc=new ClaseInscripcion();
		InscripcionImp inscimp=new InscripcionImp();
		ClaseCurso clscur=new ClaseCurso();
		CursoImp curimp=new CursoImp();
				
		clscur.setIdcurso("C001");
		ClaseCurso busqueda = curimp.BuscarCurso(clscur);
	
		clsinsc.setIdestudiante("E000000002");
		clsinsc.setIdcurso("C001");
		Date fecins=new Date();
		Date fechains=new Date(fecins.getTime());
		clsinsc.setFechainscrip(fechains);
		
		if(busqueda.getIdcurso().equals(clsinsc.getIdcurso()) && busqueda.getVacantes()>0){
			inscimp.GenerarInscripcion(clsinsc);
		}else{
			JOptionPane.showMessageDialog(null, "Ya no quedan vacantes");
		}
			
		/*List<ClaseInscripcion> listado=inscimp.ListarInscripcion();
		for(ClaseInscripcion listar:listado){
			System.out.println("Nro. Inscripcion: "+listar.getNroinscrip()+" Dni: "+listar.getDniestudiante()
			+" Estudiante: "+listar.getEstudiante()+" Curso: "+listar.getCurso()+" Dia: "+listar.getDiacurso()
			+" Hora de Inicio: "+listar.getHorinicurso()+" Hora de Fin: "+listar.getHorfincurso()
			+" Fecha de inscripcion: "+listar.getFechainscrip());
		}*/
		
		/*clsinsc.setDniestudiante("45");
		ClaseInscripcion listar = inscimp.BuscarInscripcion(clsinsc);
			System.out.println("Nro. Inscripcion: "+listar.getNroinscrip()+" Dni: "+listar.getDniestudiante()
			+" Estudiante: "+listar.getEstudiante()+" Curso: "+listar.getCurso()+" Dia: "+listar.getDiacurso()
			+" Hora de Inicio: "+listar.getHorinicurso()+" Hora de Fin: "+listar.getHorfincurso()
			+" Fecha de inscripcion: "+listar.getFechainscrip());*/

	}

}
