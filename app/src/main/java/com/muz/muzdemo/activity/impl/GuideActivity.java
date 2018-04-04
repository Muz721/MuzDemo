package com.muz.muzdemo.activity.impl;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.muz.muzdemo.R;
import com.muz.muzdemo.activity.BaseActivity;
import com.muz.muzdemo.activity.MainActivity;
import com.muz.muzdemo.adapter.AdapterRecyclerViewMain;
import com.muz.muzdemo.adapter.ViewPagerAdapter;
import com.muz.muzdemo.adapter.ViewPagerDotAdapter;
import com.muz.muzdemo.adapter.ViewPagerGridViewAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Muz
 * @description viewpager
 * @date 2018/4/3 10:01
 */

public class GuideActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {


    @BindView(R.id.title_back_img)
    ImageView titleBackImg;
    @BindView(R.id.title_back)
    RelativeLayout titleBack;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.title_more_img)
    ImageView titleMoreImg;
    @BindView(R.id.title_more)
    RelativeLayout titleMore;
    @BindView(R.id.guide_viewpager)
    ViewPager guideViewpager;
    @BindView(R.id.guide_dot)
    RecyclerView guideDot;
int size=4;
    ViewPagerDotAdapter dotAdapter;
    public static final String PREFS_NAME="config";
    public static final String IS_FIRST="fist";
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_viewpager);




        titleBackImg.setImageResource(R.drawable.ic_chevron_left_black_24dp);
        titleName.setText("VIEWPAGER");

        int[] imgs = {R.color.colorAccent, R.color.colorPrimary, R.color.black, R.color.colorPrimaryDark};
        ArrayList<View> views = new ArrayList<View>();
        for (int i = 0; i < size; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.viewpager_item, null);
            ImageView img = (ImageView) view.findViewById(R.id.viewpager_item_img);
            TextView into=(TextView) view.findViewById(R.id.viewpager_item_into);
            if (i==size-1){
                into.setVisibility(View.VISIBLE);
                into.setOnClickListener(this);
            }
            img.setBackgroundResource(imgs[i]);
            views.add(view);

        }
        initView();
        ViewPagerAdapter adapter = new ViewPagerAdapter(views);
        guideViewpager.setOffscreenPageLimit(3);
        guideViewpager.setAdapter(adapter);
        guideViewpager.addOnPageChangeListener(this);
        guideViewpager.setCurrentItem(0);
    }
    private void initView() {
        if (size <= 1) {
            guideDot.setLayoutManager(new LinearLayoutManager(this));
        } else {
            guideDot.setLayoutManager(new GridLayoutManager(this, size));
        }
         dotAdapter=new ViewPagerDotAdapter(size,guideViewpager);

        guideDot.setAdapter(dotAdapter);
    }
    @OnClick({R.id.title_back, R.id.title_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.title_more:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        dotAdapter.setSelect(position);
        dotAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 移出监听
        guideViewpager.removeOnPageChangeListener(this);
    }

    @Override
    public void onClick(View view) {
switch (view.getId()){
    case R.id.viewpager_item_into:
        startActivity(MainActivity.class);
        break;
}
    }
}
