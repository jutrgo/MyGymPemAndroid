package proyecto.pem.mygym.category.model;

import android.os.Bundle;

import proyecto.pem.mygym.AppMediador;

public class CategoryModel implements ICategoryModel {

    private static CategoryModel singleton = null;
    private ConjuntoDeCategory conjuntoDeCategory;
    private AppMediador appMediador;

    private CategoryModel() {
        appMediador = AppMediador.getInstance();
        conjuntoDeCategory = ConjuntoDeCategory.getInstance();
    }

    public static CategoryModel getInstance() {
        if (singleton == null)
            singleton = new CategoryModel();
        return singleton;
    }


    @Override
    public void obtenerDatos() {
        Bundle extras = new Bundle();
        extras.putSerializable(AppMediador.CLAVE_LISTA_ITEM, conjuntoDeCategory.getListaDeCategory());
        appMediador.sendBroadcast(AppMediador.AVISO_DATOS_LISTOS, extras);
    }

}

