<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de Estudiantes</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">


<link rel="stylesheet" href="datatables/datatables.min.css">
<link rel="stylesheet" href="datatables/DataTables-1.13.4/css/dataTables.bootstrap4.min.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<link rel="stylesheet" href="css/styles.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</head>
<body>
<%@include file="template/menu.jsp"%>
<br>

<h2 align="center">Listado de Estudiantes</h2>
<br>





<div class="responsive">

<div class="container">
<table id="example" style="text-align: center;" class="table table-striped">
<thead class="table-dark">
<tr><th>Dni</th><th>Nombre</th><th>Apellido</th><th>Correo</th><th>Telefono</th>
<th>Opciones</th></tr>
</thead>
<tbody id="table-hover">
<c:forEach var="estudiante" items="${listado}" >
<tr>
<td><c:out value="${estudiante.dni}"></c:out></td>
<td><c:out value="${estudiante.nombre}"></c:out></td>
<td><c:out value="${estudiante.apellido}"></c:out></td>
<td><c:out value="${estudiante.correo}"></c:out></td>
<td><c:out value="${estudiante.telefono}"></c:out></td>
<td><a href="ControladorInscripcion?accion=Inscribir&buscaest=${estudiante.dni}" class="btn btn-warning btn-sm">Inscribir</a>
</tr>
</c:forEach>
</tbody>
</table>
<br>
<!-- <div class="container">
    <a href="MenuPrincipal.jsp" class="btn btn-warning">Ir al Menu</a>
    
</div> -->
</div>
</div>

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
</body>
</html>