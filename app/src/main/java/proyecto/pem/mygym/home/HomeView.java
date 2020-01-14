package proyecto.pem.mygym.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import proyecto.pem.mygym.AppMediador;
import proyecto.pem.mygym.R;
import proyecto.pem.mygym.menu.MenuView;

public class HomeView extends AppCompatActivity implements IHomeView {

    private Button buttonEntrar;
    private IHomePresenter homePresenter;
    private AppMediador appMediador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        appMediador = (AppMediador) this.getApplication();
        homePresenter = appMediador.getPresenterHome();
        appMediador.setViewHome(this);

        buttonEntrar = findViewById(R.id.ButtonEntrar);
        buttonEntrar.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                homePresenter.toMenuPresenter();
            }

        });

    }

    @Override
    public void toMenu() {
        Intent intent = new Intent(getApplicationContext(), MenuView.class);
        startActivity(intent);    }
}

