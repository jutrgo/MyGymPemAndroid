package proyecto.pem.mygym.nuevaRutina.view;

public interface INuevaRutinaView {
	
	// TODO Anadir el metodo actualizarMaestro(Object[] datos) que actualiza la lista maestro con los datos

    String getCategoria();
    String getEjercicio();
    String getSeries();
    String getRepeticiones();
    String getTiempo();
    String getObservaciones();


    void toRutinas();

}
