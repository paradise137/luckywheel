package com.example.liangxintong.luckywheel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SuppressLint("AppCompatCustomView")
public class LuckySwapImageView extends ImageView {

    public static final int STATEFREEBLING = 1;
    public static final int STATECOSTBLING = 2;
    public static final int STATELOADING = 3;
    public static final int STATEFREERUNNING = 4;
    public static final int STATECOSTRUNNING = 5;

    int mCurrentImageState = 0;

    ScheduledExecutorService mScheduledService;

    public LuckySwapImageView(Context context) {
        super(context);
    }

    public LuckySwapImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LuckySwapImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LuckySwapImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public void uodateCurrentState(int mType) {

        if (mScheduledService != null && !mScheduledService.isShutdown()) {
            mScheduledService.shutdown();
        }

        if (mType == STATEFREEBLING) {

            this.setImageResource(R.drawable.lucky_btn_free_yellow);

            mScheduledService = Executors.newSingleThreadScheduledExecutor();
            mScheduledService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {

                    if (mCurrentImageState == 0) {
                        setImageResource(R.drawable.lucky_btn_free_red);
                        mCurrentImageState = 1;
                    } else {
                        setImageResource(R.drawable.lucky_btn_free_yellow);
                        mCurrentImageState = 0;
                    }

                }
            }, 50, 150, TimeUnit.MILLISECONDS);

        } else if (mType == STATECOSTBLING) {

            this.setImageResource(R.drawable.lucky_btn_cost_yellow);

            mScheduledService = Executors.newSingleThreadScheduledExecutor();
            mScheduledService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {

                    if (mCurrentImageState == 0) {
                        setImageResource(R.drawable.lucky_btn_cost_red);
                        mCurrentImageState = 1;
                    } else {
                        setImageResource(R.drawable.lucky_btn_cost_yellow);
                        mCurrentImageState = 0;
                    }

                }
            }, 50, 150, TimeUnit.MILLISECONDS);

        } else if (mType == STATELOADING) {

            this.setImageResource(R.drawable.lucky_btn_loading);

        } else if (mType == STATEFREERUNNING) {

            this.setImageResource(R.drawable.lucky_btn_free_grey);

        } else if (mType == STATECOSTRUNNING) {

            this.setImageResource(R.drawable.lucky_btn_cost_grey);
        }

    }

}
