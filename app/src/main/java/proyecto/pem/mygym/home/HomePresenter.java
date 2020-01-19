package proyecto.pem.mygym.home;

import proyecto.pem.mygym.AppMediador;

public class HomePresenter implements IHomePresenter {

    private AppMediador appMediador;

    public HomePresenter(){
        appMediador = AppMediador.getInstance();
    }



    @Override
    public void toMenuPresenter() {
        appMediador.getViewHome().toMenu();

    }

}
