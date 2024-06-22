package Dao.Proyecto;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conectar.Proyecto.ConexionBD;
import Interface.Proyecto.IntEstudiantable;
import Modelo.Proyecto.ClaseDocente;
import Modelo.Proyecto.ClaseEstudiante;

public class EstudianteImp implements IntEstudiantable{

	@Override
	public void RegistrarEstudiante(ClaseEstudiante clsEst) {
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_registrar_estudiante(?,?,?,?,?)}";
		CallableStatement cs=null;
		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, clsEst.getDni());
			cs.setString(2, clsEst.getNombre());
			cs.setString(3, clsEst.getApellido());
			cs.setString(4, clsEst.getCorreo());
			cs.setString(5, clsEst.getTelefono());

			int x=cs.executeUpdate();
			
			if(x>0){
				System.out.println("Datos del Estudiante Registrados correctamente");
			} else {
				System.out.println("Error al Registrar los datos del Estudiante");
			}		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void ActualizarEstudiante(ClaseEstudiante clsEst) {
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_actualizar_estudiante(?,?,?,?,?,?)}";
		CallableStatement cs=null;
		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, clsEst.getIdestudiante());
			cs.setString(2, clsEst.getDni());
			cs.setString(3, clsEst.getNombre());
			cs.setString(4, clsEst.getApellido());
			cs.setString(5, clsEst.getCorreo());
			cs.setString(6, clsEst.getTelefono());

			int x=cs.executeUpdate();
			
			if(x>0){
				System.out.println("Datos del Estudiante Actualizados correctamente");
			} else {
				System.out.println("Error al Actualizar los datos del Estudiante");
			}		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void EliminarEstudiante(ClaseEstudiante clsEst) {
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_eliminar_estudiante(?)}";
		CallableStatement cs=null;
		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, clsEst.getIdestudiante());
			
			int x=cs.executeUpdate();
			
			if(x>0){
				System.out.println("Datos del Estudiante Eliminados correctamente");
			} else {
				System.out.println("Error al Eliminar Datos del Estudiante");
			}		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public ClaseEstudiante BuscarEstudiante(ClaseEstudiante clsEst) {
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_buscar_estudiante(?)}";
		
		CallableStatement cs=null;
		ResultSet rs=null;
		ClaseEstudiante almest= new ClaseEstudiante();
		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, clsEst.getIdestudiante());
			cs.setString(1, clsEst.getDni());

			rs=cs.executeQuery();

			while(rs.next()){
				almest.setIdestudiante(rs.getString(1));
				almest.setDni(rs.getString(2));
				almest.setNombre(rs.getString(3));
				almest.setApellido(rs.getString(4));
				almest.setCorreo(rs.getString(5));
				almest.setTelefono(rs.getString(6));					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return almest;
	}

	@Override
	public List<ClaseEstudiante> ListarEstudianteGeneral() {
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_listar_estudiante_general()}";
		
		CallableStatement cs=null;
		ResultSet rs=null;
		List<ClaseEstudiante> lista=new ArrayList<ClaseEstudiante>();

		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			rs=cs.executeQuery();

			while(rs.next()){

				ClaseEstudiante clest=new ClaseEstudiante();
				clest.setIdestudiante(rs.getString(1));
				clest.setDni(rs.getString(2));
				clest.setNombre(rs.getString(3));
				clest.setApellido(rs.getString(4));
				clest.setCorreo(rs.getString(5));
				clest.setTelefono(rs.getString(6));
				clest.setEstado(rs.getString(7));
				lista.add(clest);
						
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
