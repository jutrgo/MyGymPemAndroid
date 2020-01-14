package proyecto.pem.mygym.rutinas.model;

import java.util.ArrayList;

import proyecto.pem.mygym.category.model.ItemCategory;

public class ConjuntoDeRutinas {

	private static ConjuntoDeRutinas singleton = null;
	private ArrayList<Rutinas> listaDeRutinas;

	private ConjuntoDeRutinas() {
		listaDeRutinas = new ArrayList<Rutinas>();

	}
	public static ConjuntoDeRutinas getInstance() {
		if (singleton == null)
			singleton = new ConjuntoDeRutinas();
		return singleton;
	}

	public ArrayList<Rutinas> getListaDeRutinas() {
		return listaDeRutinas;
	}

	public void agregarRutinas(Rutinas rutina){
		listaDeRutinas.add(rutina);

	}

	public void eliminarRutinas(){
		listaDeRutinas.removeAll(listaDeRutinas);
	}
}



