package proyecto.pem.mygym.rutinas.model;

public interface IRutinasModel {
	
    void obtenerDatos();

    void obtenerDetalle(int posicion);

    void agregarRutina(String[] datos);

    void elimarDatos();
}


