package modelo;

import java.util.Date;

public class Estudiante extends Persona {
	private int grupo;

	public Estudiante(String nif, String nombre, char sexo, Date fecha, int grupo) {
		super(nif, nombre, sexo, fecha);
		this.grupo = grupo;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

}
