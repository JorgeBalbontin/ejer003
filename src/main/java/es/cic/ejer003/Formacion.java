package es.cic.ejer003;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Formacion {

	private int anho;
	private List<Alumno> alumnos;
	
	
	public Formacion() {
		anho = LocalDate.now().getYear();
		alumnos = new ArrayList<Alumno>();
	}


	public int getAnho() {
		return anho;
	}


	public void setAnho(int anho) {
		this.anho = anho;
	}


	public List<Alumno> getAlumnos() {
		return alumnos;
	}


	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	
}
