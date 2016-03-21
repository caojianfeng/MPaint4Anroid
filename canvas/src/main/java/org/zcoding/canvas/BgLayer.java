package org.zcoding.canvas;

import android.graphics.Canvas;

/**
 * Created by caojianfeng on 16/3/20.
 */
public class BgLayer extends Layer {

    private CanvasBgGrid bgGrid = new CanvasBgGrid();

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        bgGrid.update(canvas);
        bgGrid.draw(canvas);
    }
}
