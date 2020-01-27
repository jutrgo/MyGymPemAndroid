package proyecto.pem.mygym.ejercicios.model;

import android.os.Bundle;

import proyecto.pem.mygym.AppMediador;

public class EjerciciosModel implements IEjerciciosModel {

    private static EjerciciosModel singleton = null;
    private ConjuntoDeEjercicios conjuntoDeEjercicios;
    private AppMediador appMediador;

    private EjerciciosModel() {
        appMediador = AppMediador.getInstance();
        conjuntoDeEjercicios = ConjuntoDeEjercicios.getInstance();
    }

    public static EjerciciosModel getInstance() {
        if (singleton == null)
            singleton = new EjerciciosModel();
        return singleton;
    }


    // metodo obtenerDatos() que recupera los datos de la lista de ejercicios del
    // conjunto de ejercicios y envia una notificacion del tipo AVISO_DATOS_LISTOS al presentador.
    @Override
    public void obtenerDatos(String categoria) {
        Bundle extras = new Bundle();
        extras.putSerializable(AppMediador.CLAVE_LISTA_ITEM, conjuntoDeEjercicios.getListaDeEjercicios(categoria));
        appMediador.sendBroadcast(AppMediador.AVISO_DATOS_LISTOS, extras);
    }

    // metodo obtenerDetalle(int posicion) que recupera los datos del detalle de un ejercicio del
    // conjunto de ejercicios y envia una notificacion del tipo AVISO_DETALLE_LISTO al presentador.
    @Override
    public void obtenerDetalle(int posicion, String categoria) {
        ItemEjercicios ejercicios = conjuntoDeEjercicios.getListaDeEjercicios(categoria).get(posicion);
        String[] datos = new String[3];
        datos[0] = ejercicios.getIdEjercicio();
        datos[1] = ejercicios.getNombreEjercicio();
        datos[2] = ejercicios.getDescripcion();


        Bundle extras = new Bundle();
        extras.putStringArray(AppMediador.CLAVE_DETALLE_ITEM, datos);
        appMediador.sendBroadcast(AppMediador.AVISO_DETALLE_LISTO, extras);
    }

}

