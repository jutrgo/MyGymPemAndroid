package proyecto.pem.mygym.ejercicios.view;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import proyecto.pem.mygym.ejercicios.presenter.IEjerciciosPresenter;
import proyecto.pem.mygym.AppMediador;
import proyecto.pem.mygym.R;

public class EjerciciosView extends AppCompatActivity implements IEjerciciosView,
        FragmentMasterEjercicios.EscuchaFragmento {

    private AppMediador appMediador;
    private IEjerciciosPresenter presenterEjercicios;
    private FragmentMasterEjercicios fragmentMasterEjercicios;
    private FragmentDetailEjercicios fragmentDetailEjercicios;
    private String categoria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);
        appMediador = (AppMediador) this.getApplication();
        presenterEjercicios = appMediador.getPresenterEjercicios();
        appMediador.setViewEjercicios(this);
        categoria = appMediador.getCategoria();
        Log.d("categoria", categoria);
        // Se comprueba si la actividad esta usando una version de layout con un contenedor de fragmentos
        // de tipo FrameLayout (si es asi, es un smartphone y no permite mas de un fragmento en pantalla),
        // por tanto, solo se anade el primero
        if (findViewById(R.id.contenedorDeFragmentos) != null) {
            // se crea el fragmento maestro y se anade al contenedor de fragmentos
            fragmentMasterEjercicios = new FragmentMasterEjercicios();
            getSupportFragmentManager().beginTransaction().add(R.id.contenedorDeFragmentos, fragmentMasterEjercicios).commit();
        }
        String hola = getPackageName();
        Log.d("Holaaaaa", hola);

    }


    @Override
    protected void onStart() {
        super.onStart();
        // Solicita al presentador que recupere los datos desde el modelo.
        presenterEjercicios.obtenerDatos(categoria);

    }


    @SuppressLint("RestrictedApi")
    @Override
    public void alSeleccionarItem(int posicion) {
        // Si no hay fragmento detalle, se crea la vista detalle (esto ocurre si es panel unico)
        if (fragmentDetailEjercicios == null)
            fragmentDetailEjercicios = new FragmentDetailEjercicios();

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
        // Solicita al presentador que trate el item seleccionado.
        presenterEjercicios.obtenerDetalle(posicion, categoria);

    }


    // Redefinicion del metodo onBackPressed para que si se tiene un dispositivo de panel unico, y el boton
    // flotante no esta visible (esta el fragmento detalle en pantalla), reemplace el fragmento detalle por el
    // fragmento maestro. En cualquier otro caso, la actividad debe finalizar (porque se quiere salir de ella)

    @SuppressLint("RestrictedApi")
    @Override
    public void onBackPressed() { // este metodo es para del datalle al maestro, y del maestro al menu
        super.onBackPressed();
        presenterEjercicios.obtenerDatos(categoria);
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


    // método actualizarMaestro(Object[] datos) que actualiza la lista maestro con los datos
    // recibidos por parámetros. En cada entrada del vector, está el nombre de un ejericio.
    @Override
    public void actualizarMaestro(Object[] datos) {
        fragmentMasterEjercicios.crearLista((String[]) datos);
        if (findViewById(R.id.contenedorDeFragmentos) == null) {
            presenterEjercicios.obtenerDetalle(0, categoria);
        }


    }

    @Override
    public void actualizarDetalle(Object[] datos) {
        fragmentDetailEjercicios.actualizarImagen((String) datos[0]);
        fragmentDetailEjercicios.actualizarNombre((String) datos[1]);
        fragmentDetailEjercicios.actualizarDescripcion((String) datos[2]);
    }


}
