package Dao.Proyecto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conectar.Proyecto.ConexionBD;
import Interface.Proyecto.IntUsuariable;
import Modelo.Proyecto.ClaseUsuario;

public class UsuarioImp implements IntUsuariable{

	@Override
	public ClaseUsuario validarUsuario(ClaseUsuario clsUsu) {
		//Instanciamos la conexion a la BD
		ConexionBD conex=new ConexionBD();
		//Realizamos el comando
		String sql="select * from tbl_usuario where nomusuario=? and password=?";
		//Aplicamos las interfaces para la BD
		PreparedStatement ps=null;
		ResultSet rs=null;
						
		//Realizamos una instancia de la ClaseUsuario
		ClaseUsuario clusua=new ClaseUsuario();
		try {
			ps=conex.ConexionMysql().prepareStatement(sql);
			//Asignamos los parametros
			ps.setString(1, clsUsu.getNomusuario());
			ps.setString(2, clsUsu.getPassword());
			//Ejecutamos
			rs=ps.executeQuery();
			//Aplicamos una condicion
			if(rs.next()){
				clusua.setNomusuario(rs.getString(1));
				clusua.setPassword(rs.getString(2));
			}
							
		} catch (SQLException e) {
			e.printStackTrace();
		}
						
		return clusua;
	}

}
