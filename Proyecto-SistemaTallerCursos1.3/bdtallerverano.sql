create database bdtallerverano;

use bdtallerverano;

/*----------TABLAS------------*/
create table tbl_usuario
(
	idusuario int primary key auto_increment,
    nomusuario varchar(20) not null,
    password varchar(20) not null
);

insert into tbl_usuario(nomusuario,password) values('admin','123456');

create table tbl_docente
(
	iddocente char(4) primary key,
    dnidocente char(8) not null,
    nomdocente varchar(50) not null,
    apedocente varchar(50) not null,
    cordocente varchar(50) not null,
    teldocente varchar(11) not null,
    estadodocente char(2) default 'no'
);

create table tbl_curso
(
	idcurso char(4) primary key,
    nomcurso varchar(20) not null,
    descurso varchar(50) not null,
    diacurso varchar(20) not null,
    horinicurso char(5) not null,
    horfincurso char(5) not null,
    vaccurso int not null,
    estadocurso char(2) default 'no'
);

create table tbl_docentecurso
(
	iddocente char(4),
    idcurso varchar(4),
    foreign key(iddocente) references tbl_docente(iddocente),
    foreign key(idcurso) references tbl_curso(idcurso)
);

create table tbl_estudiante
(
	idestudiante char(10) primary key,
    dniestudiante char(8) not null,
    nomestudiante varchar(50) not null,
    apeestudiante varchar(50) not null,
    corestudiante varchar(50) not null,
    telestudiante varchar(11) not null,
    estadoestudiante char(2) default 'no'
);

create table tbl_inscripcion
(
	numinscrip int primary key auto_increment,
    idestudiante char(10) not null,
    idcurso varchar(4) not null,
    fecinscrip date not null,
	foreign key(idestudiante) references tbl_estudiante(idestudiante),
    foreign key(idcurso) references tbl_curso(idcurso)
);

/*----------PROCEDIMIENTOS CRUD------------*/

DELIMITER //
CREATE PROCEDURE SP_REGISTRAR_DOCENTE(dnidoc char(8),nomdoc varchar(50),apedoc varchar(50),
										cordoc varchar(50),teldoc varchar(11))
BEGIN
	INSERT INTO tbl_docente (iddocente,dnidocente, nomdocente, apedocente, cordocente, teldocente)
	SELECT CONCAT('D', LPAD(COALESCE(MAX(SUBSTRING(iddocente, 2)) + 1, 1), 3, '0')), dnidoc, nomdoc, apedoc, cordoc, teldoc
	FROM tbl_docente
	WHERE iddocente LIKE 'D%';
	END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_ACTUALIZAR_DOCENTE(iddoc char(4),dnidoc char(8),nomdoc varchar(50),apedoc varchar(50),
										cordoc varchar(50),teldoc varchar(11))
BEGIN
	UPDATE TBL_DOCENTE SET dnidocente=dnidoc,nomdocente=nomdoc,apedocente=apedoc,cordocente=cordoc,
    teldocente=teldoc 
    where iddocente=iddoc;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_ELIMINAR_DOCENTE(iddoc char(4))
BEGIN
	delete from tbl_docente
    where iddocente=iddoc;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_REGISTRAR_CURSO(nomcur varchar(20),descur varchar(50),diacur varchar(20),hinicur char(5),
										hfincur char(5),vaccur int)
BEGIN
	INSERT INTO tbl_curso (idcurso,nomcurso,descurso,diacurso,horinicurso,horfincurso,vaccurso)
	SELECT CONCAT('C', LPAD(COALESCE(MAX(SUBSTRING(idcurso, 2)) + 1, 1), 3, '0')), nomcur, descur, diacur, hinicur, hfincur,
    vaccur
	FROM tbl_curso
	WHERE idcurso LIKE 'C%';    
	END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_ACTUALIZAR_CURSO(idcur char(4),nomcur varchar(20),descur varchar(50),diacur varchar(20),hinicur char(5),
										hfincur char(5),vaccur int)
BEGIN
	update tbl_curso set nomcurso=nomcur,descurso=descur,diacurso=diacur,horinicurso=hinicur,horfincurso=hfincur,vaccurso=vaccur
    where idcurso=idcur;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_ELIMINAR_CURSO(idcur char(4))
BEGIN
	delete from tbl_curso
    where idcurso=idcur;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_REGISTRAR_ESTUDIANTE(dniest char(8),nomest varchar(50),apeest varchar(50),
										corest varchar(50),telest varchar(11))
