package proyecto.pem.mygym;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;


import proyecto.pem.mygym.category.presenter.CategoryPresenter;
import proyecto.pem.mygym.category.presenter.ICategoryPresenter;
import proyecto.pem.mygym.category.view.ICategoryView;
import proyecto.pem.mygym.estiramientos.EstiramientosPresenter;
import proyecto.pem.mygym.estiramientos.IEstiramientosPresenter;
import proyecto.pem.mygym.estiramientos.IEstiramientosView;

import proyecto.pem.mygym.home.IHomePresenter;
import proyecto.pem.mygym.home.IHomeView;
import proyecto.pem.mygym.home.HomeView;
import proyecto.pem.mygym.home.HomePresenter;
import proyecto.pem.mygym.menu.IMenuPresenter;
import proyecto.pem.mygym.menu.IMenuView;
import proyecto.pem.mygym.menu.MenuPresenter;
import proyecto.pem.mygym.ejercicios.presenter.IEjerciciosPresenter;
import proyecto.pem.mygym.ejercicios.presenter.EjerciciosPresenter;
import proyecto.pem.mygym.ejercicios.view.IEjerciciosView;
import proyecto.pem.mygym.nuevaRutina.presenter.INuevaRutinaPresenter;
import proyecto.pem.mygym.nuevaRutina.presenter.NuevaRutinaPresenter;
import proyecto.pem.mygym.nuevaRutina.view.INuevaRutinaView;
import proyecto.pem.mygym.rutinas.presenter.IRutinasPresenter;
import proyecto.pem.mygym.rutinas.presenter.RutinasPresenter;
import proyecto.pem.mygym.rutinas.view.IRutinasView;

@SuppressWarnings("rawtypes")
public class AppMediador extends Application {

    private static AppMediador singleton;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	private String categoria = "";



	private boolean actualizarRutinas = true;

	// variables correspondientes a los presentadores, vistas y modelo

	//---------- Login (Home) --------------
	private IHomePresenter presenterLogin;
	private IHomeView viewLogin;


	//------------ Menu -------------------
	private IMenuPresenter presenterMenu;
	private IMenuView viewMenu;

	//---------- Category ------------------
	private ICategoryPresenter presenterCategory;
	private ICategoryView viewCategory;

	//----------Estiramientos ------------
	private IEstiramientosPresenter presenterEstiramientos;
	private IEstiramientosView viewEstiramientos;

	// variables correspondientes a los presentadores, vistas y modelo
	private IHomePresenter presenterHome;
	private IHomeView viewHome;
	private IEjerciciosPresenter presenterEjercicios;
	private IEjerciciosView viewEjercicios;

	//-------------Rutinas-----------------
	private IRutinasPresenter presenterRutinas;
	private IRutinasView viewRutinas;

	//-------------NuevaRutina-----------------
	private INuevaRutinaPresenter presenterNuevaRutina;
	private INuevaRutinaView viewNuevaRutina;



	// constantes de comunicación, almacenamiento y petición
	public static final String CLAVE_LISTA_ITEM = "listaRecetas";
	public static final String AVISO_DATOS_LISTOS = "pem.proyecto.AVISO_DATOS_LISTOS";
	public static final String CLAVE_DETALLE_ITEM = "detalleReceta";
	public static final String AVISO_DETALLE_LISTO = "pem.proyecto.AVISO_DETALLE_LISTO";
	public static final String AVISO_DATOS_AGREGADOS = "pem.proyecto.AVISO_DATOS_AGREGADOS";


	// constantes de comunicación, almacenamiento y petición
	public static final int ZOOM = 12; //este valor debería ser una preferencia de la aplicación, pero como no tenemos...
	public static final int ESTADO_INICIAL = 0;
	public static final int ESTADO_AGREGAR_MARCA = 1;
	public static final int ESTADO_BORRAR_MARCA = 2;
	public static final String CLAVE_USERNAME = "username";
	public static final String CLAVE_PASSWORD = "password";
	public static final String CLAVE_FAILED = "failed";
	public static final String CLAVE_SUCCESS = "success";

	public static final String AVISO_ESTADO_INICIAL = "pem.proyecto.AVISO_ESTADO_INICIAL";
	public static final String AVISO_LOCALIZACION_GPS = "pem.proyecto.AVISO_LOCALIZACION_GPS";
	public static final String AVISO_AGREGAR_RUTINA = "pem.proyecto.AVISO_AGREGAR_RUTINA";
	public static final String AVISO_BORRAR_MARCA = "pem.proyecto.AVISO_BORRAR_MARCA";
	public static final String AVISO_AUTHENTICATION_SUCCESS = "pem.proyecto.mygym.AVISO_AUTHENTICATION_SUCCESS";
	public static final String AVISO_AUTHENTICATION_FAILED = "pem.proyecto.mygym.AVISO_AUTHENTICATION_FAILED";

	public static final String CLAVE_LISTA_RUTINAS = "succes";
	public static final String AVISO_DATOS_RUTINAS= "pem.proyecto.mygym.AVISO_DATOS_RUTINAS";

	public static final String CLAVE_DETALLE_RUTINA = "succes";
	public static final String AVISO_DETALLE_RUTINA= "pem.proyecto.mygym.AVISO_DETALLE_RUTINA";







	public static final String AVISO_ERROR_RUTINA = "pem.proyecto.mygym.AVISO_ERROR";


	public static AppMediador getInstance(){
		return singleton;
	}

	///////////////////////////// LOGIN (HOME) //////////////////////////////

	public IHomePresenter getPresenterHome() {
		if (presenterHome == null)
			presenterHome = new HomePresenter();
		return presenterHome;
	}

