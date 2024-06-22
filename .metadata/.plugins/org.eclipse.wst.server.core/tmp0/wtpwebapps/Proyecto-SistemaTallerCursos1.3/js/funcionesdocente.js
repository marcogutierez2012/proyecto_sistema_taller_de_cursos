$(document).ready(function(){
	
	//cuando hacemos el evento click
	$("tr #eliminar").click(function(y){
		y.preventDefault();
		var iddoc=$(this).parent().find("#codigo").val();	
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
			    eliminardocente(iddoc);
			    
			    Swal.fire(
			    		'¡Eliminado!',
			    		'Tu archivo ha sido eliminado.',
			    		'success'
			    		)
			    //reiniciamos el navegador...
			    setTimeout(function(){
			    	parent.location="ControladorDocente?accion=Listado"
			    },2000)
			  }  //fin de la condicion...
			})  //fin de la notificacion	
		
	})  //fin del evento click...
	
	
	

 //creamos una funcion que permita capturar el codigo
 function eliminardocente(iddoc){
	 //recibimos el codigo
	 var codigo=String(iddoc);
	 var url="ControladorDocente?accion=Eliminar&iddoc="+codigo;
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