BEGIN
	INSERT INTO tbl_estudiante (idestudiante,dniestudiante,nomestudiante,apeestudiante,corestudiante,telestudiante)
	SELECT CONCAT('E', LPAD(COALESCE(MAX(SUBSTRING(idestudiante, 2)) + 1, 1), 9, '0')), dniest, nomest, apeest, corest,
	telest
	FROM tbl_estudiante
	WHERE idestudiante LIKE 'E%';
	END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_ACTUALIZAR_ESTUDIANTE(idest char(10),dniest char(8),nomest varchar(50),apeest varchar(50),corest varchar(50),
										telest varchar(11))
BEGIN
	update tbl_estudiante set dniestudiante=dniest,nomestudiante=nomest,apeestudiante=apeest,corestudiante=corest,telestudiante=telest
    where idestudiante=idest;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_ELIMINAR_ESTUDIANTE(idest char(10))
BEGIN
	delete from tbl_estudiante
    where idestudiante=idest;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_ASIGNAR_DOCENTE_CURSO(iddoc char(4),idcur varchar(4))
BEGIN
	INSERT INTO tbl_docentecurso (iddocente,idcurso)
	values (iddoc, idcur);
    
    update tbl_docente set estadodocente='si'
    where iddocente=iddoc;
    
    update tbl_curso set estadocurso='si'
    where idcurso=idcur;
	END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_GENERAR_INSCRIPCION(idest char(10),idcur char(4),fecins date)
BEGIN
	INSERT INTO tbl_inscripcion (idestudiante,idcurso,fecinscrip)
	values (idest,idcur,fecins);
    
    update tbl_estudiante set estadoestudiante = 'si'
    where idestudiante=idest;
    
    update tbl_curso set vaccurso=vaccurso-1
    where idcurso=idcur and estadocurso='si';
	END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_LISTAR_DOCENTE_GENERAL()
BEGIN
	select * from tbl_docente;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_BUSCAR_DOCENTE(busca varchar(20))
BEGIN
	select * from tbl_docente
    where dnidocente like concat(busca,'%');
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_LISTAR_CURSO_GENERAL()
BEGIN
	select * from tbl_curso;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_BUSCAR_CURSO(busca varchar(20))
BEGIN
	select * from tbl_curso
    where nomcurso like concat(busca,'%');
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_BUSCAR_CURSOID(busca varchar(20))
BEGIN
	select * from tbl_curso
    where idcurso like concat(busca,'%');
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_LISTAR_ESTUDIANTE_GENERAL()
BEGIN
	select * from tbl_estudiante;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_BUSCAR_ESTUDIANTE(busca varchar(20))
BEGIN
	select * from tbl_estudiante
    where dniestudiante like concat(busca,'%');
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_LISTAR_DOCENTE_CURSO_ASIGNADO()
BEGIN
	select d.dnidocente as Dni,concat(d.apedocente,', ',d.nomdocente) as Docente,c.nomcurso as Curso,c.diacurso as Dia,c.horinicurso as Inicio,c.horfincurso as Fin
    from tbl_docente as d
    inner join tbl_docentecurso as dc
    on d.iddocente=dc.iddocente
    inner join tbl_curso as c
    on dc.idcurso=c.idcurso;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_LISTAR_INSCRIPCION()
BEGIN
	select i.numinscrip as Numero,e.dniestudiante as Dni,concat(e.apeestudiante,', ',e.nomestudiante) as Estudiante, c.nomcurso as Curso,
    c.diacurso as Dia,c.horinicurso as Inicio,c.horfincurso as Fin,i.fecinscrip as Fecha
    from tbl_inscripcion as i
    inner join tbl_estudiante as e
    on i.idestudiante=e.idestudiante
    inner join tbl_curso as c
    on i.idcurso=c.idcurso;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_BUSCAR_INSCRIPCION(busca varchar(20))
BEGIN
	select i.numinscrip as Numero,e.dniestudiante as Dni,concat(e.apeestudiante,', ',e.nomestudiante) as Estudiante, c.nomcurso as Curso,
    c.diacurso as Dia,c.horinicurso as Inicio,c.horfincurso as Fin,i.fecinscrip as Fecha
    from tbl_inscripcion as i
    inner join tbl_estudiante as e
    on i.idestudiante=e.idestudiante
    inner join tbl_curso as c
    on i.idcurso=c.idcurso
    where e.dniestudiante like concat(busca,'%');
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_BUSCAR_INSCRIPCION_ID(busca varchar(20))
BEGIN
	select i.numinscrip as Numero,e.dniestudiante as Dni,concat(e.apeestudiante,', ',e.nomestudiante) as Estudiante, c.nomcurso as Curso,
    c.diacurso as Dia,c.horinicurso as Inicio,c.horfincurso as Fin,i.fecinscrip as Fecha
    from tbl_inscripcion as i
    inner join tbl_estudiante as e
    on i.idestudiante=e.idestudiante
    inner join tbl_curso as c
    on i.idcurso=c.idcurso
    where i.idestudiante like concat(busca,'%');
END //
DELIMITER ;