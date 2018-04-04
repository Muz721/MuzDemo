package com.muz.muzdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.muz.muzdemo.R;
import com.muz.muzdemo.entity.ModelMainItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ViewPagerDotAdapter extends RecyclerView.Adapter<ViewPagerDotAdapter.ViewHolder> {

    private int mScreenWidth, mItemWidth, mItemHeight;
    private Context context;
    private int size;
    private  int select=0;
    private ViewPager viewPager;
    public ViewPagerDotAdapter(int size, ViewPager viewPager) {
        this.size = size;
        this.viewPager=viewPager;
    }
    public void setSelect(int select) {
        this.select = select;
    }
    @Override
    public ViewPagerDotAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpager_dot, parent, false);
        context = view.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        if (select==position){
holder.dot.setImageResource(R.drawable.ic_select_lens_black_24dp);

        }else {
            holder.dot.setImageResource(R.drawable.ic_lens_black_24dp);
        }
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return size;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        @BindView(R.id.viewpager_item_dot)
        ImageView dot;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }
    }
}
