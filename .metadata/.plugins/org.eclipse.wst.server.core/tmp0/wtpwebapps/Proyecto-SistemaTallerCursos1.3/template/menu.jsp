
<nav class="navbar navbar-expand-lg navbar-light bg-info">
  
  
  

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="#"><i class="fas fa-home"></i> Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          <i class="fas fa-book"></i> Cursos
        </a>
        <div class="dropdown-menu">
          <!-- <a class="dropdown-item btn btn-hover" href="FrmRegistrarCurso.jsp"><i class="fas fa-address-book"></i> Registrar Cursos</a> -->
          <a class="dropdown-item" href="ControladorCurso?accion=Listado"><i class="fas fa-list"></i> Listado Cursos</a>
          <!-- <a class="dropdown-item" href="AsignarCurso.jsp"><i class="fas fa-folder-plus"></i> Asignar Cursos</a> -->
          <a class="dropdown-item" href="ControladorAsignatura?accion=Listado"><i class="fas fa-list"></i> Lista Cursos Asignados</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          <i class="fas fa-user-tie"></i> Docentes
        </a>
        <div class="dropdown-menu">
          <!-- <a class="dropdown-item" href="FrmRegistrarDocente.jsp"><i class="fas fa-user-plus"></i> Registrar Docentes</a> -->
          <a class="dropdown-item" href="ControladorDocente?accion=Listado"><i class="fas fa-list"></i> Listado Docentes</a>
         
        </div>
      </li>
      <li class="nav-item dropdown">
        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          <i class="fas fa-users"></i> Estudiantes
        </a>
        <div class="dropdown-menu">
          <!-- <a class="dropdown-item" href="FrmRegistrarEstudiante.jsp"><i class="fas fa-user-plus"></i> Registrar Estudiantes</a> -->
          <a class="dropdown-item" href="ControladorEstudiante?accion=Listado"><i class="fas fa-list"></i> Listado Estudiantes</a>
          
        </div>
      </li>
      <li class="nav-item dropdown">
        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          <i class="fas fa-address-card"></i> Inscripcion
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="ControladorInscripcion?accion=Listado"><i class="fab fa-readme"></i> Listado para Inscripcion</a>
          <a class="dropdown-item" href="ControladorInscripcion?accion=ListadoInscrito"><i class="fas fa-list"></i> Listado Inscripciones</a>
          
        </div>
      </li>
      
    </ul>
   <a href="Index.jsp" id="cerrarSesionBtn" class="btn btn-danger"><i class="fas fa-sign-out-alt"></i> Cerrar Sesion</a>
  </div>
</nav>

<script>
  document.getElementById("cerrarSesionBtn").addEventListener("click", function(event) {
    event.preventDefault(); // Evita que se realice la acción predeterminada del enlace

    // Muestra una ventana de confirmación
    Swal.fire({
      title: 'Confirmacion',
      text: 'Estas seguro de cerrar sesion?',
      icon: 'question',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, cerrar sesion',
      cancelButtonText: 'Cancelar'
    }).then((result) => {
      if (result.isConfirmed) {
        // Redirige al usuario a la página de cierre de sesión
        window.location.href = "Index.jsp";
      }
    });
  });
</script>
