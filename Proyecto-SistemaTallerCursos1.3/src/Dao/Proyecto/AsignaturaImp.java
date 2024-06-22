package Dao.Proyecto;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Conectar.Proyecto.ConexionBD;
import Interface.Proyecto.IntAsignable;
import Modelo.Proyecto.ClaseCursoDocente;

public class AsignaturaImp implements IntAsignable{

	@Override
	public void AsignarCursoDocente(ClaseCursoDocente ClsAsig) {
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_asignar_docente_curso(?,?)}";
		CallableStatement cs=null;
		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, ClsAsig.getIddocente());
			cs.setString(2, ClsAsig.getIdcurso());

			int x=cs.executeUpdate();
			
			if(x>0){
				System.out.println("Curso Asignado correctamente");
			} else {
				System.out.println("Error al Asignar Curso");
			}		
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {		
                JOptionPane.showMessageDialog(null, "El docente ya ha sido asignado al curso");
            } else {
                System.out.println("Error al insertar el registro: " + e.getMessage());
            }
		}	
	}

	@Override
	public List<ClaseCursoDocente> ListarCursoAsignado() {
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_listar_docente_curso_asignado()}";
		
		CallableStatement cs=null;
		ResultSet rs=null;
		List<ClaseCursoDocente> lista=new ArrayList<ClaseCursoDocente>();

		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			rs=cs.executeQuery();

			while(rs.next()){

				ClaseCursoDocente clasig=new ClaseCursoDocente();
				clasig.setIddocente(rs.getString(1));
				clasig.setDnidocente(rs.getString(2));
				clasig.setNomdocente(rs.getString(3));
				clasig.setIdcurso(rs.getString(4));
				clasig.setNomcurso(rs.getString(5));
				clasig.setDiacurso(rs.getString(6));
				clasig.setHorinicurso(rs.getString(7));
				clasig.setHorfincurso(rs.getString(8));
				lista.add(clasig);
						
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void QuitarAsignatura(ClaseCursoDocente ClsAsig) {
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_liberar_cursos(?,?)}";
		CallableStatement cs=null;
		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, ClsAsig.getIddocente());
			cs.setString(2, ClsAsig.getIdcurso());

			int y=cs.executeUpdate();
			
			if(y>0){
				System.out.println("Curso Desasignado correctamente");
			} else {
				System.out.println("Error al Desasignar Curso");
			}		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}

	

}
