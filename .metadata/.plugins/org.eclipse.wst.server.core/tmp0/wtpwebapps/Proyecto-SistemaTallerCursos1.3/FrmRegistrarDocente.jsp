<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrar Docente - Taller de Cursos de verano</title>
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

<h2 align="center">REGISTRAR DOCENTE</h2>
<br>
<div class="container">
  <div class="row">
    <div class="col-md-6 offset-md-3">
      <div class="card">
        <div class="card-body">
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
            <div class="text-center">
              <input type="submit" value="Registrar" class="btn btn-primary btn-lg">
              <a href="ControladorDocente?accion=Listado" class="btn btn-secondary btn-lg">Ir al Listado</a>
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