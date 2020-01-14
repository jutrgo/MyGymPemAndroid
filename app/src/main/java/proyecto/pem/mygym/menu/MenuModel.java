package proyecto.pem.mygym.menu;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import proyecto.pem.mygym.AppMediador;

public class MenuModel implements IMenuModel {

    private static MenuModel singlenton = null;
    private AppMediador appMediador;
    private FirebaseAuth mAuth;

    public MenuModel() {
        appMediador = AppMediador.getInstance();
        mAuth = FirebaseAuth.getInstance();

    }

    public static MenuModel getInstance(){
        if (singlenton == null)
            singlenton = new MenuModel();
        return singlenton;
    }


}
