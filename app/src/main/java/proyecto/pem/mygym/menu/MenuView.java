package proyecto.pem.mygym.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import proyecto.pem.mygym.AppMediador;
import proyecto.pem.mygym.R;
import proyecto.pem.mygym.category.view.CategoryView;
import proyecto.pem.mygym.estiramientos.EstiramientosView;
import proyecto.pem.mygym.ejercicios.view.EjerciciosView;
import proyecto.pem.mygym.rutinas.view.RutinasView;

public class MenuView extends AppCompatActivity implements IMenuView {


    private AppMediador appMediador;
    private IMenuPresenter menuPresenter;

    private Button btnEjercicios, btnEstiramientos, btnRutinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        appMediador = (AppMediador) this.getApplication();
        menuPresenter = appMediador.getPresenterMenu();
        appMediador.setViewMenu(this);

        btnEjercicios = findViewById(R.id.btnEjercicios);
        btnEjercicios.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                menuPresenter.toEjerciciosPresenter();
            }

        });

        btnEstiramientos = findViewById(R.id.btnEstiramientos);
        btnEstiramientos.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                menuPresenter.toEstiramientosPresenter();

            }

        });

        btnRutinas = findViewById(R.id.btnRutinas);
        btnRutinas.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                menuPresenter.toRutinasPresenter();

            }

        });

    }

    @Override
    public void toEjercicios() {
        Intent intent = new Intent(getApplicationContext(), CategoryView.class);
        startActivity(intent);
    }

    @Override
    public void toEstiraminetos() {
        Intent intent = new Intent(getApplicationContext(), EstiramientosView.class);
        startActivity(intent);
    }

    @Override
    public void toRutinas() {
        Intent intent = new Intent(getApplicationContext(), RutinasView.class);
        startActivity(intent);

    }
}

