package Dao.Proyecto;

import Modelo.Proyecto.ClaseUsuario;

public class TestUsuarioImp {

	public static void main(String[] args) {
		UsuarioImp usuimp=new UsuarioImp();
		
		ClaseUsuario clusua=new ClaseUsuario();
		
		clusua.setNomusuario("admin");
		clusua.setPassword("123456");
		
		ClaseUsuario vlusua=usuimp.validarUsuario(clusua);
		if(vlusua.getNomusuario()!=null && vlusua.getPassword()!=null){
			//emitimos un mensaje por consola
			System.out.println("Credenciales correctas");
		}
		else{
			//emitimos un mensaje por consola
			System.out.println("Credenciales incorrectas");
		}

	}

}
