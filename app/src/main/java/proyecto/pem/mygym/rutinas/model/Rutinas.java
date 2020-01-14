package proyecto.pem.mygym.rutinas.model;

import java.util.ArrayList;

import proyecto.pem.mygym.category.model.ItemCategory;

public class Rutinas {

	private String categoria;
	private String ejercicio;
	private String series;
	private String repeticiones;
	private String tiempo;
	private String observaciones;
	private String id;



	public Rutinas(String categoria, String ejercicio, String series, String repeticiones, String tiempo, String observaciones, String id) {
		this.categoria = categoria;
		this.ejercicio = ejercicio;
		this.series = series;
		this.repeticiones = repeticiones;
		this.tiempo = tiempo;
		this.observaciones = observaciones;
		this.id = id;
	}
	public Rutinas(){
		this("", "", "", "", "", "","");
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(String ejercicio) {
		this.ejercicio = ejercicio;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(String repeticiones) {
		this.repeticiones = repeticiones;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}






}



