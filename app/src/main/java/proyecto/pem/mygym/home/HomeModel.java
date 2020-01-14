package proyecto.pem.mygym.home;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import proyecto.pem.mygym.AppMediador;

public class HomeModel implements IHomeModel {

    private static HomeModel singlenton = null;
    private AppMediador appMediador;
    private FirebaseAuth mAuth;

    public HomeModel() {
        appMediador = AppMediador.getInstance();
        mAuth = FirebaseAuth.getInstance();

    }

    public static HomeModel getInstance(){
        if (singlenton == null)
            singlenton = new HomeModel();
        return singlenton;
    }

}
