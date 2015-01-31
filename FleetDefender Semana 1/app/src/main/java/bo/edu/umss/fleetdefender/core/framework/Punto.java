package bo.edu.umss.fleetdefender.core.framework;

/**
 * Created by eduardodisanti on 18/12/14.
 */
public class Punto {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean esIgual(Punto posicion) {

        return (posicion.getX()==x && posicion.getY()==y);
    }
}
