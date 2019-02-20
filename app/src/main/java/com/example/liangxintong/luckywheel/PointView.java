package com.example.liangxintong.luckywheel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

@SuppressLint("AppCompatCustomView")
public class PointView extends ImageView {
    public PointView(Context context) {
        super(context);
    }

    public PointView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PointView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setPointState(){
        this.setImageResource(R.drawable.lucky_node);
    }

}
