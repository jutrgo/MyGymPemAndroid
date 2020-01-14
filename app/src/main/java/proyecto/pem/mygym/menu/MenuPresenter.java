package proyecto.pem.mygym.menu;

import proyecto.pem.mygym.AppMediador;

public class MenuPresenter implements IMenuPresenter {

    private AppMediador appMediador;

    public MenuPresenter(){
        appMediador = AppMediador.getInstance();

    }

    @Override
    public void toEjerciciosPresenter() {
        appMediador.getViewMenu().toEjercicios();
    }

    @Override
    public void toEstiramientosPresenter() {
        appMediador.getViewMenu().toEstiraminetos();

    }

    @Override
    public void toRutinasPresenter() {
        appMediador.getViewMenu().toRutinas();


    }

}
