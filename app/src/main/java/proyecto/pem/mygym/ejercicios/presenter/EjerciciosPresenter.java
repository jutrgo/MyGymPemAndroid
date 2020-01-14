package proyecto.pem.mygym.ejercicios.presenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

import proyecto.pem.mygym.ejercicios.model.IEjerciciosModel;
import proyecto.pem.mygym.ejercicios.model.ItemEjercicios;
import proyecto.pem.mygym.ejercicios.model.EjerciciosModel;
import proyecto.pem.mygym.AppMediador;

public class EjerciciosPresenter implements IEjerciciosPresenter {

    private AppMediador appMediador;

    private IEjerciciosModel modelo;

    // declaracion e implementacion receptor broadcast que espera por la notificacion del modelo.
    // El modelo notificara cuando los datos de los telefonos a notificar estan disponibles.
    private BroadcastReceiver receptorAvisos = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(AppMediador.AVISO_DATOS_LISTOS)) {
                ArrayList<ItemEjercicios> listaEjercicios = (ArrayList<ItemEjercicios>) intent.getSerializableExtra(AppMediador.CLAVE_LISTA_ITEM);
                String[] datos = new String[listaEjercicios.size()];
                for (int i = 0; i < listaEjercicios.size(); i++) {
                    datos[i] = listaEjercicios.get(i).getNombreEjercicio();
                }
                appMediador.getViewEjercicios().actualizarMaestro(datos);
            } else if (intent.getAction().equals(AppMediador.AVISO_DETALLE_LISTO)) {
                String[] datosDetalle = intent.getStringArrayExtra(AppMediador.CLAVE_DETALLE_ITEM);
                appMediador.getViewEjercicios().actualizarDetalle(datosDetalle);
            }
            appMediador.unRegisterReceiver(this);
        }
    };

    // constructor que crea el modelo.
    public EjerciciosPresenter() {
        appMediador = AppMediador.getInstance();
        modelo = EjerciciosModel.getInstance();
    }


    //  metodo obtenerDatos() que registra el receptor para recibir notificaciones y
    // solicita al modelo que recupere los datos de la lista maestro.
    @Override
    public void obtenerDatos(String categoria) {
        appMediador.registerReceiver(receptorAvisos, AppMediador.AVISO_DATOS_LISTOS);
        modelo.obtenerDatos(categoria);

    }

    // metodo obtenerDetalle(int posicion, String detalle) que registra el receptor para recibir
    // notificaciones y solicita al modelo que recupere los datos de la lista detalle para un ejericico dada su posicion y su categoria.
    @Override
    public void obtenerDetalle(int posicion, String categoria) {
        appMediador.registerReceiver(receptorAvisos, AppMediador.AVISO_DETALLE_LISTO);
        modelo.obtenerDetalle(posicion, categoria);
    }


}
