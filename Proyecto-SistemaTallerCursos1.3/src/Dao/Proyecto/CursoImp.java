package Dao.Proyecto;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conectar.Proyecto.ConexionBD;
import Interface.Proyecto.IntCurseable;
import Modelo.Proyecto.ClaseCurso;

public class CursoImp implements IntCurseable {

	@Override
	public void RegistrarCurso(ClaseCurso clsCur) {
		
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_registrar_curso(?,?,?,?,?,?)}";
		CallableStatement cs=null;
		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, clsCur.getNomcurso());
			cs.setString(2, clsCur.getDescripcion());
			cs.setString(3, clsCur.getDia());
			cs.setString(4, clsCur.getHorinicio());
			cs.setString(5, clsCur.getHorafin());
			cs.setInt(6, clsCur.getVacantes());

			int x=cs.executeUpdate();
			
			if(x>0){
				System.out.println("Curso Registrado correctamente");
			} else {
				System.out.println("Error al Registrar Curso");
			}		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void ActualizarCurso(ClaseCurso clsCur) {
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_actualizar_curso(?,?,?,?,?,?,?)}";
		CallableStatement cs=null;
		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, clsCur.getIdcurso());
			cs.setString(2, clsCur.getNomcurso());
			cs.setString(3, clsCur.getDescripcion());
			cs.setString(4, clsCur.getDia());
			cs.setString(5, clsCur.getHorinicio());
			cs.setString(6, clsCur.getHorafin());
			cs.setInt(7, clsCur.getVacantes());

			int x=cs.executeUpdate();
			
			if(x>0){
				System.out.println("Curso Actualizado correctamente");
			} else {
				System.out.println("Error al Actualizar Curso");
			}		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void EliminarCurso(ClaseCurso clsCur) {
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_eliminar_curso(?)}";
		CallableStatement cs=null;
		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, clsCur.getIdcurso());
			
			int x=cs.executeUpdate();
			
			if(x>0){
				System.out.println("Curso Eliminado correctamente");
			} else {
				System.out.println("Error al Eliminar Curso");
			}		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public ClaseCurso BuscarCurso(ClaseCurso clsCur) {
		
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_buscar_curso(?)}";
		
		CallableStatement cs=null;
		ResultSet rs=null;
		ClaseCurso almcur= new ClaseCurso();
		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, clsCur.getNomcurso());

			rs=cs.executeQuery();

			while(rs.next()){
				almcur.setIdcurso(rs.getString(1));
				almcur.setNomcurso(rs.getString(2));
				almcur.setDescripcion(rs.getString(3));
				almcur.setDia(rs.getString(4));
				almcur.setHorinicio(rs.getString(5));
				almcur.setHorafin(rs.getString(6));
				almcur.setVacantes(rs.getInt(7));
				almcur.setEstado(rs.getString(8));						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return almcur;
	}

	@Override
	public List<ClaseCurso> ListarCursoGeneral() {

		ConexionBD cone=new ConexionBD();
		String sql="{call sp_listar_curso_general()}";
		
		CallableStatement cs=null;
		ResultSet rs=null;
		List<ClaseCurso> lista=new ArrayList<ClaseCurso>();

		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			rs=cs.executeQuery();

			while(rs.next()){

				ClaseCurso clcur=new ClaseCurso();
				clcur.setIdcurso(rs.getString(1));
				clcur.setNomcurso(rs.getString(2));
				clcur.setDescripcion(rs.getString(3));
				clcur.setDia(rs.getString(4));
				clcur.setHorinicio(rs.getString(5));
				clcur.setHorafin(rs.getString(6));
				clcur.setVacantes(rs.getInt(7));
				clcur.setEstado(rs.getString(8));
				lista.add(clcur);
						
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public ClaseCurso BuscarCursoID(ClaseCurso clsCur) {
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_buscar_cursoid(?)}";
		
		CallableStatement cs=null;
		ResultSet rs=null;
		ClaseCurso almcur= new ClaseCurso();
		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, clsCur.getIdcurso());

			rs=cs.executeQuery();

			while(rs.next()){
				almcur.setIdcurso(rs.getString(1));
				almcur.setNomcurso(rs.getString(2));
				almcur.setDescripcion(rs.getString(3));
				almcur.setDia(rs.getString(4));
				almcur.setHorinicio(rs.getString(5));
				almcur.setHorafin(rs.getString(6));
				almcur.setVacantes(rs.getInt(7));
				almcur.setEstado(rs.getString(8));						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return almcur;
	}

}
