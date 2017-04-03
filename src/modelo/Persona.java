package modelo;

import java.util.Date;

import control.Humano;

public class Persona implements Humano, Comparable {

	private String nif;
	@Override
	public String toString() {
		return nif;
	}

	private String nombre;
	private char sexo;
	private int fecha;

	public Persona(String nif, String nombre, char sexo, int fecha) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.sexo = sexo;
		this.fecha = fecha;
	}

	public Persona() {
		super();
		this.nif = "123456789K";
		this.nombre = "anonimo";
		this.sexo = 'M';
		this.fecha = 20000101;
		// TODO Auto-generated constructor stub
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public String getNif() {
		return nif;
	}

	public String getNombre() {
		return nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public int getFecha() {
		return fecha;
	}

	@Override
	public void caminar(int numPasos) {
		// TODO Auto-generated method stub
		System.out.println("Caminando " + numPasos + " pasos");
	}

	@Override
	public int dormir(int numHoras) {
		// TODO Auto-generated method stub
		return numHoras;
	}

	/*
	 * @Override public int compareTo(Object o) { Persona p = (Persona) o;
	 * return this.nombre.compareTo(p.getNombre());
	 * 
	 * }
	 */

	@Override
	public int compareTo(Object o) { // por fechaNacimiento (int)
		Persona p = (Persona) o;
		if (this.fecha > p.getFecha())
			return 1;
		else if (this.fecha < p.getFecha())
			return -1;
		else
			return 0;
	}
}
