package modelo;

import java.util.Date;

public class Persona {

	private String nif;
	private String nombre;
	private char sexo; 
	private Date fecha;
	
	public Persona(String nif, String nombre, char sexo, Date fecha) {
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
		this.fecha = new Date();
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

	public void setFecha(Date fecha) {
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

	public Date getFecha() {
		return fecha;
	}
}
