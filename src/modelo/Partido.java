package modelo;

import java.util.Date;

public class Partido {
	private String eLocal;
	private String eVisitante;

	private int golesLocal;
	private int golesVisitante;
	private Date fecha;

	public Partido(String eLocal, String eVisitante, int golesLocal, int golesVisitante, Date fecha) {
		super();
		this.eLocal = eLocal;
		this.eVisitante = eVisitante;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.fecha = fecha;
	}
	public Partido() {
		super();
	}
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	

	public String geteLocal() {
		return eLocal;
	}

	public void seteLocal(String eLocal) {
		this.eLocal = eLocal;
	}

	public String geteVisitante() {
		return eVisitante;
	}

	public void seteVisitante(String eVisitante) {
		this.eVisitante = eVisitante;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}
}
