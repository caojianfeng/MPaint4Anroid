package org.zcoding.canvas;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by caojianfeng on 16/3/20.
 */
public class CanvasView extends View {
    public CanvasView(Context context) {
        super(context);
        init();
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void initLayers(){
        BgLayer bgLayer = new BgLayer();
        layers.add(bgLayer);
    }

    private void init() {
        initLayers();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {

            }
            break;
            case MotionEvent.ACTION_MOVE: {

            }
            break;
            case MotionEvent.ACTION_UP: {

            }
            break;
        }
        return super.onTouchEvent(event);
    }

    ArrayList<Layer> layers = new ArrayList<>();

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        for(Layer layer:layers){
            layer.draw(canvas);
        }
    }
}
