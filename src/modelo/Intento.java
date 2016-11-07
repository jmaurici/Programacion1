package modelo;

import java.util.Date;

public class Intento {
	
	private int num;
	private Date fechaHora;

	public Intento(int veces, Date fechaHora) {
		super();
		this.num = veces;
		this.fechaHora = fechaHora;
	}
	public int getVeces() {
		return num;
	}
	public void setVeces(int veces) {
		this.num = veces;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	
}
