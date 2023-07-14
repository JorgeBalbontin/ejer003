package ejer003;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.cic.ejer003.Alumno;
import es.cic.ejer003.Gestion;

class GestionTest {

	private Gestion gestion;
	
	@BeforeEach
	void setUp() throws Exception {
		gestion= new Gestion();
		Alumno alumno = new Alumno();
		alumno.setNombre("Alumno1");
		alumno.setApellido1("Apellido1");
		alumno.setApellido2("Apellido2");
		gestion.addAlumno(alumno);
	}

	@Test
	void testAddAlumno() {
		Alumno alumno = new Alumno();
		alumno.setNombre("Alumno2");
		alumno.setApellido1("Apellido1");
		alumno.setApellido2("Apellido2");
		gestion.addAlumno(alumno);
		List<Alumno> lista = gestion.getFormacion().getAlumnos();
		assertTrue(lista.size()>0);
	}

	@Test
	void testEditarAlumno() {
		Alumno alumno = new Alumno();
		alumno.setNombre("Alumno1");
		alumno.setApellido1("Apellido1");
		alumno.setApellido2("Apellido2");
		Alumno alumnoEditado = new Alumno();
		alumnoEditado.setNombre("editado");
		alumnoEditado.setApellido1("editado");
		alumnoEditado.setApellido2("editado");
		gestion.editarAlumno(alumno, alumnoEditado);
		alumno=null;
		alumno = gestion.getAlumno("editado", "editado", "editado");
		assertTrue(alumno!=null);
	}

	@Test
	void testEliminarAlumno() {
		gestion.EliminarAlumno("Alumno1", "Apellido1", "Apellido2");
		assertTrue(gestion.getFormacion().getAlumnos().size()==0);
	}

	@Test
	void testGetAlumno() {
		Alumno alumno =gestion.getAlumno("Alumno1", "Apellido1", "Apellido2");
		assertTrue(alumno!=null);
	}
	
	@Test
	void testGuardarFormacion() {
		gestion.GuardarFormacion();
	}

}
