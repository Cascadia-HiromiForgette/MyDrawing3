package com.example.hiromi.mydrawing3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Hiromi on 10/22/2015.
 */
public class SimplyDrawnView extends View {

    private Paint mPaint;
    private Path mPath;
    private float mWidth, mHeight;

    public SimplyDrawnView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        mPaint = new Paint();
        mPath = new Path();
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE); //draw background

        //Draw line
        mPaint.setColor(Color.BLACK);
        canvas.drawLine(mWidth, 0, 200, mHeight, mPaint);

        //Draw red line
        mPaint.setColor(Color.RED); mPaint.setStrokeWidth(10);
        canvas.drawLine(1, 2, 100, 200, mPaint);

        //Draw 5 green lines
        mPaint.setColor(Color.GREEN); mPaint.setStrokeWidth(14);
        for (int i = 0; i < 5; i++){
            canvas.drawLine(0, 10+(i*10), mWidth, 10+(i*10), mPaint);
            mPaint.setARGB(255 - (i * 30), 80, 255 - (i * 15), 80);
        }


        //Draw Text
        mPaint.setTextSize(70);
        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.CYAN);
        canvas.drawText("I am drawing", 500, 600, mPaint);

        //Draw Text on a Path
        mPaint.setTextSize(70);
        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.MAGENTA);

        RectF oval = new RectF(200, 700, 1000, 1500); // (upper left x, upper left Y, lower right x, lower right y)
        mPath.addArc(oval,90, 270);
        canvas.drawTextOnPath("drawing on a Path can be lots of fun", mPath, 40, 50, mPaint);

        //Draw filled, opaque, and open ovals
        //canvas.drawOval();

        // Circle with black outline
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        RectF oval1 = new RectF(500, 50, 800, 350);
        canvas.drawOval(oval1, mPaint);

        // Grey opaque circle
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.GRAY);
        mPaint.setAlpha(50);
        RectF oval2 = new RectF(500, 50, 800, 350);
        canvas.drawOval(oval2, mPaint);

        // Red small circle
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        RectF oval3 = new RectF(650, 200,670, 220);
        canvas.drawOval(oval3, mPaint);

        //Draw bee bitmap
        Drawable b = getResources().getDrawable(R.drawable.bee,null);

        int x=50, y=200;
        b.setBounds(x, y, x + b.getIntrinsicWidth() / 2, y + getBackground().getIntrinsicHeight() / 2);
        b.draw(canvas);

        //ShapeDrawable s = new ShapeDrawable(new OvalShape());
        //s.setBounds(u, v, u+500, v+150);


    }
}
