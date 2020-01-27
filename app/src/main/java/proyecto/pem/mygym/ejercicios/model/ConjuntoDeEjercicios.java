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
        listaDeEjericios.add(new ItemEjercicios("aperturas_mancuerna", "Apertura con mancuernas", "Pectorales", "Estirado sobre un banco estrecho para no molestar los movimientos de los hombros, mancuernas cogidas con las manos, brazos extendidos o codos ligeramente flexionados para aliviar la articulación: - Inspirar y después separar los brazos hasta la horizontal; - Elevar los brazos hasta la vertical expirando al mismo tiempo; - Provocar una pequeña contracción isométrica al final del movimiento para acentuar el trabajo sobre la parte esternal de los petorales."));

        listaDeEjericios.add(new ItemEjercicios("dominadas", "Tracción o dominadas en barra fija", "Espalda", "En suspensión en la barra fija, manos muy separadas en pronación: - Inspirar y efecturar una tracción hasta que la nuca llegue casi a tocar la barra. Espirar al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("polea_pecho", "Polea al pecho", "Espalda", "Sentado frente al aparato, piernas fijadas, barra cogida en pronación, manos muy separadas: - Inspirar y tirar de la barra hasta la horquilla esternal, ensanchando el pecho y llevando los codos hacia atrás. Espirar al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("polea_trasnuca", "Polea trasnuca", "Espalda", "Sentado de frenta al aparato, muslos fijados bajo los cojines, barra asida en pronación, manos muy separadas: - Inspirar y tirar de la barra hasta la nunca dirigiendo los codos hacia el tronco; - Espirar al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("remo_polea", "Remo en polea baja", "Espalda", "Sentado de cara al aparato, pies anclados, tronco flexionado: - Inspirar y llevar el mango hasta la base del esternón enderezando la espalda y tirando los codos hacia atrás lo mas lejos posible. Espirar al final del movimiento y regresar suavemente a la posición inicial."));
        listaDeEjericios.add(new ItemEjercicios("remo_horizontal", "Remo horizontal con barra, manos en pronación", "Espalda", "De pie, rodillas ligeramente flexionadas, tronco inclinado 45 grados, espalda bien recta, barra asida en pronación, manos separadas una distancia mayor a la anchura de los hombros, brazos colgando: - Inspirar, efectuar un bloqueo respiratorio y una contracción isométrica de la banda abdominal, tirar de la barra hasta el pecho; - Volver a la posición de partida y espirar."));
        listaDeEjericios.add(new ItemEjercicios("encogimiento_hombros_barra", "Encongimiento de hombros con barra", "Espalda", "De pie, piernas ligeramente separadas, cabeza bien recta o un poco inclinada hacia delante, brazos relajados paralelos al cuerpo, una mancuerna en cada mano: - Enconger los hombros efectuando una rotación antero-posterior, después volver a la posición inicial."));

        listaDeEjericios.add(new ItemEjercicios("press_trasnuca", "Press trasnuca con barra", "Hombros", "Sentado, espalda bien reta, barra cogida por detrás de la nuca, asida en pronación: - Inspirar y realizar un press vertical con la barra sin curvar demasiado los riñones, espirar al final del movimiento"));
        listaDeEjericios.add(new ItemEjercicios("press_frontal", "Press frontal con barra", "Hombros", "Sentado, espalda bien recta, barra cogida en pronación y apoyada sobre la parte alta del pecho: - Inspirar y desarrollar la barra verticalmente. Espirar al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("remo", "Remo al cuello, manos separadas", "Hombros", "manos separadas: De pie, piernas ligeramente separadas, espalda bien recta, barra cogida en proncación apoyada sobre los mulos, manos separadas un poco mas que la anchura de los hombros. - Inspirar y tirar de la barra hasta el mentón elevando los codos lo mas alto posible. Controlar el descenso de la barra evitando las sacudidas. Espirar al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("pajaro", "Elevaciones posteriores con polea baja, tronco inclinado hacia delante o Pájaro en polea", "Hombros", "De pie, las piernas separadas y ligeramente flexionadas, tronco inclinado hacia delante, manteniendo la espalda recta, los brazos colgando, mancuernas en las manos, codos ligeramente flexionados. - Elevar los brazos hasta la horizontal."));

        listaDeEjericios.add(new ItemEjercicios("curl_biceps_supinacion", "Curls de biceps alterno con supinación", "Brazos", "Sentado, una mancuerna en cada mano cogidas en semipronación: - Inspirar y flexionar los codos efectuando una rotación externa de la muñeca antes de que los antebrazos alcancen la horizontal; - Finalizar la flexión elevando los codos, espirar al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("curls_biceps_polea", "Curls de biceps con polea", "Brazos", "De pie, de cara al aparato, el mango cogido en supinación: - Inspirar y efecturar una flexión de los codos, espirar al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("extension_triceps", "Extension de triceps en polea alta", "Brazos", "De pie, de cara al aparato, manos en el mango, codos alineados con el cuerpo; - Efectuar una extensión de los codos procurando no separarlos del cuerpo. Espirar al final del movimiento"));
        listaDeEjericios.add(new ItemEjercicios("press_frances_mancuerna", "Press frances en banco plano con mancuerna", "Brazos", "Estirado sobre un plano horizontal on una mancuerna en cada mano, los codos flexionados: - Inspirar y efectuar una extensión de los codos, espirar al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("extension_vertical", "Extension vertical alternada de los codos con mancuerna", "Brazos", "Sentando o de pie, la mancuerna cogida con una mano, empezar detrás de la nuca: - Inspirar y efectuar una extensión del codo. Espirar al final del movimiento."));

        listaDeEjericios.add(new ItemEjercicios("flexion_rodillas", "Flexión de rodillas con mancuernas", "Piernas", "De pie, pies ligeramente separados, una mancuerna en cada mano, brazos relajados: - Mirar al frente, inspirar, hundir ligeramente la espalda y efectuar una flexión de las rodillas, - Cuando los femúr alcanzan la horizontal, realizar una extensión de las rodillas para volver a la posicón inicial. - Espirar al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("sentadillas", "Squat o sentadillas", "Piernas", "Barra colocada en el soporte, deslizarse por debajo y situarla sobre los trapecios un poco más alta que los deltoides posteriores, coger la barra con las manos con una separación que variará según las diferentes morfologías personales y tirar de los codos hacia atrás; - Inspirar profundamente (para mantener una presión intratorácica que impida que el busto se desplace hacia delante?. arquear ligeramente la espalda y contraer la banda abdominal, mirar reto hacia delante y retirar la barra del soporte. Retrocedes uno o dos pasos, detenerse con los pies paralelos (o las puntas un poco hacia fuera) a una distancia aproximadamente igual a la anchura de los hombros, agarrarse inclinando la espalda hacia delante (el eje de flexión debe pasar por la articulación coxofemoral) controlando la bajada y sin jamás curvar la columna vertebral para así evitar cualquier traumatismo; - Cuando los femúr alcancen la horizontal, efectuar una extensión de rodillas enderezando el tronco para recuperar la posición de partida. Expirar al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("presan", "Prensa de piernas inclinada", "Piernas", "Colocado sobre el aparato, espalda bien apoyada en el respaldo, pies medianamente separados: - Inspirar, desbloquear la seguridad y flexionar las rodillas al máximo hasta llevar los muslos sobre las costillas de la caja toráxica. Volver a la posición inicial expirando al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("extension", "Extensión de rodillas en máquina", "Piernas", "Sentando en la máquina, manos agarrando el asiento o los brazos del sillón para mantener el tronco inmóvil, rodillas flexionadas, tobillos colocados debajo de los cojines: - Inspirar y efectuar una extensión de las rodillas hasta la horizontal. Expirar al final del movimiento."));
        listaDeEjericios.add(new ItemEjercicios("curl_piernas", "Curl de piernas acostado", "Piernas", "Acostado boca abajo, las manos en los agarres, las piernas extendidas, tobillos ajustados en los cojines: - Inspirar y efectuar una flexión simultánea de las piernas intentando tocar los glúteos con los talones. Espirar al final del esfuerzo. Volver a la situación de partida controlando el movimiento"));


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



