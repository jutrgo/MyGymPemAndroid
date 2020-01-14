package proyecto.pem.mygym.ejercicios.model;

import java.util.ArrayList;

public class ConjuntoDeEjercicios {

    private static ConjuntoDeEjercicios singleton = null;
    private ArrayList<ItemEjercicios> listaDeEjericios;

    private ConjuntoDeEjercicios() {
        listaDeEjericios = new ArrayList<ItemEjercicios>();
        listaDeEjericios.add(new ItemEjercicios("press_banca", "Press de banca plano", "Pectorales", "Acostado sobre un banco plano, glúteos en contacto con el banco, pies en el suelo. - Coger la barra, manos en pronacion y separadas a la anchura de los hombros. - Inspirar y bajar la barra hasta el pecho, controlando el movimiento. - Desarrollar expirando al final del esfuerzo."));
        listaDeEjericios.add(new ItemEjercicios("press_banca_inclinado", "Press de banca inclinado", "Pectorales", "Sentado en un banco inclinido, entre 45 y 60 grados, coger la barra, manos en pronacion separadas en una longitud superior a la de los hombros. - Inspirar y bajar la barra sobre la horquilla esternal. Desarrollar expirando al final del movimiento"));
        listaDeEjericios.add(new ItemEjercicios("press_banca_declinado", "Press de banco declinado", "Pectorales", "Acostado, cabeza hacia abajo, en un banco mas  o menos inclinado (entre 20 y 40 grados), pies fijos para evitar deslizaminentos, coger la barra con las manos en pronacion y separadas en una distancia igual o superior a la anchura de los hombros. - Inspirar y bajar la barra sobre la parte baja de los pectores controlando el movimiento, desarrollar expirando al final del esfuerzo."));
        listaDeEjericios.add(new ItemEjercicios("flexiones", "Flexiones de brazo en el suelo", "Pectorales", "En apoyo de cara al suelo, brazos estirados, manos separadas en una longitud igual a la anchura de los hombros (o más), pies juntos o muy poco separados: - Inspirar y flexionar los brazos para llevar la caja torácica cerca del sueo, siempre eviando curvar demasiado la region lumbar; - Empujar sobre el suelo hasta conseguir la extensión completa de los brazos; - Espirar al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("press_mancuerna", "Press con mancuernas en banco plano", "Pectorales", "Estirando sobre un banco plano, pies en el suelo para asegurar la estabilidad, brazos extendidos verticalmente, manos en frente en semi-pronación y cogiendo las mancuernas: - Inspirar y bajar la barra hasta el nivel del pecho flexionando los codos y efectuando una rotación de los antebrazos para llevar las manos a una pronación completa; - Desarrallar, cuando las manos se encuentran frente a frente, efectuar una contracción isométrica para localizar el esfuerzo sobre la parte esternal de los pectorales. - Espirar al fina del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("press_mancuerna_inclinado", "Press con mancuernas en banco inclinado", "Pectorales", "Sentado en un banco mas o menos inclinado (no más de 60 grados para no trasladar el trabajo a los deltoides), codos flexionados, mancuernas cogidas con las manos en pronación: - Inspirar y estirar los brazos verticalmente acercando las mancuernas. Espirar al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("aperturas_mancuerna", "Aperturas con mancuernas en banco inclinado", "Pectorales", "Levafnte la barra y desde el pecho superior levante la barra"));
        listaDeEjericios.add(new ItemEjercicios("aperturas_contractor", "Aperturas en contractor del pecho", "Pectorales", "Con las mancuefrnas sentado abra los brazos"));
        listaDeEjericios.add(new ItemEjercicios("pullover", "Pullover mancuerna", "Pectorales", "Levante la barra y haga el ejercifcio"));

        listaDeEjericios.add(new ItemEjercicios("dominadas", "Tracción o dominadas en barra fija", "Espalda", "En suspensión en la barra fija, manos muy separadas en pronación: - Inspirar y efecturar una tracción hasta que la nuca llegue casi a tocar la barra. Espirar al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("polea_pecho", "Polea al pecho", "Espalda", "Sentado frente al aparato, piernas fijadas, barra cogida en pronación, manos muy separadas: - Inspirar y tirar de la barra hasta la horquilla esternal, ensanchando el pecho y llevando los codos hacia atrás. Espirar al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("polea_trasnuca", "Polea trasnuca", "Espalda", "Sentado de frenta al aparato, muslos fijados bajo los cojines, barra asida en pronación, manos muy separadas: - Inspirar y tirar de la barra hasta la nunca dirigiendo los codos hacia el tronco; - Espirar al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("polea_pecho_estrecho", "Polea al pecho con agarre estrecho", "Espalda", "Sentado de cara al aparato, rodillas fijadas: - Inspirar y llevar el mango hasta el esternón ensanchando el pecho e inclinando ligeramento el tronco hacia atrás. Espirar al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("remo_polea", "Remo en polea baja", "Espalda", "Sentado de cara al aparato, pies anclados, tronco flexionado: - Inspirar y llevar el mango hasta la base del esternón enderezando la espalda y tirando los codos hacia atrás lo mas lejos posible. Espirar al final del movimiento y regresar suavemente a la posición inicial."));
        listaDeEjericios.add(new ItemEjercicios("remo_horizontal", "Remo horizontal con barra, manos en pronación", "Espalda", "De pie, rodillas ligeramente flexionadas, tronco inclinado 45 grados, espalda bien recta, barra asida en pronación, manos separadas una distancia mayor a la anchura de los hombros, brazos colgando: - Inspirar, efectuar un bloqueo respiratorio y una contracción isométrica de la banda abdominal, tirar de la barra hasta el pecho; - Volver a la posición de partida y espirar."));
        listaDeEjericios.add(new ItemEjercicios("peso_muerto", "Peso muerto con barra", "Espalda", "Jala todo lo que puedas"));
        listaDeEjericios.add(new ItemEjercicios("remo_cuello", "Remo al cuello", "Espalda", "Jala todo lo que puedas"));
        listaDeEjericios.add(new ItemEjercicios("encogimiento_hombros_barra", "Encongimiento de hombros con barra", "Espalda", "Jala todo lo que puedas"));
        listaDeEjericios.add(new ItemEjercicios("encogimiento_mancuerna", "Encongimiento  y rotación de hombros con mancuernas", "Espalda", "Jala todo lo que puedas"));

        listaDeEjericios.add(new ItemEjercicios("press_trasnuca", "Press trasnuca con barra", "Hombros", "Fuerte como un roble"));
        listaDeEjericios.add(new ItemEjercicios("press_frontal", "Press frontal con barra", "Hombros", "Levante la barra"));
        listaDeEjericios.add(new ItemEjercicios("press_sentado", "Press sentado con marcuernas", "Hombros", "Vamossss"));
        listaDeEjericios.add(new ItemEjercicios("elevaciones_laterales", "Elevaciones laterales con mancuernas", "Hombros", "Fuerte como un roble"));
        listaDeEjericios.add(new ItemEjercicios("elevaciones_frontales", "Elevaciones frontales alternas con mancuerna", "Hombros", "Levante la barra"));
        listaDeEjericios.add(new ItemEjercicios("elevaciones_frontales_polea", "Elevaciones frontales alternas con polea bajar", "Hombros", "Vamossss"));
        listaDeEjericios.add(new ItemEjercicios("elevaciones_laterales_polea", "Elevaciones laterales alternas con polea bajar", "Hombros", "Fuerte como un roble"));
        listaDeEjericios.add(new ItemEjercicios("remo", "Remo al cuello, manos separadas", "Hombros", "Levante la barra"));
        listaDeEjericios.add(new ItemEjercicios("deltoides_posterior", "Deltoides posterior en máquina específica", "Hombros", "Vamossss"));
        listaDeEjericios.add(new ItemEjercicios("pajaro", "Elevaciones posteriores con polea baja, tronco inclinado hacia delante o Pájaro en polea", "Hombros", "Vamossss"));

        listaDeEjericios.add(new ItemEjercicios("curl_biceps_supinacion", "Curls de biceps alterno con supinación", "Brazos", ""));
        listaDeEjericios.add(new ItemEjercicios("curls_biceps_polea", "Curls de biceps con polea", "Brazos", ""));
        listaDeEjericios.add(new ItemEjercicios("curl_biceps_barra", "Curl de biceps con barra", "Brazos", ""));
        listaDeEjericios.add(new ItemEjercicios("curl_biceps_martillo", "Curl de biceps alterno tipo martillo", "Brazos", ""));
        listaDeEjericios.add(new ItemEjercicios("curl_biceps_concentrado", "Curl de biceps concentrado con apoyo en el muslo", "Brazos", ""));
        listaDeEjericios.add(new ItemEjercicios("extension_triceps", "Extension de triceps en polea alta", "Brazos", ""));
        listaDeEjericios.add(new ItemEjercicios("extension_triceps_invertido", "Extension de triceps en polea alta, aggare invertido", "Brazos", ""));
        listaDeEjericios.add(new ItemEjercicios("press_frances", "Press frances en banco plano", "Brazos", ""));
        listaDeEjericios.add(new ItemEjercicios("press_frances_mancuerna", "Press frances en banco plano con mancuerna", "Brazos", ""));
        listaDeEjericios.add(new ItemEjercicios("extension_vertical", "Extension vertical alternada de los codos con mancuerna", "Brazos", ""));

        listaDeEjericios.add(new ItemEjercicios("flexion_rodillas", "Flexión de rodillas con mancuernas", "Piernas", ""));
        listaDeEjericios.add(new ItemEjercicios("sentadillas", "Squat o sentadillas", "Piernas", ""));
        listaDeEjericios.add(new ItemEjercicios("presan", "Prensa de piernas inclinada", "Piernas", ""));
        listaDeEjericios.add(new ItemEjercicios("extension", "Extensión de rodillas en máquina", "Piernas", ""));
        listaDeEjericios.add(new ItemEjercicios("curl_piernas", "Curl de piernas acostado", "Piernas", ""));
        listaDeEjericios.add(new ItemEjercicios("curl_piernas_alaterno", "Curl de piernas alterno", "Piernas", ""));
        listaDeEjericios.add(new ItemEjercicios("gemelos_máquina", "Gemelos en máquina", "Piernas", ""));
        listaDeEjericios.add(new ItemEjercicios("elevación", "Elevación de talones de pie, en máquina", "Piernas", ""));
        listaDeEjericios.add(new ItemEjercicios("extension_talones", "Extensión de talones, sentado, en máquina", "Piernas", ""));
        listaDeEjericios.add(new ItemEjercicios("elevacion_pelvis", "Elevación de la pelvis en el suelo", "Piernas", ""));


    }

    public static ConjuntoDeEjercicios getInstance() {
        if (singleton == null)
            singleton = new ConjuntoDeEjercicios();
        return singleton;
    }

    public ArrayList<ItemEjercicios> getListaDeEjercicios(String categoria) {
        ArrayList<ItemEjercicios> filtrado = new ArrayList<ItemEjercicios>();
        for (int i = 0; i < listaDeEjericios.size(); i++) {
            if (listaDeEjericios.get(i).getCategoria().equals(categoria)) {
                filtrado.add(listaDeEjericios.get(i));
            }
        }
        return filtrado;
    }

}



