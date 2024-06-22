<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registar Curso - Taller de cursos de verano</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script>
$(document).ready(function() {
  $('#form-registro').submit(function(e) {
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

<h2 align="center">REGISTRAR CURSO</h2>
<br>
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-8">
      <div class="card">
        <div class="card-body">
          <form id="form-registro" action="ControladorCurso" method="post">
            <div class="form-group">
              <label for="nomcurso">Curso</label>
              <input type="text" pattern="[a-zA-Z][0-9]?+" name="nomcurso" class="form-control" title="Ingresa un dato válido" required>
            </div>
            <div class="form-group">
              <label for="descurso">Descripción</label>
              <input type="text" pattern="[a-zA-Z][0-9]?+" name="descurso" class="form-control" title="Ingresa un dato válido" required>
            </div>
            <div class="form-group">
              <label for="diacurso">Día</label>
              <select class="custom-select" pattern="[a-zA-Z]{10}" name="diacurso" style="font-family: Arial, sans-serif;" title="Ingresa un dato válido" required>
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
              <input type="text" pattern="[0-9]{1,4}" name="vaccurso" class="form-control" title="Ingresa un dato válido" required>
            </div>
            <div class="text-center">
              <input type="submit" value="Registrar" class="btn btn-primary btn-lg">
              <a href="ControladorCurso?accion=Listado" class="btn btn-secondary btn-lg">Ir al Listado</a>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<br>
</body>
</html>