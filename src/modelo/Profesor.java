package modelo;

import java.util.Date;

public class Profesor extends Persona {
	private  int depto;

	public Profesor(String nif, String nombre, char sexo, int fecha, int depto) {
		super(nif, nombre, sexo, fecha);
		this.depto = depto;
	}

	public int getDepto() {
		return depto;
	}

	public void setDepto(int depto) {
		this.depto = depto;
	}

}
