package proyecto.pem.mygym.category.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import proyecto.pem.mygym.AppMediador;
import proyecto.pem.mygym.R;
import proyecto.pem.mygym.category.presenter.ICategoryPresenter;

public class CategoryView extends AppCompatActivity implements ICategoryView,
        FragmentMasterEjercicios.EscuchaFragmento {

    private AppMediador appMediador;
    private ICategoryPresenter presenterCategory;
    private FragmentMasterEjercicios fragmentMasterEjercicios;
    private String[] lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);
        appMediador = (AppMediador) this.getApplication();
        presenterCategory = appMediador.getPresenterCategory();
        appMediador.setViewCategory(this);
        lista = new String[60];
        if (findViewById(R.id.contenedorDeFragmentos) != null) {
            // se crea el fragmento maestro y se anade al contenedor de fragmentos
            fragmentMasterEjercicios = new FragmentMasterEjercicios();
            getSupportFragmentManager().beginTransaction().add(R.id.contenedorDeFragmentos, fragmentMasterEjercicios).commit();
        }

    }


    @Override
    protected void onStart() {
        super.onStart();
        // Solicita al presentador que recupere los datos desde el modelo.
        presenterCategory.obtenerDatos();

    }


    @SuppressLint("RestrictedApi")
    @Override
    public void alSeleccionarItem(int posicion) {
        appMediador.setCategoria(lista[posicion]);
        toEjercicios();

    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onBackPressed() { // este metodo es para del detalle al maestro, y del maestro al menu
        super.onBackPressed();
        presenterCategory.obtenerDatos();
    }


    // método actualizarMaestro(Object[] datos) que actualiza la lista maestro con los datos recibidos por parámetros.
    @Override
    public void actualizarMaestro(Object[] datos) {
        // Dentro del método actualizarMaestro(Object[] datos), se crea la lista maestro con los nombres
        // de los ejercicios que entran por parámetros.
        fragmentMasterEjercicios.crearLista((String[]) datos);
        lista = (String[]) datos;
    }

    @Override
    public void toEjercicios() {
        Intent intent = new Intent(getApplicationContext(), proyecto.pem.mygym.ejercicios.view.EjerciciosView.class);
        startActivity(intent);
    }


}
