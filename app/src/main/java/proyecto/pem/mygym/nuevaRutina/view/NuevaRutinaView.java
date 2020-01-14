package proyecto.pem.mygym.nuevaRutina.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import proyecto.pem.mygym.AppMediador;
import proyecto.pem.mygym.R;
import proyecto.pem.mygym.nuevaRutina.presenter.INuevaRutinaPresenter;
import proyecto.pem.mygym.rutinas.view.RutinasView;

public class NuevaRutinaView extends AppCompatActivity implements INuevaRutinaView{

    private AppMediador appMediador;
    private INuevaRutinaPresenter presenterNuevaRutina;
    private FloatingActionButton añadirRutina;

    private Button btnGuardar;
    private EditText categoria, ejercicio, series, repeticiones, tiempo, observaciones;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevarutina);
        appMediador = (AppMediador)this.getApplication();
        presenterNuevaRutina = appMediador.getPresenterNuevaRutina();
        appMediador.setViewNuevaRutina(this);
        Log.d("que pasaaaaaaa", "sdwdsddsdsdsdsds");

        categoria = findViewById(R.id.editText2);
        ejercicio = findViewById(R.id.editText3);
        series = findViewById(R.id.editText4);
        repeticiones = findViewById(R.id.editText5);
        tiempo = findViewById(R.id.editText6);
        observaciones = findViewById(R.id.editText7);



        btnGuardar = findViewById(R.id.btnGuargar);
        btnGuardar.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                presenterNuevaRutina.guardarPresenter();
            }

        });


    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onBackPressed(){ // este metodo es para del datalle al maestro, y del maestro al menu
        super.onBackPressed();
        //presenterNuevaRutina.obtenerDatos();
    }

    @Override
    public String getCategoria() {
        return categoria.getText().toString();
    }

    @Override
    public String getEjercicio() {
        return ejercicio.getText().toString();

    }

    @Override
    public String getSeries() {
        return series.getText().toString();
    }

    @Override
    public String getRepeticiones() {
        return repeticiones.getText().toString();

    }

    @Override
    public String getTiempo() {
        return tiempo.getText().toString();
    }

    @Override
    public String getObservaciones() {
        return observaciones.getText().toString();

    }

    @Override
    public void toRutinas() {
        finish();
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

}
