<%@page import="Dao.Proyecto.CursoImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado General de Cursos</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">


<link rel="stylesheet" href="datatables/datatables.min.css">
<link rel="stylesheet" href="datatables/DataTables-1.13.4/css/dataTables.bootstrap4.min.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<link rel="stylesheet" href="css/styles.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script>
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
</script>

<script>
$(document).ready(function() {
  $('#form-actualizar').submit(function(e) {
    e.preventDefault();

    var nomcurso = $('[name="nomcurso"]').val();
    var descurso = $('[name="descurso"]').val();
    var diacurso = $('[name="diacurso"]').val();
    var horinicurso = $('[name="horinicurso"]').val();
    var horfincurso = $('[name="horfincurso"]').val();
    var vaccurso = $('[name="vaccurso"]').val();

    if (!nomcurso || !descurso || !diacurso || !horinicurso || !horfincurso || !vaccurso) {
      Swal.fire({
        title: 'Error',
        text: 'Por favor, complete todos los campos.',
        icon: 'error'
      });
      return;
    }

    $.ajax({
      url: $(this).attr('action'),
      type: $(this).attr('method'),
      data: $(this).serialize(),
      success: function(response) {
        Swal.fire({
          title: '¡Actualización Exitosa!',
          text: 'El curso ha sido actualizado correctamente.',
          icon: 'success'
        }).then((result) => {
          if (result.isConfirmed) {
            window.location.href = 'ControladorCurso?accion=Listado';
          }
        });
      },
      error: function() {
        Swal.fire({
          title: 'Error',
          text: 'Ha ocurrido un error en la actualización del curso.',
          icon: 'error'
        });
      }
    });
  });
});
</script>

<style>
.custom-close {
  background-color: red;
  color: white;
  border: none;
  width: 30px;
  height: 30px;
  font-size: 20px;
  line-height: 0;
  padding: 0;
  opacity: 0.8;
  transition: background-color 0.3s ease;
}

.custom-close:hover {
  background-color: red;
  opacity: 1;
}

.custom-close:focus {
  outline: none;
}

.custom-close span {
  position: relative;
  top: 50%;
  left: -6px; /* Ajusta el valor según tu preferencia */
  rigth: 
  transform: translate(-50%, -50%);
}

.custom-close:hover span {
  color: white;
}


</style>

<script>
$(document).ready(function() {
  $('#form-registro').submit(function(e) {
    e.preventDefault();

    $.ajax({
      url: $(this).attr('action'),
      type: $(this).attr('method'),
      data: $(this).serialize(),
      success: function(response) {
        Swal.fire({
          title: '¡Registro Exitoso!',
          text: 'El curso ha sido registrado correctamente.',
          icon: 'success'
        }).then((result) => {
          if (result.isConfirmed) {
            window.location.href = 'ControladorCurso?accion=Listado';
          }
        });
      },
      error: function() {
        Swal.fire({
          title: 'Error',
          text: 'Ha ocurrido un error en el registro del curso.',
          icon: 'error'
        });
      }
    });
  });
});
</script>

</head>
<body>
<%@include file="template/menu.jsp"%>
<br>

<h2 align="center">Listado de Cursos General</h2>
<br>

<div class="responsive">

<div class="container">
<div class="table-responsive">

    <a href="#" class="btn btn-success registrar-curso">Registrar Nuevo</a>
    | <a href="MenuPrincipal.jsp" class="btn btn-warning">Ir al Menu</a>
