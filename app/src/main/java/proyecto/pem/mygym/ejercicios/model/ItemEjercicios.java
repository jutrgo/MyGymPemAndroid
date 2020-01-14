package proyecto.pem.mygym.ejercicios.model;

import java.io.Serializable;

public class ItemEjercicios implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -344029098860190065L;
	private String idEjercicio;
	private String nombreEjercicio;
	private String categoria;
	private String descripcion;

	public ItemEjercicios(String idEjercicio, String nombreEjercicio, String categoria, String descripcion) {
		super();
		this.idEjercicio = idEjercicio;
		this.nombreEjercicio = nombreEjercicio;
		this.categoria = categoria;
		this.descripcion = descripcion;
	}

	public String getIdEjercicio() {
		return idEjercicio;
	}

	public void setIdEjercicio(String idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	public String getNombreEjercicio() {
		return nombreEjercicio;
	}

	public void setNombreEjercicio(String nombreEjercicio) {
		this.nombreEjercicio = nombreEjercicio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}

