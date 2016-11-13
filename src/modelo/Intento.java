package modelo;

import java.util.Date;

public class Intento {
	private int numero;
	private Date fechaHora;
	private String respuesta;

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

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

	@Override
	public String toString() {
		return numero + ","+ fechaHora + " ,"+ respuesta+"\n";
	}
}
