package bo.edu.umss.fleetdefender.utils.matematicas;

import bo.edu.umss.fleetdefender.core.framework.Punto;

/**
 * Created by eduardodisanti on 19/12/14.
 */
public class Geometria {
    public static Punto puntoDeCircunferencia(int radio, int grados) { // Punto de la cfa de radio r y centro el origen

        double radianes = (grados * Math.PI) / 180;

        Long x = Math.round(radio * Math.cos(radianes));
        Long y = Math.round(radio * Math.sin(radianes));

        Punto p = new Punto();
        p.setX(x.intValue());
        p.setY(y.intValue());

        return p;
    }
}
