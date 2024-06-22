package Dao.Proyecto;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conectar.Proyecto.ConexionBD;
import Interface.Proyecto.IntDocenteable;
import Modelo.Proyecto.ClaseCurso;
import Modelo.Proyecto.ClaseDocente;

public class DocenteImp implements IntDocenteable{

	@Override
	public void RegistrarDocente(ClaseDocente clsDoc) {
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_registrar_docente(?,?,?,?,?)}";
		CallableStatement cs=null;
		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, clsDoc.getDni());
			cs.setString(2, clsDoc.getNombre());
			cs.setString(3, clsDoc.getApellido());
			cs.setString(4, clsDoc.getCorreo());
			cs.setString(5, clsDoc.getTelefono());

			int x=cs.executeUpdate();
			
			if(x>0){
				System.out.println("Datos del Docente Registrados correctamente");
			} else {
				System.out.println("Error al Registrar los datos del Docente");
			}		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void ActualizarDocente(ClaseDocente clsDoc) {
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_actualizar_docente(?,?,?,?,?,?)}";
		CallableStatement cs=null;
		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, clsDoc.getIddocente());
			cs.setString(2, clsDoc.getDni());
			cs.setString(3, clsDoc.getNombre());
			cs.setString(4, clsDoc.getApellido());
			cs.setString(5, clsDoc.getCorreo());
			cs.setString(6, clsDoc.getTelefono());

			int x=cs.executeUpdate();
			
			if(x>0){
				System.out.println("Datos del Docente Actualizados correctamente");
			} else {
				System.out.println("Error al Actualizar los datos del Docente");
			}		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void EliminarDocente(ClaseDocente clsDoc) {
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_eliminar_docente(?)}";
		CallableStatement cs=null;
		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, clsDoc.getIddocente());
			
			int x=cs.executeUpdate();
			
			if(x>0){
				System.out.println("Datos del Docente Eliminados correctamente");
			} else {
				System.out.println("Error al Eliminar Datos del Docente");
			}		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public ClaseDocente BuscarDocente(ClaseDocente clsDoc) {
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_buscar_docente(?)}";
		
		CallableStatement cs=null;
		ResultSet rs=null;
		ClaseDocente almdoc= new ClaseDocente();
		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, clsDoc.getDni());

			rs=cs.executeQuery();

			while(rs.next()){
				almdoc.setIddocente(rs.getString(1));
				almdoc.setDni(rs.getString(2));
				almdoc.setNombre(rs.getString(3));
				almdoc.setApellido(rs.getString(4));
				almdoc.setCorreo(rs.getString(5));
				almdoc.setTelefono(rs.getString(6));					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return almdoc;
	}

	@Override
	public List<ClaseDocente> ListarDocenteGeneral() {

		ConexionBD cone=new ConexionBD();
		String sql="{call sp_listar_docente_general()}";
		
		CallableStatement cs=null;
		ResultSet rs=null;
		List<ClaseDocente> lista=new ArrayList<ClaseDocente>();

		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			rs=cs.executeQuery();

			while(rs.next()){

				ClaseDocente cldoc=new ClaseDocente();
				cldoc.setIddocente(rs.getString(1));
				cldoc.setDni(rs.getString(2));
				cldoc.setNombre(rs.getString(3));
				cldoc.setApellido(rs.getString(4));
				cldoc.setCorreo(rs.getString(5));
				cldoc.setTelefono(rs.getString(6));
				cldoc.setEstadodocente(rs.getString(7));
				lista.add(cldoc);
						
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