	public void removePresenterHome() {
		presenterHome = null;
	}

	public IHomeView getViewHome() {
		return viewHome;
	}

	public void setViewHome(IHomeView viewHome) {
		this.viewHome = viewHome;
	}


// --------- LOGIN NO UTILIZADO ----------------------

	public IHomePresenter getPresenterLogin() {
		if (presenterLogin == null)
			presenterLogin = new HomePresenter();
		return presenterLogin;

	}

	public IHomeView getViewLogin() {
		return viewLogin;
	}

	public void setViewLogin(HomeView homeView) {
		this.viewLogin = homeView;
	}



	//////////////////////////// MENU ///////////////////////////////

	public IMenuPresenter getPresenterMenu() {
		if (presenterMenu == null)
			presenterMenu = new MenuPresenter();
		return presenterMenu;
	}

	public void removePresenterMenu() {
		presenterMenu = null;
	}

	public IMenuView getViewMenu() {
		return viewMenu;
	}

	public void setViewMenu(IMenuView viewMenu) {
		this.viewMenu = viewMenu;
	}



	//////////////////////////EJERCICIOS////////////////////////////////
	public IEjerciciosPresenter getPresenterEjercicios() {
		if (presenterEjercicios == null)
			presenterEjercicios = new EjerciciosPresenter();
		return presenterEjercicios;
	}


	public void setViewEjercicios(IEjerciciosView viewEjercicios) {
		this.viewEjercicios = viewEjercicios;
	}

	public IEjerciciosView getViewEjercicios() {
		return viewEjercicios;
	}



	///////////////////////// CATEGORY ////////////////////////////

	public ICategoryPresenter getPresenterCategory() {
		if (presenterCategory == null)
			presenterCategory = new CategoryPresenter();
		return presenterCategory;
	}

	public void removePresenterCategory() {
		presenterCategory = null;
	}

	public ICategoryView getViewCategory() {
		return viewCategory;
	}

	public void setViewCategory(ICategoryView viewCategory) {
		this.viewCategory = viewCategory;
	}





	////////////////////////// ESTIRAMIENTOS ///////////////////////////

	public IEstiramientosPresenter getPresenterEstiramientos() {
		if (presenterEstiramientos == null)
			presenterEstiramientos = new EstiramientosPresenter();
		return presenterEstiramientos;
	}

	public void removePresenterEstiramientos() {
		presenterEstiramientos = null;
	}

	public IEstiramientosView getViewEstiramientos() {
		return viewEstiramientos;
	}

	public void setViewEstiramientos(IEstiramientosView viewEstiramientos) {
		this.viewEstiramientos = viewEstiramientos;
	}


	///////////////////////////// RUTINAS //////////////////////////////

	public IRutinasPresenter getPresenterRutinas() {
		if (presenterRutinas == null)
			presenterRutinas = new RutinasPresenter();
		return presenterRutinas;
	}

	public void removePresenterRutinas() {
		presenterRutinas = null;
	}

	public IRutinasView getViewRutinas() {
		return viewRutinas;
	}

	public void setViewRutinas(IRutinasView viewRutinas) {
		this.viewRutinas = viewRutinas;
	}



	///////////////////////////// NUEVA RUTINA //////////////////////////////

	public INuevaRutinaPresenter getPresenterNuevaRutina() {
		if (presenterNuevaRutina == null)
			presenterNuevaRutina = new NuevaRutinaPresenter();
		return presenterNuevaRutina;
	}

	public void removePresenterNuevaRutina() {
		presenterNuevaRutina = null;
	}

	public INuevaRutinaView getViewNuevaRutina() {
		return viewNuevaRutina;
	}

	public void setViewNuevaRutina(INuevaRutinaView viewNuevaRutina) {
		this.viewNuevaRutina = viewNuevaRutina;
	}



	// Métodos destinados a la navegación en la aplicación y a la definición de servicios

	// Métodos de manejo de los componentes de Android



	public void launchActivity(Class actividadInvocada, Object invocador, Bundle extras) {
		Intent i = new Intent(this, actividadInvocada);
		if (extras != null)
			i.putExtras(extras);
		if (!invocador.getClass().equals(Activity.class))
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(i);
	}

	public void launchActivityForResult(Class actividadInvocada,
                                        Activity actividadInvocadora, int requestCode, Bundle extras) {
		Intent i = new Intent(actividadInvocadora, actividadInvocada);
		if (extras != null)
			i.putExtras(extras);
		actividadInvocadora.startActivityForResult(i, requestCode);
	}

	public void launchService(Class servicioInvocado, Bundle extras) {
		Intent i = new Intent(this, servicioInvocado);
		if (extras != null)
			i.putExtras(extras);
        startService(i);
	}

	public void stopService(Class servicioInvocado) {
		Intent i = new Intent(this, servicioInvocado);
        stopService(i);
	}

	public void registerReceiver(BroadcastReceiver receptor, String accion) {
		LocalBroadcastManager.getInstance(this).registerReceiver(receptor, new IntentFilter(accion));
	}

	public void unRegisterReceiver(BroadcastReceiver receptor) {
		LocalBroadcastManager.getInstance(this).unregisterReceiver(receptor);
	}

	public void sendBroadcast(String accion, Bundle extras) {
		Intent intent = new Intent();
		intent.setAction(accion);
		if (extras != null)
			intent.putExtras(extras);
		LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
	}

	@Override
	public void onCreate() {
		super.onCreate();
//		presentadorMapa = null;
		singleton = this;
	}

	public boolean getActualizarRutinas() {
		return actualizarRutinas;
	}

	public void setActualizarRutinas(boolean actualizarRutinas) {
		this.actualizarRutinas = actualizarRutinas;
	}
}
