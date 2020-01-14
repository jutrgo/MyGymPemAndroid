package proyecto.pem.mygym.category.model;

import java.io.Serializable;

public class ItemCategory implements Serializable {

    private static final long serialVersionUID = -344029098860190065L;
    private String categoria;


    public ItemCategory(String categoria) {
        super();

        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

