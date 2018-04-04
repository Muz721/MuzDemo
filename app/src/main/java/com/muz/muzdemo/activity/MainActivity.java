package com.muz.muzdemo.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.muz.muzdemo.R;
import com.muz.muzdemo.activity.impl.GuideActivity;
import com.muz.muzdemo.adapter.AdapterRecyclerViewMain;
import com.muz.muzdemo.entity.ModelMainItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.demo_classify)
    RecyclerView demoClassify;
    @BindView(R.id.title_name)
    TextView titleName;
    private List<ModelMainItem> demoClassifyData;
    private int mColumnCount = 3;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);
        titleName.setText("DEMO CLASSIFY");
        initData();
        initView();
    }

    private void initData() {
        demoClassifyData = new ArrayList<>();
        demoClassifyData.add(new ModelMainItem("Viewpager", R.drawable.muz, GuideActivity.class));
    }

    private void initView() {
        if (mColumnCount <= 1) {
            demoClassify.setLayoutManager(new LinearLayoutManager(this));
        } else {
            demoClassify.setLayoutManager(new GridLayoutManager(this, mColumnCount));
        }

//        demoClassify.addItemDecoration(new MuzRecyclerViewDividerTool(RxImageTool.dp2px(5f)));
        AdapterRecyclerViewMain recyclerViewMain = new AdapterRecyclerViewMain(demoClassifyData);

        demoClassify.setAdapter(recyclerViewMain);
    }
}
