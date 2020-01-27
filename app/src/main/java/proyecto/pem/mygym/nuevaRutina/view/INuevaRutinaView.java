package proyecto.pem.mygym.nuevaRutina.view;

public interface INuevaRutinaView {
    String getCategoria();
    String getEjercicio();
    String getSeries();
    String getRepeticiones();
    String getTiempo();
    String getObservaciones();

    void toRutinas();

}
