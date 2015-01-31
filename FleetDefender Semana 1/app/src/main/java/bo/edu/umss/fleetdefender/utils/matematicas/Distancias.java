package bo.edu.umss.fleetdefender.utils.matematicas;

import bo.edu.umss.fleetdefender.core.framework.Punto;

/**
 * Created by eduardodisanti on 18/12/14.
 */
public class Distancias {

    public static double calcularDistancia(Punto a, Punto b) { // Implementación del teo de Pitágoras

        int deltax = Math.abs(a.getY() - b.getX());
        int deltay = Math.abs(a.getY() - b.getY());
        double hipotenusa = Math.sqrt(deltax^2 + deltay^2);

        return(hipotenusa);
    }

    public static float calcularPendiente(Punto a, Punto b) {   // Pendiente para ecuación de la recta por dos puntos

        int deltax = Math.abs(a.getY() - b.getX());
        int deltay = Math.abs(a.getY() - b.getY());

        float resp;
        if(deltay!=0) {
            resp = deltax / deltay;
        } else {
                resp = deltax;
        }

        return resp;
    }
}
