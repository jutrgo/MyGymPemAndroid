package proyecto.pem.mygym.rutinas.model;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import proyecto.pem.mygym.AppMediador;
import proyecto.pem.mygym.category.model.ConjuntoDeCategory;
import proyecto.pem.mygym.ejercicios.model.ItemEjercicios;

public class RutinasModel implements IRutinasModel {

    private static RutinasModel singleton = null;

    private AppMediador appMediador;

    private FirebaseDatabase data;

    private ConjuntoDeRutinas conjuntoDeRutinas;

    private RutinasModel() {
        appMediador = AppMediador.getInstance();
        conjuntoDeRutinas =	ConjuntoDeRutinas.getInstance();


        data = FirebaseDatabase.getInstance();
    }

    public static RutinasModel getInstance() {
        if (singleton == null)
            singleton = new RutinasModel();
        return singleton;
    }


    @Override
    public void obtenerDatos() {
        //final boolean actualizar = appMediador.getActualizarRutinas();
        DatabaseReference ref = data.getReference();
        ref.child("rutinas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boolean actualizar = appMediador.getActualizarRutinas();
                if(actualizar == true){
                    for (DataSnapshot data : dataSnapshot.getChildren()) {

                        Rutinas rutina = new Rutinas();
                        rutina.setCategoria(data.child("categoria").getValue().toString());
                        rutina.setEjercicio(data.child("ejercicio").getValue().toString());
                        rutina.setRepeticiones(data.child("repeticiones").getValue().toString());
                        rutina.setSeries(data.child("series").getValue().toString());
                        rutina.setTiempo(data.child("tiempo").getValue().toString());
                        rutina.setObservaciones(data.child("observaciones").getValue().toString());
                        rutina.setId(data.child("id").getValue().toString());
                        conjuntoDeRutinas.agregarRutinas(rutina);

                        //Log.d("muestrameee", rutina.getEjercicio());
                    }
                }
                appMediador.setActualizarRutinas(false);
                Bundle extras = new Bundle();
                extras.putSerializable(AppMediador.CLAVE_LISTA_RUTINAS, conjuntoDeRutinas.getListaDeRutinas());
                appMediador.sendBroadcast(AppMediador.AVISO_DATOS_RUTINAS, extras);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    @Override
    public void obtenerDetalle(int posicion) {
        Rutinas rutina = conjuntoDeRutinas.getListaDeRutinas().get(posicion);
        String[] datos = new String[7];
        datos[0] = rutina.getCategoria();
        datos[1] = rutina.getEjercicio();
        datos[2] = rutina.getSeries();
        datos[3] = rutina.getRepeticiones();
        datos[4] = rutina.getTiempo();
        datos[5] = rutina.getObservaciones();
        datos[6] = rutina.getId();


        Bundle extras = new Bundle();
        extras.putStringArray(AppMediador.CLAVE_DETALLE_RUTINA, datos);
        appMediador.sendBroadcast(AppMediador.AVISO_DETALLE_RUTINA, extras);
    }

    @Override
    public void agregarRutina(final String[] datos) {
        final String uuid = java.util.UUID.randomUUID().toString();
        //"server/saving-data/fireblog"
        DatabaseReference ref3 = data.getReference();
        final Rutinas rutina = new Rutinas();
        rutina.setId(uuid);
        rutina.setCategoria(datos[0]);
        rutina.setEjercicio(datos[1]);
        rutina.setSeries(datos[2]);
        rutina.setRepeticiones(datos[3]);
        rutina.setTiempo(datos[4]);
        rutina.setObservaciones(datos[5]);
        ref3.child("rutinas/"+ uuid).setValue(rutina).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    DatabaseReference ref2 = data.getReference();
                    ref2.child("rutinas").orderByChild("id").equalTo(uuid).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot data : dataSnapshot.getChildren()) {

                                Rutinas rutina2 = new Rutinas();
                                rutina2.setCategoria(data.child("categoria").getValue().toString());
                                rutina2.setEjercicio(data.child("ejercicio").getValue().toString());
                                rutina2.setRepeticiones(data.child("repeticiones").getValue().toString());
                                rutina2.setSeries(data.child("series").getValue().toString());
                                rutina2.setTiempo(data.child("tiempo").getValue().toString());
                                rutina2.setObservaciones(data.child("observaciones").getValue().toString());
                                rutina2.setId(data.child("id").getValue().toString());
                                conjuntoDeRutinas.agregarRutinas(rutina2);
                                //Log.d("muestrameee", rutina.getEjercicio());
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    appMediador.sendBroadcast(AppMediador.AVISO_AGREGAR_RUTINA, null);

                } else {
                    appMediador.sendBroadcast(AppMediador.AVISO_ERROR_RUTINA, null);

                }
            }
        });

    }

    @Override
    public void elimarDatos() {
        conjuntoDeRutinas.eliminarRutinas();
        appMediador.setActualizarRutinas(true);
    }

    @Override
    public void eliminarRutina(String id) {
        final DatabaseReference rutinas = FirebaseDatabase.getInstance().getReference().child("rutinas").child(id);
        rutinas.removeValue();
        appMediador.sendBroadcast(AppMediador.AVISO_RUTINA_BORRADA,null);

    }


}

