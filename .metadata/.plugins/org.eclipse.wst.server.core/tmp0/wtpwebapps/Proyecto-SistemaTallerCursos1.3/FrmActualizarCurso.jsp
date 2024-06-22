<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actualizar Curso - Taller de cursos de verano</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

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

</head>
<body>
<%@include file="template/menu.jsp"%>
<br>

<h2 align="center">ACTUALIZAR CURSO</h2>
<br>
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-8">
      <div class="card">
        <div class="card-body">
          <form id="form-actualizar" action="ControladorCurso" method="post">
            
              <div class="form-group">
                <label for="nomcurso">Curso</label>
                  <input type="text" pattern="[a-zA-Z][0-9]?+" value='<c:out value="${curso}"></c:out>' class="form-control" placeholder="curso" name="nomcurso" title="Ingresa un dato válido" required>              
              </div>
              <div class="form-group">
              <label for="descurso">Descripción</label>
                  <input type="text" pattern="[a-zA-Z][0-9]?+" value='<c:out value="${descrip}"></c:out>' class="form-control" placeholder="descripcion" name="descurso" title="Ingresa un dato válido" required>
                </div>
              
              <div class="form-group">
  				<label for="diacurso">Día</label>
  					<select class="custom-select" name="diacurso" style="font-family: Arial, sans-serif;" title="Ingresa un dato válido" required>
    				<option value="" disabled>Seleccionar Día</option>
    				<c:forEach var="diasel" items="${dias}">
      				<option value="<c:out value='${diasel}'/>" <c:if test="${diasel eq dia}">selected</c:if>><c:out value='${diasel}'/></option>
    				</c:forEach>
 					 </select>
				</div>
                <div class="form-row">
              	<div class="form-group col-md-6">
                <label for="horinicurso">Hora de inicio</label>
                      <select class="custom-select" name="horinicurso" style="font-family: Arial, sans-serif;" title="Ingresa un dato válido" required>
                        <option value="" disabled>Seleccionar Hora</option>
                        <c:forEach var="inisel" items="${inicio}">
                          <option value="<c:out value='${inisel}'/>" <c:if test="${inisel eq horini}">selected</c:if>><c:out value='${inisel}'/></option>
                        </c:forEach>
                      </select>
                    </div>
                    
              		<div class="form-group col-md-6">
              		<label for="horfincurso">Hora de fin</label>
                      <select class="custom-select" name="horfincurso" style="font-family: Arial, sans-serif;" title="Ingresa un dato válido" required>
                        <option value="" disabled>Seleccionar Hora</option>
                        <c:forEach var="finsel" items="${fin}">
                          <option value="<c:out value='${finsel}'/>" <c:if test="${finsel eq horfin}">selected</c:if>><c:out value='${finsel}'/></option>
                        </c:forEach>
                      </select>
                    </div>
                  </div>
                
              <div class="form-group">
              <label for="vaccurso">Vacantes</label>
                  <input type="text" pattern="[0-9]{1,4}" value='<c:out value="${vacantes}"></c:out>' class="form-control" placeholder="vacantes" name="vaccurso" title="Ingresa un dato válido" required>
                </div>
              <div>
                  <input type="hidden" value='<c:out value="${id}"></c:out>' name="idcurso">
               </div>

            
            <div class="text-center">
              <input type="submit" value="Actualizar" class="btn btn-secondary btn-lg">
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