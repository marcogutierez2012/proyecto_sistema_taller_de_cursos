<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<title>Menu - Taller de cursos de verano</title>


</head>
<body>
<%@include file="template/menu.jsp"%>
<br>
<div class="container">
${mensaje}
<h3>Bienvenido al Sistema</h3><h2>${verusu.getNomusuario()}</h2>
</div>
<%-- Lógica para mostrar mensaje de éxito después de un inicio de sesión exitoso --%>
<% if (request.getAttribute("successMessage") != null && !request.getAttribute("successMessage").toString().isEmpty()) { %>
    <script>
        Swal.fire({
            title: 'Éxito',
            text: '<%= request.getAttribute("successMessage").toString() %>',
            icon: 'success',
            confirmButtonColor: '#3085d6',
            confirmButtonText: 'Aceptar'
        });
    </script>
<% } %>


</body>
</html>