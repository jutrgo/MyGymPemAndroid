package proyecto.pem.mygym.rutinas.view;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import proyecto.pem.mygym.AppMediador;
import proyecto.pem.mygym.R;
import proyecto.pem.mygym.menu.MenuView;
import proyecto.pem.mygym.nuevaRutina.view.NuevaRutinaView;
import proyecto.pem.mygym.rutinas.presenter.IRutinasPresenter;

public class RutinasView extends AppCompatActivity implements IRutinasView,
        FragmentMasterRutinas.EscuchaFragmento {

    private AppMediador appMediador;
    private IRutinasPresenter presenterRutinas;
    private FragmentMasterRutinas fragmentMasterRutinas;
    private FragmentDetailRutinas fragmentDetailRutinas;
    private FloatingActionButton añadirRutina;
    private Button btnElimnar;
    private String id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutinas);
        appMediador = (AppMediador) this.getApplication();
        presenterRutinas = appMediador.getPresenterRutinas();
        appMediador.setViewRutinas(this);

        id = "";


        if (findViewById(R.id.contenedorDeFragmentos) != null) {
            // se crea el fragmento maestro y se anade al contenedor de fragmentos
            fragmentMasterRutinas = new FragmentMasterRutinas();
            getSupportFragmentManager().beginTransaction().add(R.id.contenedorDeFragmentos, fragmentMasterRutinas).commit();
        }

        añadirRutina = findViewById(R.id.fab);
        añadirRutina.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                presenterRutinas.toNuevaRutina();

            }

        });

        btnElimnar = findViewById(R.id.btnEliminar);
        btnElimnar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterRutinas.eliminarRutina(id);
            }
        });

        btnElimnar.setVisibility(View.GONE);
    }


    @Override
    protected void onStart() {
        super.onStart();
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
            btnElimnar.setVisibility(View.VISIBLE);


            // realiza la transaccion
            getSupportFragmentManager().executePendingTransactions();
        }
        presenterRutinas.obtenerDetalle(posicion);

    }


    @SuppressLint("RestrictedApi")
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        presenterRutinas.eliminarDatos();
        presenterRutinas.obtenerDatos();
        añadirRutina.setVisibility(View.VISIBLE);
        btnElimnar.setVisibility(View.GONE);

    }

    @Override
    public void onDestroy() { // este metodo es para del datalle al maestro, y del maestro al menu
        super.onDestroy();
    }


    @Override
    public void actualizarMaestro(Object[] datos) {
        fragmentMasterRutinas.crearLista((String[]) datos);
        if (findViewById(R.id.contenedorDeFragmentos) == null) {
            presenterRutinas.obtenerDetalle(0);
        }
    }

    @Override
    public void actualizarDetalle(Object[] datos) {
        fragmentDetailRutinas.actualizarCategoria((String) datos[0]);
        fragmentDetailRutinas.actualizarEjercicio((String) datos[1]);
        fragmentDetailRutinas.actualizarSeries((String) datos[2]);
        fragmentDetailRutinas.actualizarRepeticiones((String) datos[3]);
        fragmentDetailRutinas.actualizarTiempo((String) datos[4]);
        fragmentDetailRutinas.actualizarObservaciones((String) datos[5]);
        id = (String) datos[6];
    }

    @Override
    public void toNuevaRutina() {
        Intent intent = new Intent(getApplicationContext(), NuevaRutinaView.class);
        startActivity(intent);
    }

    @Override
    public void rutinaBorrada() {
        onBackPressed();
    }


}
