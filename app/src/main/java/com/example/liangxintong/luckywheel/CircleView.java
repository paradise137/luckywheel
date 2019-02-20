package com.example.liangxintong.luckywheel;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;


public class CircleView extends View {

    float circleRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.dp_158), getResources().getDisplayMetrics());
    float mcircleRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.dp_153), getResources().getDisplayMetrics());
    float banjing = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.dp_153), getResources().getDisplayMetrics());
    float banjing2 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.dp_107), getResources().getDisplayMetrics());
    float Radius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.dp_103), getResources().getDisplayMetrics());
    float nRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.dp_102), getResources().getDisplayMetrics());
    float Ra = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.dp_78), getResources().getDisplayMetrics());
    float nRa = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.dp_77), getResources().getDisplayMetrics());
    float mRa = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.dp_52), getResources().getDisplayMetrics());
    float mOutSideTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sp_18), getResources().getDisplayMetrics());
    float mInSideTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sp_8), getResources().getDisplayMetrics());

    static String mSimgleArcColor = "#3a312a";
    static String mDoubleArcColor = "#342629";
    private String[] mDeses = new String[]{"ETH", "DGD", "MCO"
            , "MANA", "BLZ", "KCASH",
            "IOST", "MT"};
    private String[] nDeses = new String[]{/*ETH*/"0.1", "0.01",/*DGD*/"10", "1", "0.1",/*MCO*/"10", "1", "0.1",/*MANA*/"300", "30", "3",/*BLZ*/"300", "30", "3",/*KCASH*/"1k", "100", "10",/*IOST*/"1k", "100", "10",/*MT*/"10k", "1k", "10",/*ETH*/"1"};


    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Log.v("Circle View", "on draw");

        int verticalCenter = getHeight() / 2;
        int horizontalCenter = getWidth() / 2;
        int i;
        int mAngle = 44;
        int nAngle = 14;

        Paint mPaint = new Paint();
        Paint mTextPaint;
        mPaint.setAntiAlias(true);
        //外圆环
        mPaint.setColor(Color.parseColor("#E3D996"));
        canvas.drawCircle(horizontalCenter, verticalCenter, circleRadius, mPaint);//外圈圆

        mPaint.setColor(Color.parseColor("#988043"));
        canvas.drawCircle(horizontalCenter, verticalCenter, mcircleRadius, mPaint);//内圈圆  两个圆组成圆环

        //画扇形
        double startAngle = -mAngle / 2 - 90;
        ;
        int mArcLength = 8;

        for (i = 0; i < mArcLength; i++) {

            if (i % 2 == 0) {
                mPaint.setColor(Color.parseColor(mDoubleArcColor));
            } else {
                mPaint.setColor(Color.parseColor(mSimgleArcColor));
            }

            RectF rect = new RectF(horizontalCenter - mcircleRadius, verticalCenter - mcircleRadius, horizontalCenter + mcircleRadius, verticalCenter + mcircleRadius);
            canvas.drawArc(rect, (float) startAngle, mAngle, true, mPaint);
            startAngle = startAngle + mAngle + 1;

        }
        //从外向内第二个圆环
        mPaint.setColor(Color.parseColor("#E3D996"));
        canvas.drawCircle(horizontalCenter, verticalCenter, Radius, mPaint);
        mPaint.setColor(Color.parseColor("#988043"));
        canvas.drawCircle(horizontalCenter, verticalCenter, nRadius, mPaint);

        //画24个小扇形
        int nArcLength = 24;

        for (i = 0; i < nArcLength; i++) {
            if (i % 3 == 0) {
                if (i % 2 == 0)
                    mPaint.setColor(Color.parseColor(mDoubleArcColor));
                else
                    mPaint.setColor(Color.parseColor(mSimgleArcColor));
            } else if (i % 3 == 1) {
                if (i % 2 == 1)
                    mPaint.setColor(Color.parseColor(mDoubleArcColor));
                else
                    mPaint.setColor(Color.parseColor(mSimgleArcColor));
            } else if (i % 3 == 2) {
                if (i % 2 == 0)
                    mPaint.setColor(Color.parseColor(mDoubleArcColor));
                else
                    mPaint.setColor(Color.parseColor(mSimgleArcColor));
            }
            RectF rect = new RectF(horizontalCenter - nRadius, verticalCenter - nRadius, horizontalCenter + nRadius, verticalCenter + nRadius);
            canvas.drawArc(rect, (float) startAngle, nAngle, true, mPaint);
            startAngle = startAngle + nAngle + 1;
        }

        //外向内第三个圆环
        mPaint.setColor(Color.parseColor("#E3D996"));
        canvas.drawCircle(horizontalCenter, verticalCenter, Ra, mPaint);
        mPaint.setColor(Color.parseColor("#988043"));
        canvas.drawCircle(horizontalCenter, verticalCenter, nRa, mPaint);

        for (i = 0; i < mArcLength; i++) {

            if (i % 2 == 0) {
                mPaint.setColor(Color.parseColor(mDoubleArcColor));
            } else {
                mPaint.setColor(Color.parseColor(mSimgleArcColor));
            }

            RectF rect = new RectF(horizontalCenter - nRa, verticalCenter - nRa, horizontalCenter + nRa, verticalCenter + nRa);
            canvas.drawArc(rect, (float) startAngle, mAngle, true, mPaint);
            startAngle = startAngle + mAngle + 1;

            mPaint.setColor(Color.parseColor("#000000"));
            canvas.drawCircle(horizontalCenter, verticalCenter, mRa, mPaint);
        }

        //文字画笔
        mTextPaint = new Paint();
        //设置填充样式
        mTextPaint.setStyle(Paint.Style.FILL);
        //设置抗锯齿
        mTextPaint.setAntiAlias(true);
        //设置边界模糊
        mTextPaint.setDither(false);
        //写文字：外圈大文字
        startAngle = -mAngle / 2 - 90;

        mTextPaint.setTextSize(mOutSideTextSize);
        mTextPaint.setFakeBoldText(true);

        for (i = 0; i < mDeses.length; i++) {
            drawText(startAngle, mDeses[i], banjing, mTextPaint, canvas);
            startAngle = startAngle + mAngle + 1;
        }

        //写文字：24个小文字
        mTextPaint.setTextSize(mInSideTextSize);
        mTextPaint.setFakeBoldText(true);
        startAngle = -nAngle / 2 - 90;
        for (i = 0; i < nDeses.length; i++) {
            drawText1(startAngle, nDeses[i], banjing2, mTextPaint, canvas);
            startAngle = startAngle + nAngle + 1;
        }

    }

    private void drawText(double startAngle, String string, float mcircleRadius, Paint textPaint, Canvas canvas) {

        textPaint.setColor(Color.parseColor("#E2D794"));
        int verticalCenter = getHeight() / 2;
        int horizontalCenter = getWidth() / 2;
        float mAngle = 44;
        Path circlePath = new Path();
        RectF rect = new RectF(horizontalCenter - mcircleRadius, verticalCenter - mcircleRadius, horizontalCenter + mcircleRadius, verticalCenter + mcircleRadius);
        circlePath.addArc(rect, (float) startAngle, mAngle);
        float textWidth = textPaint.measureText(string);

        textPaint.setLetterSpacing(0.2f);

        Log.v("circle view", "circle mAngle ->" + mAngle);
        Log.v("circle view", "circle mcircleRadius ->" + mcircleRadius);

        double mArcLengthWhole = (float) (((mAngle / 180) * Math.PI) * mcircleRadius);

        canvas.drawTextOnPath(string, circlePath, (float) (mArcLengthWhole / 2 - textWidth / 2), (float) (mcircleRadius / 4.5), textPaint);
    }

    private void drawText1(double startAngle, String string, float nRadius, Paint textPaint, Canvas canvas) {

        textPaint.setColor(Color.parseColor("#E2D794"));
        int verticalCenter = getHeight() / 2;
        int horizontalCenter = getWidth() / 2;
        float nAngle = 14;
        Path circlePath = new Path();
        RectF rect = new RectF(horizontalCenter - nRadius, verticalCenter - nRadius, horizontalCenter + nRadius, verticalCenter + nRadius);
        circlePath.addArc(rect, (float) startAngle, nAngle);
        float textWidth = textPaint.measureText(string);
        textPaint.setLetterSpacing(0.2f);
        double mArcLengthWhole = (float) (((nAngle / 180) * Math.PI) * nRadius);
        Log.v("circle view", "circle width 2->" + mArcLengthWhole);
        canvas.drawTextOnPath(string, circlePath, (float) (mArcLengthWhole / 2 - textWidth / 2), (float) (nRadius / 5.5), textPaint);
    }

}