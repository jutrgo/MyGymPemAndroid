package proyecto.pem.mygym.estiramientos;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import proyecto.pem.mygym.AppMediador;

public class EstiramientosModel implements IEstiramientosModel {

    private static EstiramientosModel singlenton = null;
    private AppMediador appMediador;
    private FirebaseAuth mAuth;

    public EstiramientosModel() {
        appMediador = AppMediador.getInstance();
        mAuth = FirebaseAuth.getInstance();

    }

    public static EstiramientosModel getInstance(){
        if (singlenton == null)
            singlenton = new EstiramientosModel();
        return singlenton;
    }

}
