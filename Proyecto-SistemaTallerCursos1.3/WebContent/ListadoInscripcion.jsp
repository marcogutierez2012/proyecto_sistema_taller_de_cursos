<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">


<link rel="stylesheet" href="datatables/datatables.min.css">
<link rel="stylesheet" href="datatables/DataTables-1.13.4/css/dataTables.bootstrap4.min.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<link rel="stylesheet" href="css/styles.css">

 <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<title>Listado de Inscripciones</title>

</head>
<body>
<%@include file="template/menu.jsp"%>
<br>

<h2 align="center">Listado de Estudiante Inscritos</h2>
<br>

<div class="responsive">

<div class="container">

	<a href="ControladorInscripcion?accion=Listado" style="text-decoration: none" class="btn btn-success">Inscribir</a>
    | <a href="MenuPrincipal.jsp" class="btn btn-warning">Ir al Menu</a>
 <br>
 <br>   

<table id="example" style="text-align: center;" class="table table-striped">
<thead class="table-dark">
<tr><th>Nro. Inscripcion</th><th>Dni</th><th>Nombres</th><th>Curso</th><th>Dia</th><th>Hora de Inicio</th>
<th>Hora de Fin</th><th>Fecha de Inscripcion</th><th>Acciones</th></tr>
</thead>
<tbody id="table-hover">
<c:forEach var="inscripcion" items="${listado}" >
<tr>
<td><c:out value="${inscripcion.nroinscrip}"></c:out></td>
<td><c:out value="${inscripcion.dniestudiante}"></c:out></td>
<td><c:out value="${inscripcion.estudiante}"></c:out></td>
<td><c:out value="${inscripcion.curso}"></c:out></td>
<td><c:out value="${inscripcion.diacurso}"></c:out></td>
<td><c:out value="${inscripcion.horinicurso}"></c:out></td>
<td><c:out value="${inscripcion.horfincurso}"></c:out></td>
<td><c:out value="${inscripcion.fechainscrip}"></c:out></td>
<td>
  <a href="ControladorInscripcion?accion=EliminarInscripcion&idest=${inscripcion.idestudiante}&idcur=${inscripcion.idcurso}" class="btn btn-danger btn-sm">Eliminar Inscripción</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<br>
</div>
</div>

<script src="jquery/jquery-3.3.1.min.js"></script>
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