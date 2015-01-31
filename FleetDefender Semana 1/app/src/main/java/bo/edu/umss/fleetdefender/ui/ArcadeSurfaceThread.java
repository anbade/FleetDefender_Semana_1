package bo.edu.umss.fleetdefender.ui;

import android.graphics.Canvas;


/**
 * Created by eduardodisanti on 19/12/14.
 */
public class ArcadeSurfaceThread extends Thread {

    private boolean running = false;
    private ArcadeSurface aView;

    public ArcadeSurfaceThread(ArcadeSurface aView) {
        this.aView = aView;
    }

    public void setRunning(boolean b) {

        running = b;
    }

    @Override
    public void run() {
        while (running) {
            Canvas c = null;
            try {
                c = aView.getHolder().lockCanvas(null);
                synchronized (aView.getHolder()) {
                    if(c!=null) {
                        aView.dibujar(c);
                    }
                }
            } finally {
                if (c != null) {
                    aView.getHolder().unlockCanvasAndPost(c);
                    try {
                        sleep(20);
                        aView.ticDeRadar();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
