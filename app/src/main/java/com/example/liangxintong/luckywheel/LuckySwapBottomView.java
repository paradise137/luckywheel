package com.example.liangxintong.luckywheel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.concurrent.ScheduledExecutorService;

@SuppressLint("AppCompatCustomView")
public class LuckySwapBottomView extends ImageView {

    public static final int BACKGROUNDRED = 1;
    public static final int BACKGROUNDGREY = 2;

    ScheduledExecutorService nScheduledService;

    public LuckySwapBottomView(Context context) {
        super(context);
    }

    public LuckySwapBottomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LuckySwapBottomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LuckySwapBottomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void uodateBackgroundState(int nType) {

        if (nScheduledService != null && !nScheduledService.isShutdown()) {
            nScheduledService.shutdown();
        }

        if (nType == BACKGROUNDRED) {

            this.setImageResource(R.drawable.lucky_node);

        } else if (nType == BACKGROUNDGREY) {

            this.setImageResource(R.drawable.lucky_grey_node);

        }

    }
}

