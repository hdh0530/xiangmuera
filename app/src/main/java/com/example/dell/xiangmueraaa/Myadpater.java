package com.example.dell.xiangmueraaa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2019/5/29.
 */

class Myadpater extends RecyclerView.Adapter<Myadpater.ViewHolder> {
    private Context mContext;
    private ArrayList<Fulibean.ResultsBean> shuju = new ArrayList<>();

    public Myadpater(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fulibean.ResultsBean bean = shuju.get(position);
        holder.tv.setText(bean.getDesc());
        Glide.with(mContext).load(bean.getUrl()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return shuju.size();
    }

    public void addData(List<Fulibean.ResultsBean> fuli) {
        shuju.clear();
        shuju.addAll(fuli);
        notifyDataSetChanged();
    }

    public void resreDa(List<Fulibean.ResultsBean> fuli) {
        shuju.addAll(fuli);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView iv;
        private final TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