<br>    
<br>
<table id="tabla1" style="text-align: center;" class="table table-bordered table-striped">
<thead class="table-dark">
<tr><th>ID</th><th>Curso</th><th>Descripcion</th><th>Dia</th><th>Hora de inicio</th><th>Hora de fin</th><th>Vacantes</th>
<th>Acciones</th></tr>
</thead>
<tbody id="table-hover">
<c:forEach var="curso" items="${listadoGeneral}" >
<tr>
<td><c:out value="${curso.idcurso}"></c:out></td>
<td><c:out value="${curso.nomcurso}"></c:out></td>
<td><c:out value="${curso.descripcion}"></c:out></td>
<td><c:out value="${curso.dia}"></c:out></td>
<td><c:out value="${curso.horinicio}"></c:out></td>
<td><c:out value="${curso.horafin}"></c:out></td>
<td><c:out value="${curso.vacantes}"></c:out></td>
<td>
	<!-- <a href="ControladorCurso?accion=Actualizar&nomcur=${curso.nomcurso}" class="btn btn-warning btn-sm">Actualizar</a> -->
	<!-- <a href="#" class="editar-curso" data-idcurso="<c:out value='${curso.idcurso}' />" data-curso="<c:out value='${curso.nomcurso}' />" data-descripcion="<c:out value='${curso.descripcion}' />" data-dia="<c:out value='${curso.dia}' />" data-horinicio="<c:out value='${curso.horinicio}' />" data-horafin="<c:out value='${curso.horafin}' />" data-vacantes="<c:out value='${curso.vacantes}' />">
    <img src="img/editar6.png">
  </a> -->
  <a href="#" class="editar-curso" data-idcurso="${curso.idcurso}" data-curso="${curso.nomcurso}" data-descripcion="${curso.descripcion}" data-dia="${curso.dia}" data-horinicio="${curso.horinicio}" data-horafin="${curso.horafin}" data-vacantes="${curso.vacantes}">
  <img src="img/editar6.png">
  </a>

        <c:if test="${curso.estado eq 'no'}">      
                <a id="eliminar" style="margin-left:10px;" href="ControladorCurso?accion=Eliminar&idcur=${curso.idcurso}">
                <input type="hidden" id="codigo" value="${curso.idcurso}"><img src="img/eliminar6.png"></a>
            
        </c:if>
        </td>
</tr>
</c:forEach>
</tbody>
</table>
<br>
</div>
</div>
</div>
<br>

<!-- <script src="jquery/jquery-3.3.1.min.js"></script> -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>

<script type="text/javascript" src="datatables/datatables.min.js"></script>


<script src="datatables/Buttons-2.3.6/js/dataTables.buttons.min.js"></script>
<script src="datatables/JSZip-2.5.0/jszip.min.js"></script>
<script src="datatables/pdfmake-0.2.7/pdfmake.min.js"></script>
<script src="datatables/pdfmake-0.2.7/vfs_fonts.js"></script>
<script src="datatables/Buttons-2.3.6/js/buttons.html5.min.js"></script>

<script type="text/javascript" src="js/main.js"></script>

