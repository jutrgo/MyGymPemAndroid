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
        // Se comprueba si la actividad esta usando una version de layout con un contenedor de fragmentos
        // de tipo FrameLayout (si es asi, es un smartphone y no permite mas de un fragmento en pantalla),
        // por tanto, solo se anade el primero
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
       /* // Si no hay fragmento detalle, se crea la vista detalle (esto ocurre si es panel unico)
        if (fragmentDetailEjercicios == null)
            fragmentDetailEjercicios = new FragmentDetailRutinas();

        if (findViewById(R.id.contenedorDeFragmentos) != null) {
            // si es de panel unico, se reemplaza, en el contenedor de fragmentos
            // el fragmento que esta visible por el de la vista detalle
            FragmentTransaction transaccion = getSupportFragmentManager().beginTransaction();
            transaccion.replace(R.id.contenedorDeFragmentos, fragmentDetailEjercicios);
            transaccion.addToBackStack(null);
            transaccion.commit();
            // Quita la visibilidad al boton flotante (para que no aparezca en el detalle)

            // realiza la transaccion
            getSupportFragmentManager().executePendingTransactions();
        }
        presenterCategory.obtenerDetalle(posicion);*/

        appMediador.setCategoria(lista[posicion]);
        toEjercicios();

    }


    // Redefinicion del metodo onBackPressed para que si se tiene un dispositivo de panel unico, y el boton
    // flotante no esta visible (esta el fragmento detalle en pantalla), reemplace el fragmento detalle por el
    // fragmento maestro. En cualquier otro caso, la actividad debe finalizar (porque se quiere salir de ella)

    @SuppressLint("RestrictedApi")
    @Override
    public void onBackPressed() { // este metodo es para del datalle al maestro, y del maestro al menu
        super.onBackPressed();
        presenterCategory.obtenerDatos();
    }

  /*  @SuppressLint("RestrictedApi")
    @Override
    public void onBackPressed(){
        if (findViewById(R.id.contenedorDeFragmentos)!=null){
        //es panel único
        //está en la vista del detalle
        FragmentTransaction transaccion = getSupportFragmentManager().beginTransaction();
        transaccion.replace(R.id.contenedorDeFragmentos, fragmentMasterEjercicios);
        transaccion.addToBackStack(null);
        transaccion.commit();
        presenterEjercicios.obtenerDatos();

    }else {
        //no es panel único
        finish();
    }*/


    // Añadir el método actualizarMaestro(Object[] datos) que actualiza la lista maestro con los datos
    // recibidos por parámetros.
    @Override
    public void actualizarMaestro(Object[] datos) {
        // Dentro del método actualizarMaestro(Object[] datos), crear la lista maestro con los nombres
        // de los ejericios que entran por parámetros.
        fragmentMasterEjercicios.crearLista((String[]) datos);
        lista = (String[]) datos;
    }

    @Override
    public void toEjercicios() {
        Intent intent = new Intent(getApplicationContext(), proyecto.pem.mygym.ejercicios.view.EjerciciosView.class);
        startActivity(intent);
    }


}
