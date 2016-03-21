package org.zcoding.canvas;

import android.graphics.Canvas;

/**
 * Created by caojianfeng on 16/3/20.
 */
public class Layer {

    public void draw(Canvas canvas) {

    }

    public void setLock(boolean lock) {

    }

    public boolean isLocked() {
        return true;
    }

    public void setVisible(boolean visible) {

    }

    public boolean isVisible() {
        return true;
    }

    public Layer copy() {
        return new Layer();
    }

    public void mergTo(Layer belowLayer) {

    }

}