<!-- Modal para actualizar curso -->
<div class="modal fade" id="actualizarModal" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="actualizarModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header bg-info text-center">
        <h4 class="modal-title text-white mx-auto" id="actualizarModalLabel">Actualizar Curso</h4>
        <button type="button" class="close custom-close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <!-- Contenido del formulario de actualización -->
        <form id="form-actualizar" action="ControladorCurso?accion=Actualizar" method="post">
            
              <div class="form-group">
                <label for="nomcurso">Curso</label>
                  <input type="text" pattern="[a-zA-Z][0-9]?+" class="form-control" placeholder="curso" name="nomcurso" title="Ingresa un dato válido" required>              
              </div>
              <div class="form-group">
              <label for="descurso">Descripción</label>
                  <input type="text" pattern="[a-zA-Z][0-9]?+" class="form-control" placeholder="descripcion" name="descurso" title="Ingresa un dato válido" required>
                </div>
              
              <div class="form-group">
  				<label for="diacurso">Día</label>
  					<select class="custom-select" name="diacurso" style="font-family: Arial, sans-serif;" title="Ingresa un dato válido" required>
    				<option disabled selected>Seleccionar Día</option>
                <option>Lunes</option>
                <option>Martes</option>
                <option>Miércoles</option>
                <option>Jueves</option>
                <option>Viernes</option>
                <option>Sábado</option>
                <option>Domingo</option>
 					 </select>
				</div>
                <div class="form-row">
              	<div class="form-group col-md-6">
                <label for="horinicurso">Hora de inicio</label>
                      <select class="custom-select" name="horinicurso" style="font-family: Arial, sans-serif;" title="Ingresa un dato válido" required>
                        <option disabled selected>Seleccionar Hora</option>
                  <option>08:00</option>
                  <option>09:00</option>
                  <option>10:00</option>
                  <option>11:00</option>
                  <option>12:00</option>
                  <option>13:00</option>
                  <option>14:00</option>
                  <option>15:00</option>
                  <option>16:00</option>
                  <option>17:00</option>
                  <option>18:00</option>
                  <option>19:00</option>
                      </select>
                    </div>
                    
              		<div class="form-group col-md-6">
              		<label for="horfincurso">Hora de fin</label>
                      <select class="custom-select" name="horfincurso" style="font-family: Arial, sans-serif;" title="Ingresa un dato válido" required>
                        <option disabled selected>Seleccionar Hora</option>
                  <option>10:00</option>
                  <option>11:00</option>
                  <option>12:00</option>
                  <option>13:00</option>
                  <option>14:00</option>
                  <option>15:00</option>
                  <option>16:00</option>
                  <option>17:00</option>
                  <option>18:00</option>
                  <option>19:00</option>
                  <option>20:00</option>
                  <option>21:00</option>
                      </select>
                    </div>
                  </div>
                
              <div class="form-group">
              <label for="vaccurso">Vacantes</label>
                  <input type="text" pattern="[0-9]{1,4}" class="form-control" placeholder="vacantes" name="vaccurso" title="Ingresa un dato válido" required>
                </div>
              
            <input type="hidden" name="idcurso">
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
        <button type="submit" form="form-actualizar" class="btn btn-info">Actualizar</button>
      </div>
    </div>
  </div>
</div>

<!-- Script para capturar los datos del curso y cargarlos en el formulario del modal -->
<script>
$(document).ready(function() {
	  // Al hacer clic en el enlace de editar, obtener los valores del curso y cargarlos en el formulario del modal
	  $('a.editar-curso').click(function(e) {
	    e.preventDefault();

	    // Obtener los valores del curso
	    var idcurso = $(this).data('idcurso');
	    var nomcurso = $(this).data('curso');
	    var descripcion = $(this).data('descripcion');
	    var dia = $(this).data('dia');
	    var horinicio = $(this).data('horinicio');
	    var horafin = $(this).data('horafin');
	    var vacantes = $(this).data('vacantes');

	    // Establecer los valores en el formulario del modal
	    $('#actualizarModal input[name="idcurso"]').val(idcurso);
	    $('#actualizarModal input[name="nomcurso"]').val(nomcurso);
	    $('#actualizarModal input[name="descurso"]').val(descripcion);
	    $('#actualizarModal select[name="diacurso"]').val(dia);
	    $('#actualizarModal select[name="horinicurso"]').val(horinicio);
	    $('#actualizarModal select[name="horfincurso"]').val(horafin);
	    $('#actualizarModal input[name="vaccurso"]').val(vacantes);

	    // Mostrar el modal
	    $('#actualizarModal').modal('show');
	  });
	});
</script>

