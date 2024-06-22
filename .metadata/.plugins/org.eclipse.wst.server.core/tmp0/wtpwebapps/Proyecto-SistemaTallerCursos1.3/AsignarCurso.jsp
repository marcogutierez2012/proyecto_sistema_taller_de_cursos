<%@page import="Dao.Proyecto.*"%>
<%@page import="Modelo.Proyecto.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Asignar Curso - Taller de cursos de verano</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script>
$(document).ready(function() {
  $('form').submit(function(e) {
    e.preventDefault();
    
    var form = this;
    
    Swal.fire({
      title: 'Confirmación',
      text: '¿Estás seguro de asignar este curso?',
      icon: 'question',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Sí, asignar',
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
                text: 'El curso ha sido asignado correctamente.',
                icon: 'success'
              }).then((result) => {
                if (result.isConfirmed) {
                  // Redirige a la página de listado de asignaturas
                  window.location.href = 'ControladorAsignatura?accion=Listado';
                }
              });
            },
            error: function() {
              Swal.fire({
                title: 'Error',
                text: 'Ha ocurrido un error al procesar la asignación del curso.',
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
  var docente = $('select[name="docente"]').val();
  
  if (curso && docente) {
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

<h2 align="center">ASIGNAR CURSO</h2>
<br>
<form id="form" action="ControladorAsignatura" method="post">
  <div class="container">
    <div class="row">
      <div class="col-md-6 offset-md-3">
        <div class="card">
          <div class="card-body">
            <div class="form-group">
              <label for="curso">Curso</label>
              <select class="custom-select" name="curso" style="font-family: Arial, sans-serif;" required>
                <option value="" disabled selected>Seleccionar Curso</option>
                <% CursoImp curimp=new CursoImp();
                List<ClaseCurso> cursos = curimp.ListarCursoGeneral();
                for (ClaseCurso curso : cursos) { 
                  if (curso.getEstado().equals("no")) {%>
                  <option value="<%= curso.getIdcurso() %>"><%= curso.getNomcurso() %></option>
                <% }} %>
              </select>
            </div>
            <div class="form-group">
              <label for="docente">Docente</label>
              <select name="docente" class="custom-select" style="font-family: Arial, sans-serif;">
                <option value="" disabled selected>Seleccionar Docente</option>
                <% DocenteImp docimp = new DocenteImp();
                List<ClaseDocente> docentes = docimp.ListarDocenteGeneral();
                for (ClaseDocente docente : docentes) { %>
                <option value="<%= docente.getIddocente() %>"><%= docente.getNombre() + " " + docente.getApellido() %></option>
                <% } %>
              </select>
            </div>
            <div class="text-center">
              <input type="submit" value="Asignar" class="btn btn-primary btn-lg">
              <a href="ControladorAsignatura?accion=Listado" class="btn btn-secondary btn-lg">Ir al Listado</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</form>


</body>
</html>