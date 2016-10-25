package modelo;

import java.util.Date;

public class Intento {
	private int numero;
	private Date fechaHora;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	public Intento(int numero, Date fechaHora) {
		super();
		this.numero = numero;
		this.fechaHora = fechaHora;
	}
}
