package org.zcoding.canvas;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import java.util.ArrayList;

/**
 * Created by caojianfeng on 16/3/20.
 */
public class CanvasBgGrid {

    int w;
    int h;

    Paint originPaint;
    Paint mainPaint;
    Paint subPaint;
    Paint bgPaint;

    private static final int STEP = 10;

    private static final int ORIGIN_COLOR = 0xff5f8dd3;
    private static final int MAIN_COLOR = 0xff87aade;
    private static final int SUB_COLOR = 0xffafc6e9;
    private static final int BACK_COLOR = 0xffd7e3f4;

    public CanvasBgGrid() {
        originPaint = new Paint();
        originPaint.setStrokeWidth(2);
        originPaint.setColor(ORIGIN_COLOR);

        mainPaint = new Paint();
        mainPaint.setStrokeWidth(1);
        mainPaint.setColor(MAIN_COLOR);

        subPaint = new Paint();
        subPaint.setStrokeWidth(0);
        subPaint.setColor(SUB_COLOR);

        bgPaint = new Paint();
        bgPaint.setColor(BACK_COLOR);

    }

    public static class Line {

        Line(int fromX, int fromY, int toX, int toY, PaintStyle paintStyle) {
            from = new Point(fromX, fromY);
            to = new Point(toX, toY);
            this.paintStyle = paintStyle;
        }

        public enum PaintStyle {
            Origin,
            Main,
            Sub
        }

        Point from;
        Point to;
        PaintStyle paintStyle;
    }

    private ArrayList<Line> lines = new ArrayList<>();

    void update(Canvas canvas) {
        int newW = canvas.getWidth();
        int newH = canvas.getHeight();
        if (w == newW && h == newH) {
            return;
        }
        lines.clear();
        w = newW;
        h = newH;

        int centerX = w / 2;
        int centerY = h / 2;

        int vLineCount = centerX / STEP;
        int hLineCount = centerY / STEP;

        for (int i = 0; i < vLineCount; i++) {

            int x = centerX + i * STEP;
            lines.add(new Line(x, 0, x, h, getPaintStyleByIndex(i)));

            if (i == 0) {
                continue;
            }

            x = centerX - i * STEP;
            lines.add(new Line(x, 0, x, h, getPaintStyleByIndex(i)));

        }

        for (int i = 0; i < hLineCount; i++) {

            int y = centerY + i * STEP;
            lines.add(new Line(0, y, w, y, getPaintStyleByIndex(i)));

            if (i == 0) {
                continue;
            }

            y = centerY - i * STEP;
            lines.add(new Line(0, y, w, y, getPaintStyleByIndex(i)));
        }
    }

    Line.PaintStyle getPaintStyleByIndex(int index) {

        Line.PaintStyle style = Line.PaintStyle.Sub;

        if (index == 0) {
            style = Line.PaintStyle.Origin;
        } else if (index % 10 == 0) {
            style = Line.PaintStyle.Main;
        }
        return style;
    }

    public void draw(Canvas canvas) {

        canvas.drawColor(BACK_COLOR);

        for (Line line : lines) {

            Paint linePaint = new Paint();

            switch (line.paintStyle) {
                case Origin: {
                    linePaint = originPaint;
                }
                break;
                case Main: {
                    linePaint = mainPaint;
                }
                break;
                case Sub: {
                    linePaint = subPaint;
                }
                break;
            }

            canvas.drawLine(line.from.x, line.from.y, line.to.x, line.to.y, linePaint);

        }
    }


}
