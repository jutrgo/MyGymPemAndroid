package proyecto.pem.mygym.category.model;

import java.util.ArrayList;

public class ConjuntoDeCategory {

    private static ConjuntoDeCategory singleton = null;
    private ArrayList<ItemCategory> listaDeCategory;

    private ConjuntoDeCategory() {
        listaDeCategory = new ArrayList<ItemCategory>();
        listaDeCategory.add(new ItemCategory("Pectorales"));
        listaDeCategory.add(new ItemCategory("Espalda"));
        listaDeCategory.add(new ItemCategory("Hombros"));
        listaDeCategory.add(new ItemCategory("Brazos"));
        listaDeCategory.add(new ItemCategory("Piernas"));

    }

    public static ConjuntoDeCategory getInstance() {
        if (singleton == null)
            singleton = new ConjuntoDeCategory();
        return singleton;
    }

    public ArrayList<ItemCategory> getListaDeCategory() {
        return listaDeCategory;
    }
}



