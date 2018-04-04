package com.muz.muzdemo.activity.impl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.muz.muzdemo.R;
import com.muz.muzdemo.activity.BaseActivity;
import com.muz.muzdemo.activity.MainActivity;

/**
 * @description  logo页面
 * @author  Muz
 * @date  2018/4/4 16:33
 */

public class LogoActivity extends BaseActivity {
    public static final String PREFS_NAME="config";
    public static final String IS_FIRST="fist";

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_logo);
        SharedPreferences sharedPreferences=this.getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        boolean flag=sharedPreferences.getBoolean(IS_FIRST,true);//判断是不是第一次进这个软件
        if (flag) {
            startActivity(GuideActivity.class);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(IS_FIRST,false);
            editor.commit();
            this.finish();
            // overridePendingTransition(R.anim.anim_guide,R.anim.anim_guangbo_into);

        }else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(6000);//这个界面只停留3秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(MainActivity.class);
                            finish();
                        }
                    });
                }
            }){}.start();
        }
    }
}
