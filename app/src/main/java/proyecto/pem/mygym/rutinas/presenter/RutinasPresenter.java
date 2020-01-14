package proyecto.pem.mygym.rutinas.presenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

import proyecto.pem.mygym.AppMediador;
import proyecto.pem.mygym.category.model.ItemCategory;
import proyecto.pem.mygym.rutinas.model.Rutinas;
import proyecto.pem.mygym.rutinas.model.RutinasModel;
import proyecto.pem.mygym.rutinas.model.IRutinasModel;

public class RutinasPresenter implements IRutinasPresenter {

    private AppMediador appMediador;

    private IRutinasModel modelo;

    private BroadcastReceiver receptorAvisos = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(AppMediador.AVISO_DATOS_RUTINAS)) {
                ArrayList<Rutinas> listaRutinas = (ArrayList<Rutinas>) intent.getSerializableExtra(AppMediador.CLAVE_LISTA_RUTINAS);
                String[] datos = new String[listaRutinas.size()];
                for (int i = 0; i < listaRutinas.size(); i++) {
                    datos[i] = listaRutinas.get(i).getEjercicio();
                }
                appMediador.getViewRutinas().actualizarMaestro(datos);
            } else if (intent.getAction().equals(AppMediador.AVISO_DETALLE_RUTINA)) {
                String[] datosDetalle = intent.getStringArrayExtra(AppMediador.CLAVE_DETALLE_RUTINA);
                appMediador.getViewRutinas().actualizarDetalle(datosDetalle);
            }


            appMediador.unRegisterReceiver(this);
        }
    };


    public RutinasPresenter() {
        appMediador = AppMediador.getInstance();
        modelo = RutinasModel.getInstance();
    }


    @Override
    public void obtenerDatos() {
        appMediador.registerReceiver(receptorAvisos, AppMediador.AVISO_DATOS_RUTINAS);
        modelo.obtenerDatos();

    }


    @Override
    public void obtenerDetalle(int posicion) {
        appMediador.registerReceiver(receptorAvisos, AppMediador.AVISO_DETALLE_RUTINA);
        modelo.obtenerDetalle(posicion);
    }

    @Override
    public void toNuevaRutina() {
        appMediador.getViewRutinas().toNuevaRutina();
    }

    @Override
    public void eliminarDatos() {
        modelo.elimarDatos();
    }


}
