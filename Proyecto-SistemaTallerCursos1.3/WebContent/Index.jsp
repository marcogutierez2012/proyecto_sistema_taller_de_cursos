<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Logueo - Taller de Cursos</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet"  href="Estilos/Index.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>



</head>
<body>

<form id="form-login" action="ControladorLogueo" method="post">
	<div align="center"><img src="img/usuario.png" alt="usuario"></div><br>
  <h1><span>Iniciar</span> Sesion</h1>
  <input name="usuario" id="usuario" placeholder="usuario" type="text"/>
  <input name="password" id="password" placeholder="password" type="password"/>
  <button type="submit" class="btn btn-info"><i class="fas fa-paper-plane"></i> Iniciar Sesion</button>
  <div class="mt-2" align="center"><label>${mensaje}</label></div>
</form>

<!-- <script>
    $(document).ready(function() {
        var mensaje = '${mensaje}';
        var successMessage = '${successMessage}';

        if (mensaje !== '') {
            Swal.fire({
                title: 'Error',
                text: mensaje,
                icon: 'error',
                confirmButtonColor: '#3085d6',
                confirmButtonText: 'Aceptar'
            });
        } else if (successMessage !== '') {
            Swal.fire({
                title: 'Éxito',
                text: successMessage,
                icon: 'success',
                confirmButtonColor: '#3085d6',
                confirmButtonText: 'Aceptar'
            });
        }
    });
</script> -->
<%-- Lógica para mostrar mensaje de error al colocar las credenciales incorrectas--%>
<% if (request.getAttribute("mensaje") != null && !request.getAttribute("mensaje").toString().isEmpty()) { %>
    <script>
        Swal.fire({
            title: 'Error',
            text: '<%= request.getAttribute("mensaje").toString() %>',
            icon: 'error',
            confirmButtonColor: '#3085d6',
            confirmButtonText: 'Aceptar'
        });
    </script>
<% } %>



</body>
</html>