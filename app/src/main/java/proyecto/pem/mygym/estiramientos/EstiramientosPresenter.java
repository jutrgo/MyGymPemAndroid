package proyecto.pem.mygym.estiramientos;

import proyecto.pem.mygym.AppMediador;

public class EstiramientosPresenter implements IEstiramientosPresenter {

    private AppMediador appMediador;

    public EstiramientosPresenter(){
        appMediador = AppMediador.getInstance();
    }


    @Override
    public void toMenuPresenter() {
        //appMediador.registerReceiver(receptorDeAvisos, AppMediador.AVISO_MENU);
        appMediador.getViewHome().toMenu();

    }

}
