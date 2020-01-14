package proyecto.pem.mygym.ejercicios.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import proyecto.pem.mygym.R;

public class AdapterEjercicios extends RecyclerView.Adapter<AdapterEjercicios.FilaViewHolder> {

    private String[] items;
    private SeleccionListener oyente;

    public AdapterEjercicios(Object[] datos, SeleccionListener oyente) {
        items = (String[])datos;
        this.oyente = oyente;
    }

    public interface SeleccionListener {
        public void onClick(FilaViewHolder fvh, int posicion);
    }

    @Override
    public FilaViewHolder onCreateViewHolder(ViewGroup padre, int viewType) {
        View view = LayoutInflater.from(padre.getContext())
                .inflate(R.layout.layout_item_maestro, padre, false);
        return new FilaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FilaViewHolder fvh, int posicion) {
        fvh.item.setText(items[posicion]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class FilaViewHolder extends RecyclerView.ViewHolder  {

        private TextView item, categoria;

        public FilaViewHolder(View view) {
            super(view);
            view.setClickable(true);
            item = (TextView) view.findViewById(R.id.item_maestro);
           // categoria = (TextView) view.findViewById(R.id.item_maestro_categoria);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    oyente.onClick(FilaViewHolder.this, getAdapterPosition());
                }
            });
        }
    }

}
