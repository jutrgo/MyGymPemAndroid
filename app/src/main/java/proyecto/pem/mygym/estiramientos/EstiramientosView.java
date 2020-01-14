package proyecto.pem.mygym.estiramientos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import proyecto.pem.mygym.AppMediador;
import proyecto.pem.mygym.R;
import proyecto.pem.mygym.menu.MenuView;

public class EstiramientosView extends AppCompatActivity implements IEstiramientosView {


    private IEstiramientosPresenter estiramientosPresenter;
    private AppMediador appMediador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estiramientos);
        appMediador = (AppMediador) this.getApplication();
        estiramientosPresenter = appMediador.getPresenterEstiramientos();
        appMediador.setViewEstiramientos(this);


    }

    @Override
    public void toMenu() {
        Intent intent = new Intent(getApplicationContext(), MenuView.class);
        startActivity(intent);    }
}

