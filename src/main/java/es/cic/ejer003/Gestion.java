package es.cic.ejer003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Gestion {

	private Formacion formacion;
	
	public Gestion() {
		formacion = new Formacion();
		/*File file = new File("Formacion"+formacion.getAnho()+".csv");
		if(file.exists()){
			BufferedReader bufferedReader=null;
			try{
				bufferedReader = new BufferedReader(new FileReader(file));
				String linea = bufferedReader.readLine();
				while(linea !=null){
					String[] campos = linea.split(",");
					Alumno alumno = new Alumno();
					alumno.setNombre(campos[0]);
					alumno.setApellido1(campos[1]);
					alumno.setApellido2(campos[2]);
					formacion.getAlumnos().add(alumno);
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}*/
	}
	
	public void addAlumno(Alumno alumno) {
		formacion.getAlumnos().add(alumno);
	}
	
	public void editarAlumno(Alumno alumno, Alumno alumnoEditado) {
		for(Alumno a: formacion.getAlumnos()) {
			if(a.getNombre().equals(alumno.getNombre()) && a.getApellido1().equals(alumno.getApellido1()) && a.getApellido2().equals(alumno.getApellido2())) {
				a.setNombre(alumnoEditado.getNombre());
				a.setApellido1(alumnoEditado.getApellido1());
				a.setApellido2(alumnoEditado.getApellido2());
			}
		}
	}
	
	public void EliminarAlumno(String nombre,String ape1,String ape2) {
		for(Alumno a: formacion.getAlumnos()) { 
			if(a.getNombre().equals(nombre) && a.getApellido1().equals(ape1)&& a.getApellido2().equals(ape2)) {
				formacion.getAlumnos().remove(a);
				return;
			}
		}
	}
	public Alumno getAlumno(String nombre,String ape1,String ape2) {
		for(Alumno a : formacion.getAlumnos()) {
			if(a.getNombre().equals(nombre) && a.getApellido1().equals(ape1)&& a.getApellido2().equals(ape2)) {
				return a;
			}
		}
		return null;
	}
	
	public void GuardarFormacion() {
		try {
			File file = new File("Formacion"+formacion.getAnho()+".csv");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Alumno a : formacion.getAlumnos()) {
				bw.write(a.getNombre());
				bw.write(","+a.getApellido1());
				bw.write(","+a.getApellido2());
				bw.newLine();
			}
			bw.close();
			fw.close();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public Formacion getFormacion() {
		return formacion;
	}
}
