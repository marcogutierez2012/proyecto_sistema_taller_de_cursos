$(document).ready(function(){
	
	//cuando hacemos el evento click
	$("tr #eliminar").click(function(y){
		y.preventDefault();
		var idcur=$(this).parent().find("#codigo").val();	
		Swal.fire({
			title: '¿Estás seguro?',
			text: '¡No podrás revertir esto!',
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: 'Sí, eliminarlo'
			}).then((result) => {
			  if (result.isConfirmed) {
			    //invocamos a la funcion...
			    eliminarcurso(idcur);
			    
			    Swal.fire(
			    		'¡Eliminado!',
			    		'Tu archivo ha sido eliminado.',
			    		'success'
			    		)
			    //reiniciamos el navegador...
			    setTimeout(function(){
			    	parent.location="ControladorCurso?accion=Listado"
			    },2000)
			  }  //fin de la condicion...
			})  //fin de la notificacion	
		
	})  //fin del evento click...
	
	
	

 //creamos una funcion que permita capturar el codigo
 function eliminarcurso(idcur){
	 //recibimos el codigo
	 var codigo=String(idcur);
	 var url="ControladorCurso?accion=Eliminar&idcur="+codigo;
	 $.ajax({
		url:url,
		async:true,
		success:function(r){
			//vemos respuesta 
			console.log(r)
		}		 
	 })  //fin ajax...	 
 }  //fin de la funcion....
 
})   //fin de jquery....
