package proyecto.pem.mygym.category.presenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

import proyecto.pem.mygym.AppMediador;
import proyecto.pem.mygym.category.model.CategoryModel;
import proyecto.pem.mygym.category.model.ICategoryModel;
import proyecto.pem.mygym.category.model.ItemCategory;
import proyecto.pem.mygym.ejercicios.model.EjerciciosModel;
import proyecto.pem.mygym.ejercicios.model.IEjerciciosModel;
import proyecto.pem.mygym.ejercicios.model.ItemEjercicios;

public class CategoryPresenter implements ICategoryPresenter {

    private AppMediador appMediador;
    private ICategoryModel modelo;


    private BroadcastReceiver receptorAvisos = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(AppMediador.AVISO_DATOS_LISTOS)) {
                ArrayList<ItemCategory> listaCategory = (ArrayList<ItemCategory>) intent.getSerializableExtra(AppMediador.CLAVE_LISTA_ITEM);
                String[] datos = new String[listaCategory.size()];
                for (int i = 0; i < listaCategory.size(); i++) {
                    datos[i] = listaCategory.get(i).getCategoria();
                }
                appMediador.getViewCategory().actualizarMaestro(datos);
            }
            appMediador.unRegisterReceiver(this);
        }
    };

    public CategoryPresenter() {
        appMediador = AppMediador.getInstance();
        modelo = CategoryModel.getInstance();
    }


    // obtenerDatos() que registra el receptor para recibir notificaciones y solicita al modelo que recupere los datos de la lista maestro.
    @Override
    public void obtenerDatos() {
        appMediador.registerReceiver(receptorAvisos, AppMediador.AVISO_DATOS_LISTOS);
        modelo.obtenerDatos();

    }

}