<!-- Modal para registrar curso -->
<div class="modal fade" id="registroModal" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="registroModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header bg-primary text-center">
        <h4 class="modal-title text-white mx-auto" id="registroModalLabel">Registrar Curso</h4>
        <button type="button" class="close custom-close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <!-- Contenido del formulario de registro -->
        <form id="form-registro" action="ControladorCurso" method="post">
          <div class="form-group">
            <label for="nomcurso">Curso</label>
            <input type="text" class="form-control" pattern="[a-zA-Z][0-9]?+" title="Ingresa un dato válido" placeholder="Curso" name="nomcurso" required>
          </div>
          <div class="form-group">
            <label for="descurso">Descripción</label>
            <input type="text" class="form-control" pattern="[a-zA-Z][0-9]?+" title="Ingresa un dato válido" placeholder="Descripción" name="descurso" required>
          </div>
          <div class="form-group">
            <label for="diacurso">Día</label>
            <select class="custom-select" style="font-family: Arial, sans-serif;" title="Ingresa un dato válido" name="diacurso" required>
              <option disabled selected>Seleccionar Día</option>
              <option>Lunes</option>
              <option>Martes</option>
              <option>Miércoles</option>
              <option>Jueves</option>
              <option>Viernes</option>
              <option>Sábado</option>
              <option>Domingo</option>
            </select>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="horinicurso">Hora de inicio</label>
              <select class="custom-select" name="horinicurso" style="font-family: Arial, sans-serif;" title="Ingresa un dato válido" required>
                <option disabled selected>Seleccionar Hora</option>
                <option>08:00</option>
                <option>09:00</option>
                <option>10:00</option>
                <option>11:00</option>
                <option>12:00</option>
                <option>13:00</option>
                <option>14:00</option>
                <option>15:00</option>
                <option>16:00</option>
                <option>17:00</option>
                <option>18:00</option>
                <option>19:00</option>
              </select>
            </div>
            <div class="form-group col-md-6">
              <label for="horfincurso">Hora de fin</label>
              <select class="custom-select" name="horfincurso" style="font-family: Arial, sans-serif;" title="Ingresa un dato válido" required>
                <option disabled selected>Seleccionar Hora</option>
                <option>10:00</option>
                <option>11:00</option>
                <option>12:00</option>
                <option>13:00</option>
                <option>14:00</option>
                <option>15:00</option>
                <option>16:00</option>
                <option>17:00</option>
                <option>18:00</option>
                <option>19:00</option>
                <option>20:00</option>
                <option>21:00</option>
              </select>
            </div>
          </div>
          <div class="form-group">
            <label for="vaccurso">Vacantes</label>
            <input type="number" class="form-control" pattern="[0-9]{1,4}" title="Ingresa un dato válido" placeholder="Vacantes" name="vaccurso" required>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
            <button type="submit" form="form-registro" class="btn btn-success">Registrar</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>


<script>
$(document).ready(function() {
	  // Al hacer clic en el enlace de registrar
	  $('a.registrar-curso').click(function(e) {
	    e.preventDefault();

	    // Mostrar el modal
	    $('#registroModal').modal('show');
	  });
	});
</script>

<script>
$(document).ready(function() {    
    $('#tabla1').DataTable({        
        language: {
                "lengthMenu": "Mostrar _MENU_ registros",
                "zeroRecords": "No se encontraron resultados",
                "info": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                "infoFiltered": "(filtrado de un total de _MAX_ registros)",
                "sSearch": "Buscar:",
                "oPaginate": {
                    "sFirst": "Primero",
                    "sLast":"Último",
                    "sNext":"Siguiente",
                    "sPrevious": "Anterior"
			     },
			     "sProcessing":"Procesando...",		     
            },
            
        //para usar los botones   
        responsive: "true",
        dom: 'Bfrtilp',       
        buttons:[ 
			{
				extend:    'excelHtml5',
				text:      '<i class="fas fa-file-excel"></i> ',
				titleAttr: 'Exportar a Excel',
				className: 'btn btn-success'
			},
			{
				extend:    'pdfHtml5',
				text:      '<i class="fas fa-file-pdf"></i> ',
				titleAttr: 'Exportar a PDF',
				className: 'btn btn-danger'
			},
			
			{
				extend:    'print',
				text:      '<i class="fa fa-print"></i> ',
				titleAttr: 'Imprimir',
				className: 'btn btn-info'
					
			},
		]	        
    });     
});
</script>
<!-- <script type="text/javascript" src="js/funcionescurso.js"></script> -->
</body>
</html>