package com.example.administrator.traincode.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dell on 2015/11/9.
 */
public class LogoView extends View {
    private int mWidth,mHeight;
    public LogoView(Context context) {
        super(context);
    }

    public LogoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LogoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mWidth=getMeasuredWidth();
        mHeight=getMeasuredHeight();
        Paint paintCirle=new Paint();
        paintCirle.setStyle(Paint.Style.STROKE);
        paintCirle.setAntiAlias(true);
        paintCirle.setStrokeWidth(5);
        paintCirle.setTextSize(50);
        canvas.drawCircle(mWidth / 2, mHeight / 2, mWidth / 2, paintCirle);
        String Title="时刻表";
        canvas.drawText(Title,mWidth/2-paintCirle.measureText(Title)/2,
                (mHeight/2-mWidth/2)/2,paintCirle);
        Paint paintDegree=new Paint();
        paintCirle.setStrokeWidth(3);
        for(int i=0;i<24;i++)
        {
            if(i==0||i==6||i==12||i==18)
            {
                paintDegree.setStrokeWidth(5);
                paintDegree.setTextSize(30);
                canvas.drawLine(mWidth / 2, mHeight / 2 - mWidth / 2,
                        mWidth / 2, mHeight / 2 - mWidth / 2 + 60, paintDegree);
                String degree=String.valueOf(i);
                canvas.drawText(degree,mWidth/2-paintDegree.measureText(degree)/2,
                        mHeight/2-mWidth/2+90,paintDegree);
            }
            else{

                paintDegree.setStrokeWidth(3);
                paintDegree.setTextSize(15);

                canvas.drawLine(mWidth / 2, mHeight / 2 - mWidth / 2,
                        mWidth / 2, mHeight / 2 - mWidth / 2 + 30, paintDegree);
                String degree=String.valueOf(i);
                canvas.drawText(degree, mWidth / 2 - paintDegree.measureText(degree) / 2,
                        mHeight / 2 - mWidth / 2 + 60, paintDegree);

            }
            canvas.rotate(15,mWidth/2,mHeight/2);
        }
        // 画圆心
        Paint paintPointer = new Paint();
        paintPointer.setStrokeWidth(30);
        canvas.drawPoint(mWidth / 2, mHeight / 2, paintPointer);
        // 画指针
        Paint paintHour = new Paint();
        paintHour.setStrokeWidth(20);
        Paint paintMinute = new Paint();
        paintMinute.setStrokeWidth(10);
        //保存画布
        canvas.save();
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.drawLine(0, 0, 100, 100, paintHour);
        canvas.drawLine(0, 0, 100, 200, paintMinute);
        //合并图层操作
        canvas.restore();
    }
}
