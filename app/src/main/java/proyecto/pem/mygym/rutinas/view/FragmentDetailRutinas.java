package proyecto.pem.mygym.rutinas.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import proyecto.pem.mygym.R;

public class FragmentDetailRutinas extends Fragment {

	private TextView categoria, ejercicio, series, repeticiones,tiempo, observaciones;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.activity_fragmento_detalle_rutina,
				container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		categoria = getView().findViewById(R.id.nombreCategoria);
		ejercicio = getView().findViewById(R.id.nombreEjercicio);
		series = getView().findViewById(R.id.nombreSeries);
		repeticiones = getView().findViewById(R.id.nombreRepeticiones);
		tiempo = getView().findViewById(R.id.nombreTiempo);
		observaciones = getView().findViewById(R.id.nombreObservaciones);

	}


	public void actualizarCategoria(String descripcion) {
		categoria.setText(descripcion);
	}

	public void actualizarEjercicio(String descripcion) {
		ejercicio.setText(descripcion);
	}

	public void actualizarSeries(String descripcion) {
		series.setText(descripcion);

	}

	public void actualizarRepeticiones(String descripcion) {
		repeticiones.setText(descripcion);

	}

	public void actualizarTiempo(String descripcion) {
		tiempo.setText(descripcion);

	}

	public void actualizarObservaciones(String descripcion) {
		observaciones.setText(descripcion);

	}


}
