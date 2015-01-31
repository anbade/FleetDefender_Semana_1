package bo.edu.umss.fleetdefender.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by eduardodisanti on 19/12/14.
 */
public class ArcadeSurface extends SurfaceView {

    private SurfaceHolder sHolder;
    private int ticDeRadar = 0;
    private ArcadeSurfaceThread gameThread;

    public ArcadeSurface(Context ctx) {
        super(ctx);

        begin();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        UIConsolaRadar uiConsolaRadar = new UIConsolaRadar();
        uiConsolaRadar.dibujarConsola(canvas, ticDeRadar);
    }

    public void ticDeRadar() {

        ticDeRadar++;
        if(ticDeRadar>359) {
            ticDeRadar = 0;
        }
    }

    public void dibujar(Canvas canvas) {

        canvas.drawColor(Color.BLACK);
        UIConsolaRadar uiConsolaRadar = new UIConsolaRadar();
        uiConsolaRadar.dibujarConsola(canvas, ticDeRadar);
    }

    private void begin() {

        gameThread = new ArcadeSurfaceThread(this);
        sHolder = getHolder();
        sHolder.addCallback(new SurfaceHolder.Callback() {

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                gameThread.setRunning(false);
            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {

                gameThread.setRunning(true);
                gameThread.start();

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format,
                                       int width, int height) {
            }
        });
    }


}
