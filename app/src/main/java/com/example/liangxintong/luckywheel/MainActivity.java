package com.example.liangxintong.luckywheel;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<RecyclerViewData> recyclerViewDataList = new ArrayList<>();

    LuckySwapImageView mLuckySwapView;
    LuckySwapBottomView nLuckySwapView;
    PointView mPointView;
    CircleView mCircleView;

    private ProgressBar progressBar;
    private RelativeLayout mtextview;
    private RelativeLayout ntextview;
    private View buttonview;

    int mNum = 0;
    int i = 0;
    float mHorizentalMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHorizentalMove = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.dp_142), getResources().getDisplayMetrics());

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mtextview = (RelativeLayout) findViewById(R.id.record);
        ntextview = (RelativeLayout) findViewById(R.id.gift);
        buttonview = (View) findViewById(R.id.button_view);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        nLuckySwapView = (LuckySwapBottomView) this.findViewById(R.id.pointview);

        mLuckySwapView = (LuckySwapImageView) this.findViewById(R.id.luckyswapview);

        nLuckySwapView.uodateBackgroundState(LuckySwapBottomView.BACKGROUNDRED);

        mLuckySwapView.uodateCurrentState(LuckySwapImageView.STATEFREEBLING);

        mCircleView = (CircleView) this.findViewById(R.id.circleView);

        nLuckySwapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RotateAnimation mRotateAnimation = new RotateAnimation(0, 3600, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                mRotateAnimation.setDuration(10000);
                mRotateAnimation.setInterpolator(new LinearInterpolator());
                mRotateAnimation.setRepeatCount(Animation.INFINITE);
                mCircleView.startAnimation(mRotateAnimation);

                if (mNum == 0) {
                    nLuckySwapView.uodateBackgroundState(LuckySwapBottomView.BACKGROUNDRED);
                    mLuckySwapView.uodateCurrentState(LuckySwapImageView.STATELOADING);
                    if (progressBar.getVisibility() == View.GONE)
                        progressBar.setVisibility(View.VISIBLE);
                    mNum = 1;
                    i++;
                } else if (mNum == 1) {
                    nLuckySwapView.uodateBackgroundState(LuckySwapBottomView.BACKGROUNDGREY);
                    mLuckySwapView.uodateCurrentState(LuckySwapImageView.STATEFREERUNNING);
                    if (progressBar.getVisibility() == View.VISIBLE)
                        progressBar.setVisibility(View.GONE);
                    mNum = 2;
                } else if (mNum == 2) {
                    nLuckySwapView.uodateBackgroundState(LuckySwapBottomView.BACKGROUNDRED);
                    mLuckySwapView.uodateCurrentState(LuckySwapImageView.STATECOSTBLING);
                    mNum = 3;
                } else if (mNum == 3) {
                    nLuckySwapView.uodateBackgroundState(LuckySwapBottomView.BACKGROUNDRED);
                    mLuckySwapView.uodateCurrentState(LuckySwapImageView.STATELOADING);
                    if (progressBar.getVisibility() == View.GONE)
                        progressBar.setVisibility(View.VISIBLE);
                    mNum = 4;
                } else if (mNum == 4) {
                    nLuckySwapView.uodateBackgroundState(LuckySwapBottomView.BACKGROUNDGREY);
                    mLuckySwapView.uodateCurrentState(LuckySwapImageView.STATECOSTRUNNING);
                    if (progressBar.getVisibility() == View.VISIBLE)
                        progressBar.setVisibility(View.GONE);
                    mNum = 2;
                }
            }
        });

        ntextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonview.animate().translationX(mHorizentalMove).setDuration(150).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        mtextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonview.animate().translationX(0).setDuration(150).setInterpolator(new AccelerateDecelerateInterpolator());
                ;
            }
        });

        //RecyclerView第一次尝试

        initRecyclerViewData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view_1);
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(recyclerViewDataList);
        recyclerView.setAdapter(adapter);

    }

        private void initRecyclerViewData() {
            RecyclerViewData first = new RecyclerViewData("Liuhuang333…", "0.01 ETH", "2018.12.28 10:30:28");
            recyclerViewDataList.add(first);
            RecyclerViewData first1 = new RecyclerViewData("Liuhuang333…", "100 KCASH", "2018.12.28 10:33:09");
            recyclerViewDataList.add(first1);
            RecyclerViewData first2 = new RecyclerViewData("Liuhuang333…", "100 IOST", "2018.12.29 24:30:44");
            recyclerViewDataList.add(first2);
            RecyclerViewData first3 = new RecyclerViewData("Liuhuang333…", "1000 MT", "2018.12.29 24:30:56");
            recyclerViewDataList.add(first3);
            RecyclerViewData first4 = new RecyclerViewData("Liuhuang333…", "0.1 DGD", "2018.12.30 08:42:06");
            recyclerViewDataList.add(first4);
        }

}
