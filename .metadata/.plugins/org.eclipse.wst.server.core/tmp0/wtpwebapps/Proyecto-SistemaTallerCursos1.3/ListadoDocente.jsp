<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de Docentes - Taller de cursos de verano</title>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">


<link rel="stylesheet" href="datatables/datatables.min.css">
<link rel="stylesheet" href="datatables/DataTables-1.13.4/css/dataTables.bootstrap4.min.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<link rel="stylesheet" href="css/styles.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script>
$(document).ready(function() {
  $('#form-actualizar').submit(function(e) {
    e.preventDefault();

    var dni = $('[name="dni"]').val();
    var nombre = $('[name="nombre"]').val();
    var apellido = $('[name="apellido"]').val();
    var correo = $('[name="correo"]').val();
    var telefono = $('[name="telefono"]').val();

    if (!dni || !nombre || !apellido || !correo || !telefono) {
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
          text: 'El docente ha sido actualizado correctamente.',
          icon: 'success'
        }).then((result) => {
          if (result.isConfirmed) {
            window.location.href = 'ControladorDocente?accion=Listado';
          }
        });
      },
      error: function() {
        Swal.fire({
          title: 'Error',
          text: 'Ha ocurrido un error en la actualización.',
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
            text: 'El docente ha sido registrado correctamente.',
            icon: 'success'
          }).then((result) => {
            if (result.isConfirmed) {
              window.location.href = 'ControladorDocente?accion=Listado';
            }
          });
        },
        error: function() {
          Swal.fire({
            title: 'Error',
            text: 'Ha ocurrido un error en el registro.',
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

<h2 align="center">Listado de Docentes</h2>
<br>




<div class="responsive">
<div class="container">

    <a href="FrmRegistrarDocente.jsp" class="btn btn-success registrar-docente">Registrar Nuevo</a>
    | <a href="MenuPrincipal.jsp" class="btn btn-warning">Ir al Menu</a>
<br>    
<br>
<table id="tabla3" style="text-align: center;" class="table table-bordered table-striped">
<thead class="table-dark">
<tr><th>ID</th><th>Dni</th><th>Nombre</th><th>Apellido</th><th>Correo</th><th>Telefono</th>
<th></th></tr>
</thead>
<tbody id="table-hover">
<c:forEach var="docente" items="${listado}" >
<tr>
<td><c:out value="${docente.iddocente}"></c:out></td>
<td><c:out value="${docente.dni}"></c:out></td>
<td><c:out value="${docente.nombre}"></c:out></td>
<td><c:out value="${docente.apellido}"></c:out></td>
<td><c:out value="${docente.correo}"></c:out></td>
<td><c:out value="${docente.telefono}"></c:out></td>

<td><!-- <a href="ControladorDocente?accion=Actualizar&buscadoc=${docente.dni}"><img src="img/editar6.png"></a> -->
	<a href="#" class="editar-docente" data-iddocente="<c:out value='${docente.iddocente}' />" data-dni="<c:out value='${docente.dni}' />" data-nombre="<c:out value='${docente.nombre}' />" data-apellido="<c:out value='${docente.apellido}' />" data-correo="<c:out value='${docente.correo}' />" data-telefono="<c:out value='${docente.telefono}' />">
    <img src="img/editar6.png">
  </a>
        <c:if test="${docente.estadodocente eq 'no'}">
            
                <a id="eliminar" style="margin-left:10px;" href="ControladorDocente?accion=Eliminar&iddoc=${docente.iddocente}">
                <input type="hidden" id="codigo" value="${docente.iddocente}"><img src="img/eliminar6.png"></a>
            
        </c:if>
        </td>
</tr>
</c:forEach>
</tbody>
</table>
<br>
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

<script type="text/javascript" src="js/funcionesdocente.js"></script>



<!-- Modal para actualizar docente -->
<div class="modal fade" id="actualizarModal" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="actualizarModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header bg-info text-center">
        <h4 class="modal-title text-white mx-auto" id="actualizarModalLabel">Actualizar Docente</h4>
        <button type="button" class="close custom-close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <!-- Contenido del formulario de actualización -->
        <form id="form-actualizar" action="ControladorDocente?accion=Actualizar" method="post">
          <div class="form-group">
            <label for="dni">Dni</label>
            <input type="text" pattern="[0-9]{8}" class="form-control" placeholder="dni" name="dni" title="Ingresa un documento de identidad válido de 8 dígitos" required>
          </div>
          <div class="form-group">
            <label for="nombre">Nombre</label>
            <input type="text" pattern="[a-zA-Z ]+" class="form-control" placeholder="nombre" name="nombre" title="Ingresa un nombre válido" required>
          </div>
          <div class="form-group">
            <label for="apellido">Apellido</label>
            <input type="text" pattern="[a-zA-Z ]+" class="form-control" placeholder="apellido" name="apellido" title="Ingresa un apellido válido" required>
          </div>
          <div class="form-group">
            <label for="correo">Correo</label>
            <input type="email" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" class="form-control" placeholder="correo" name="correo" title="Ingresa un correo electrónico válido" required>
          </div>
          <div class="form-group">
            <label for="telefono">Teléfono</label>
            <input type="text" pattern="[9][0-9]{8}" class="form-control" placeholder="telefono" name="telefono" title="Ingresa un número de teléfono válido" required>
          </div>
          <input type="hidden" name="iddocente">
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
        <button type="submit" form="form-actualizar" class="btn btn-info">Actualizar</button>
      </div>
    </div>
  </div>
</div>

<!-- Script para capturar los datos del docente y cargarlos en el formulario del modal -->
<script>
$(document).ready(function() {
  // Al hacer clic en el enlace de editar, obtener los valores del docente y cargarlos en el formulario del modal
  $('a.editar-docente').click(function(e) {
    e.preventDefault();

    // Obtener los valores del docente
    var idDocente = $(this).data('iddocente');
    var dni = $(this).data('dni');
    var nombre = $(this).data('nombre');
    var apellido = $(this).data('apellido');
    var correo = $(this).data('correo');
    var telefono = $(this).data('telefono');

    // Establecer los valores en el formulario del modal
    $('#actualizarModal input[name="iddocente"]').val(idDocente);
    $('#actualizarModal input[name="dni"]').val(dni);
    $('#actualizarModal input[name="nombre"]').val(nombre);
    $('#actualizarModal input[name="apellido"]').val(apellido);
    $('#actualizarModal input[name="correo"]').val(correo);
    $('#actualizarModal input[name="telefono"]').val(telefono);

    // Mostrar el modal
    $('#actualizarModal').modal('show');
  });
});
</script>

<!-- Modal para registrar docente -->
<div class="modal fade" id="registroModal" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="registroModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header bg-primary text-center">
        <h4 class="modal-title text-white mx-auto" id="registroModalLabel">Registrar Docente</h4>
        <button type="button" class="close custom-close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <!-- Contenido del formulario de registro -->
        <form id="form-registro" action="ControladorDocente" method="post">
          <div class="form-group">
            <label for="dni">DNI</label>
            <input type="text" pattern="[0-9]{8}" name="dni" class="form-control" title="Ingresa un documento de identidad válido de 8 dígitos" required>
          </div>
          <div class="form-group">
            <label for="nombre">Nombre</label>
            <input type="text" pattern="[a-zA-Z ]+" name="nombre" class="form-control" title="Ingresa un nombre válido" required>
          </div>
          <div class="form-group">
            <label for="apellido">Apellido</label>
            <input type="text" pattern="[a-zA-Z ]+" name="apellido" class="form-control" title="Ingresa un apellido válido" required>
          </div>
          <div class="form-group">
            <label for="correo">Correo</label>
            <input type="email" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" name="correo" class="form-control" title="Ingresa un correo electrónico válido" required>
          </div>
          <div class="form-group">
            <label for="telefono">Teléfono</label>
            <input type="text" pattern="[9][0-9]{8}" name="telefono" class="form-control" title="Ingresa un número de teléfono válido" required>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
        <button type="submit" form="form-registro" class="btn btn-primary">Registrar</button>
      </div>
    </div>
  </div>
</div>

<!-- Script para mostrar el modal de registro -->
<script>
  $(document).ready(function() {
    // Al hacer clic en el enlace de registro, mostrar el modal de registro
    $('a.registrar-docente').click(function(e) {
      e.preventDefault();
      $('#registroModal').modal('show');
    });
  });
</script>

<script>
$(document).ready(function() {    
    $('#tabla3').DataTable({        
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
				className: 'btn btn-success',				
				exportOptions: {
			        columns: ':not(:last-child)' // No imprimir la última columna
			    },
			    
			},
			{
				extend:    'pdfHtml5',
				text:      '<i class="fas fa-file-pdf"></i> ',
				titleAttr: 'Exportar a PDF',
				className: 'btn btn-danger',
				exportOptions: {
				        columns: ':not(:last-child)' // No imprimir la última columna
				        
				    },
			},
			
			{
				extend:    'print',
				text:      '<i class="fa fa-print"></i> ',
				titleAttr: 'Imprimir',
				className: 'btn btn-info',
				exportOptions: {
			        columns: ':not(:last-child)' // No imprimir la última columna
			    },
			    
			},
		]	        
    });     
});
</script>
</body>
</html>