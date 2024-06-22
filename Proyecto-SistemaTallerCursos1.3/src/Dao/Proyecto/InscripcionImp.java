package Dao.Proyecto;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Conectar.Proyecto.ConexionBD;
import Interface.Proyecto.IntInscripcionable;
import Modelo.Proyecto.ClaseInscripcion;

public class InscripcionImp implements IntInscripcionable {

	@Override
	public void GenerarInscripcion(ClaseInscripcion ClsIns) {
		ConexionBD conex=new ConexionBD();
		String sql="{call sp_generar_inscripcion(?,?,?)}";
		CallableStatement cs=null;
		try {
			cs=conex.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, ClsIns.getIdestudiante());
			cs.setString(2, ClsIns.getIdcurso());
			cs.setDate(3, new java.sql.Date(ClsIns.getFechainscrip().getTime()));

			int x=cs.executeUpdate();
			
			if(x>0){
				System.out.println("Inscripcion Generada correctamente");
			} else {
				System.out.println("Error al Generar Inscripcion");
			}
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {		
                JOptionPane.showMessageDialog(null, "Ya existe una inscripción con el mismo estudiante y curso");
            } else {
                System.out.println("Error al insertar el registro: " + e.getMessage());
            }
		}
		
	}

	@Override
	public List<ClaseInscripcion> ListarInscripcion() {
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_listar_inscripcion()}";
		
		CallableStatement cs=null;
		ResultSet rs=null;
		List<ClaseInscripcion> lista=new ArrayList<ClaseInscripcion>();

		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			rs=cs.executeQuery();

			while(rs.next()){

				ClaseInscripcion clins=new ClaseInscripcion();
				clins.setNroinscrip(rs.getInt(1));
				clins.setIdestudiante(rs.getString(2));
				clins.setDniestudiante(rs.getString(3));
				clins.setEstudiante(rs.getString(4));
				clins.setIdcurso(rs.getString(5));
				clins.setCurso(rs.getString(6));
				clins.setDiacurso(rs.getString(7));
				clins.setHorinicurso(rs.getString(8));
				clins.setHorfincurso(rs.getString(9));
				clins.setFechainscrip(rs.getDate(10));
				lista.add(clins);
						
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;

	}

	@Override
	public ClaseInscripcion BuscarInscripcion(ClaseInscripcion clsIns) {
		ConexionBD cone=new ConexionBD();
		String sql="{call sp_buscar_inscripcion(?)}";
		
		CallableStatement cs=null;
		ResultSet rs=null;
		ClaseInscripcion almins= new ClaseInscripcion();
		try {
			cs=cone.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, clsIns.getDniestudiante());

			rs=cs.executeQuery();

			while(rs.next()){
				almins.setNroinscrip(rs.getInt(1));
				almins.setDniestudiante(rs.getString(2));
				almins.setEstudiante(rs.getString(3));
				almins.setCurso(rs.getString(4));
				almins.setDiacurso(rs.getString(5));
				almins.setHorinicurso(rs.getString(6));
				almins.setHorfincurso(rs.getString(7));
				almins.setFechainscrip(rs.getDate(8));					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return almins;
	}

	@Override
	public void EliminarInscripcion(ClaseInscripcion ClsIns) {
		ConexionBD conex=new ConexionBD();
		String sql="{call sp_quitar_inscripcion(?,?)}";
		CallableStatement cs=null;
		try {
			cs=conex.ConexionMysql().prepareCall(sql);
			
			cs.setString(1, ClsIns.getIdestudiante());
			cs.setString(2, ClsIns.getIdcurso());

			int y=cs.executeUpdate();
			
			if(y>0){
				System.out.println("Inscripcion Eliminada correctamente");
			} else {
				System.out.println("Error al Eliminar Inscripcion");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}

}
