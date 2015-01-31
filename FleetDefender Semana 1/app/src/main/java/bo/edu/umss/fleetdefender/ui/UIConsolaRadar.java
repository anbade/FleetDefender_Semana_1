package bo.edu.umss.fleetdefender.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import bo.edu.umss.fleetdefender.core.framework.Punto;
import bo.edu.umss.fleetdefender.utils.matematicas.Geometria;

/**
 * Created by eduardodisanti on 19/12/14.
 */
public class UIConsolaRadar {

    public static void dibujarConsola(Canvas canvas, int ticDeRadar) {


        int ancho = canvas.getWidth();
        int alto  = canvas.getHeight();

        int gap = ancho / 6;

        int origenX = ancho / 2;
        int origenY = alto - (alto  / 7);

        Paint p = new Paint();
        p.setStrokeWidth(1);
        p.setStyle(Paint.Style.STROKE);

        int radio = gap;
        p.setColor(Color.RED);
        canvas.drawCircle(origenX, origenY, gap, p);

        //radio+=gap;

        for(int x = origenX; x<alto; x+=gap) {
            if(radio < gap * 4) {
                p.setColor(Color.CYAN);
            } else {
                p.setColor(Color.GREEN);
            }
            radio+=gap;
            canvas.drawCircle(origenX, origenY, radio, p);
        }

        p.setColor(Color.GRAY);

        Punto punto = Geometria.puntoDeCircunferencia(alto, ticDeRadar);


        canvas.drawLine(punto.getX(), punto.getY(), origenX, origenY, p);
    }
}
