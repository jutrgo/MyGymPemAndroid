package proyecto.pem.mygym.ejercicios.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

import proyecto.pem.mygym.R;

public class FragmentDetailEjercicios extends Fragment {
	private TextView nombreEjercicio, infoEjercicios;
	private ImageView imagenEjercicios;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.activity_fragmento_detalle,
				container, false); 
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		nombreEjercicio = getView().findViewById(R.id.nombreEjercicios);
		infoEjercicios = getView().findViewById(R.id.infoEjercicio);
		imagenEjercicios = getView().findViewById(R.id.imagenDeEjercicio);

	}
	
	public void actualizarNombre(String nombre) {
		nombreEjercicio.setText(nombre);


	}

	public void actualizarImagen(String imagen) {
		//Uri uriImage = Uri.parse("android.resource://proyecto.pem.mygym/"+imagen+".jpg");
		//imagenEjercicios.setImageURI(uriImage);
		String url = "@drawable/"+imagen;
		imagenEjercicios.setImageResource(getResources().getIdentifier(url, null,"proyecto.pem.mygym" ));
		Log.d("lo que me de la gana", imagen);


	}

	public void actualizarDescripcion(String descripcion) {
		infoEjercicios.setText(descripcion);
	}

	
}
