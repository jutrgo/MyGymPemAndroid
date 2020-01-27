package proyecto.pem.mygym.nuevaRutina.presenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import proyecto.pem.mygym.AppMediador;
import proyecto.pem.mygym.nuevaRutina.view.INuevaRutinaView;
import proyecto.pem.mygym.rutinas.model.IRutinasModel;
import proyecto.pem.mygym.rutinas.model.RutinasModel;

public class NuevaRutinaPresenter implements INuevaRutinaPresenter {

    private AppMediador appMediador;

    private IRutinasModel modelo;

    private BroadcastReceiver receptorAvisos = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(AppMediador.AVISO_AGREGAR_RUTINA)){
                appMediador.getViewNuevaRutina().toRutinas();

            }

            appMediador.unRegisterReceiver(this);
        }
    };


    public NuevaRutinaPresenter(){
        appMediador = AppMediador.getInstance();
        modelo = RutinasModel.getInstance();
    }


    @Override
    public void obtenerDatos(){

    }

    @Override
    public void obtenerDetalle(int posicion) {
        appMediador.registerReceiver(receptorAvisos, AppMediador.AVISO_DETALLE_LISTO);
        modelo.obtenerDetalle(posicion);
    }

    @Override
    public void toNuevaRutina() {
        appMediador.getViewHome().toMenu();
    }


    @Override
    public void guardarPresenter() {
        appMediador.registerReceiver(receptorAvisos, AppMediador.AVISO_AGREGAR_RUTINA);
        INuevaRutinaView vistaNuevaRutina = appMediador.getViewNuevaRutina();
        String[] datos = new String[6];
        datos[0] = vistaNuevaRutina.getCategoria();
        datos[1] = vistaNuevaRutina.getEjercicio();
        datos[2] = vistaNuevaRutina.getSeries();
        datos[3] = vistaNuevaRutina.getRepeticiones();
        datos[4] = vistaNuevaRutina.getTiempo();
        datos[5] = vistaNuevaRutina.getObservaciones();

        RutinasModel.getInstance().agregarRutina(datos);
        appMediador.registerReceiver(receptorAvisos, AppMediador.AVISO_AGREGAR_RUTINA);
    }
}
