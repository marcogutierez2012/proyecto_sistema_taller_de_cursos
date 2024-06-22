<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Dao.Proyecto.*"%>
<%@page import="Modelo.Proyecto.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<title>Generar Inscripcion - Taller de cursos de verano</title>

	<!-- para datepicker -->
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>  
  
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  
<script>
  $( function() {
    $( "#fechainscripcion" ).datepicker({
    		
    	dateFormat:"dd/mm/yy"
    
    });
  } );
</script>

<script>
$(document).ready(function() {
    $('form').submit(function(e) {
      e.preventDefault();
      
      var form = this;
      
      Swal.fire({
        title: 'Confirmación',
        text: '¿Estás seguro de inscribirte en este curso?',
        icon: 'question',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, inscribirme',
        cancelButtonText: 'Cancelar'
      }).then((result) => {
        if (result.isConfirmed) {
          // Realiza la validación del formulario
          if (validarFormulario()) {
            // Enviar el formulario usando AJAX
            $.ajax({
              url: $(form).attr('action'),
              type: $(form).attr('method'),
              data: $(form).serialize(),
              success: function(response) {
                Swal.fire({
                  title: 'Éxito',
                  text: 'Te has inscrito correctamente en el curso.',
                  icon: 'success'
                }).then((result) => {
                  if (result.isConfirmed) {
                    // Redirige a la página de listado de inscripciones
                    window.location.href = 'ControladorInscripcion?accion=ListadoInscrito';
                  }
                });
              },
              error: function() {
                Swal.fire({
                  title: 'Error',
                  text: 'Ha ocurrido un error al procesar la inscripción.',
                  icon: 'error'
                });
              }
            });
          } else {
            // Muestra un mensaje de error en caso de que la validación no pase
            Swal.fire({
              title: 'Error',
              text: 'Por favor, completa todos los campos requeridos.',
              icon: 'error'
            });
          }
        }
      });
    });
  });
  
  function validarFormulario() {
    // Realiza la validación del formulario aquí
    // Si todos los campos requeridos están completos, devuelve true
    // Si falta algún campo requerido, devuelve false
    var curso = $('select[name="curso"]').val();
    var fechaInscripcion = $('input[name="fechains"]').val();
    
    if (curso && fechaInscripcion) {
      return true;
    } else {
      return false;
    }
  }
</script>


</head>
<body>
<%@include file="template/menu.jsp"%>
<br>

<h2 align="center">INSCRIPCION DE ESTUDIANTES</h2>
<br>
<form id="form" action="ControladorInscripcion" method="post">
  <div class="container">
    <div class="row">
      <div class="col-md-6 offset-md-3">
        <div class="card">
          <div class="card-body">
            <div class="form-group">
              <label for="nombre">Nombre</label>
              <input type="text" value="${nombres}" name="estudiante" class="form-control" readonly required>
            </div>
            <div class="form-group">
              <label for="ID">ID</label>
              <input type="text" value="${idest}" name="idestudiante" class="form-control" readonly required>
            </div>
            <div class="form-group">
              <label for="curso">Curso</label>
              <select class="custom-select" name="curso" style="font-family: Arial, sans-serif;" required>
                <option value="" disabled selected>Seleccionar Curso</option>
                <% CursoImp curimp=new CursoImp();
                List<ClaseCurso> cursos = curimp.ListarCursoGeneral();
                for (ClaseCurso curso : cursos) { 
                  if (curso.getEstado().equals("si")) {
                    String nomcurso = curso.getNomcurso();
                %>
                <option value="<%= curso.getIdcurso() %>"><%= nomcurso %></option>
                <% }} %>
              </select>
            </div>
            <div class="form-group">
              <label for="fechains">Fecha de Inscripción</label>
              <input type="text" name="fechains" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/\d{4}" id="fechainscripcion" class="form-control" title="Ingrese una fecha válida" required>
            </div>
            <div class="text-center">
              <input type="submit" value="Inscribir" class="btn btn-primary btn-lg">
              <a href="ControladorInscripcion?accion=Listado" class="btn btn-secondary btn-lg">Ir al Listado</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</form>
<br>

</body>
</html>