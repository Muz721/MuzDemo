package com.muz.muzdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import com.muz.muzdemo.R;



public class ViewPagerGridViewAdapter extends BaseAdapter {
    Context context;
    private  int select=0;
    private int size;
    public ViewPagerGridViewAdapter(Context context){
        this.context=context;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public void setSelect(int select) {
        this.select = select;
    }
    @Override
    public int getCount() {
        return size;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hondler hondler=null;
        if (null == convertView) {
            hondler=new Hondler();
            convertView= LayoutInflater.from(context).inflate(R.layout.viewpager_dot,parent,false);
            hondler.dot= (ImageView) convertView.findViewById(R.id.viewpager_item_dot);
            convertView.setTag(hondler);
        }
        else {
            hondler= (Hondler) convertView.getTag();
        }

        if (select==position){
            hondler.dot.setImageResource(R.drawable.ic_select_lens_black_24dp);
        }else {
            hondler.dot.setImageResource(R.drawable.ic_lens_black_24dp);
        }
        return convertView;
    }
    private class Hondler{
        ImageView dot;
    }
}
