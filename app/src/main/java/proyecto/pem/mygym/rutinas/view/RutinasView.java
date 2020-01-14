package proyecto.pem.mygym.rutinas.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import proyecto.pem.mygym.AppMediador;
import proyecto.pem.mygym.R;
import proyecto.pem.mygym.nuevaRutina.view.NuevaRutinaView;
import proyecto.pem.mygym.rutinas.presenter.IRutinasPresenter;

public class RutinasView extends AppCompatActivity implements IRutinasView,
        FragmentMasterRutinas.EscuchaFragmento {

    private AppMediador appMediador;
    private IRutinasPresenter presenterRutinas;
    private FragmentMasterRutinas fragmentMasterRutinas;
    private FragmentDetailRutinas fragmentDetailRutinas;
    private FloatingActionButton añadirRutina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutinas);
        appMediador = (AppMediador) this.getApplication();
        presenterRutinas = appMediador.getPresenterRutinas();
        appMediador.setViewRutinas(this);


        if (findViewById(R.id.contenedorDeFragmentos) != null) {
            // se crea el fragmento maestro y se anade al contenedor de fragmentos
            fragmentMasterRutinas = new FragmentMasterRutinas();
            getSupportFragmentManager().beginTransaction().add(R.id.contenedorDeFragmentos, fragmentMasterRutinas).commit();
        }
        String hola = getPackageName();
        Log.d("Holaaaaa", hola);

        añadirRutina = findViewById(R.id.fab);
        añadirRutina.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                presenterRutinas.toNuevaRutina();

            }

        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        // TODO Solicitar al presentador que recupere los datos desde el modelo.
        presenterRutinas.obtenerDatos();

    }


    @SuppressLint("RestrictedApi")
    @Override
    public void alSeleccionarItem(int posicion) {
        // Si no hay fragmento detalle, se crea la vista detalle (esto ocurre si es panel unico)
        if (fragmentDetailRutinas == null)
            fragmentDetailRutinas = new FragmentDetailRutinas();

        if (findViewById(R.id.contenedorDeFragmentos) != null) {
            // si es de panel unico, se reemplaza, en el contenedor de fragmentos
            // el fragmento que esta visible por el de la vista detalle
            FragmentTransaction transaccion = getSupportFragmentManager().beginTransaction();
            transaccion.replace(R.id.contenedorDeFragmentos, fragmentDetailRutinas);
            transaccion.addToBackStack(null);
            transaccion.commit();
            // Quita la visibilidad al boton flotante (para que no aparezca en el detalle)
            añadirRutina.setVisibility(View.GONE);

            // realiza la transaccion
            getSupportFragmentManager().executePendingTransactions();
        }
        // TODO Solicitar al presentador que trate el item seleccionado.
        presenterRutinas.obtenerDetalle(posicion);

    }


    // Redefinicion del metodo onBackPressed para que si se tiene un dispositivo de panel unico, y el boton
    // flotante no esta visible (esta el fragmento detalle en pantalla), reemplace el fragmento detalle por el
    // fragmento maestro. En cualquier otro caso, la actividad debe finalizar (porque se quiere salir de ella)

    @SuppressLint("RestrictedApi")
    @Override
    public void onBackPressed() { // este metodo es para del datalle al maestro, y del maestro al menu
        super.onBackPressed();
        presenterRutinas.eliminarDatos();
        presenterRutinas.obtenerDatos();
        añadirRutina.setVisibility(View.VISIBLE);

    }

    @Override
    public void onDestroy() { // este metodo es para del datalle al maestro, y del maestro al menu
        super.onDestroy();
    }





  /*  @SuppressLint("RestrictedApi")
    @Override
    public void onBackPressed(){
        if (findViewById(R.id.contenedorDeFragmentos)!=null){
        //es panel único
        //está en la vista del detalle
        FragmentTransaction transaccion = getSupportFragmentManager().beginTransaction();
        transaccion.replace(R.id.contenedorDeFragmentos, fragmentMasterRutinas);
        transaccion.addToBackStack(null);
        transaccion.commit();
        presenterRutinas.obtenerDatos();

    }else {
        //no es panel único
        finish();
    }*/


    // TODO Añadir el método actualizarMaestro(Object[] datos) que actualiza la lista maestro con los datos
    // recibidos por parámetros. En cada entrada del vector, está el nombre de una receta.
    @Override
    public void actualizarMaestro(Object[] datos) {
        // TODO Dentro del método actualizarMaestro(Object[] datos), crear la lista maestro con los nombres
        // de las recetas que entran por parámetros.
        fragmentMasterRutinas.crearLista((String[]) datos);
        // TODO Dentro del método actualizarMaestro(Object[] datos), si es una pantalla multi-panel, presentar
        // el detalle de la primera receta.
        if (findViewById(R.id.contenedorDeFragmentos) == null) {
            presenterRutinas.obtenerDetalle(0);
        }


    }

    // TODO Añadir el método actualizarDetalle(Object[] datos) que actualiza los valores del detalle,
    // teniendo en cuenta que en la posición 0 del vector está el nombre de la receta y en qué se usa
    // para realizarla, en la posición 1 del vector está la imagen como un Bitmap y en en la posición 3
    // del vector está la descripción de la receta.
    @Override
    public void actualizarDetalle(Object[] datos) {
        fragmentDetailRutinas.actualizarCategoria((String) datos[0]);
        fragmentDetailRutinas.actualizarEjercicio((String) datos[1]);
        fragmentDetailRutinas.actualizarSeries((String) datos[2]);
        fragmentDetailRutinas.actualizarRepeticiones((String) datos[3]);
        fragmentDetailRutinas.actualizarTiempo((String) datos[4]);
        fragmentDetailRutinas.actualizarObservaciones((String) datos[5]);

    }


    @Override
    public void toNuevaRutina() {
        Intent intent = new Intent(getApplicationContext(), NuevaRutinaView.class);
        startActivity(intent);
    }
}
