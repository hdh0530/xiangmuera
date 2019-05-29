package com.example.dell.xiangmueraaa;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dell.xiangmueraaa.presenter.Presentermpl;
import com.example.dell.xiangmueraaa.view.IView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView{

    private RecyclerView xr;
    private SmartRefreshLayout sm;
    private Myadpater mMyadpater;
    private Presentermpl mPresentermpl;
    int page=1;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }
    private void initData() {
        mPresentermpl = new Presentermpl(this);
        mPresentermpl.liu(page);
    }

    private void initView() {
        xr = (RecyclerView) findViewById(R.id.xr);
        sm = (SmartRefreshLayout) findViewById(R.id.sm);
        xr.setLayoutManager(new LinearLayoutManager(this));
        mMyadpater = new Myadpater(this);
        xr.setAdapter(mMyadpater);
        sm.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPresentermpl.liu(page);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPresentermpl.liu(page);
            }
        });
    }

    @Override
    public void Yes(List<Fulibean.ResultsBean> fuli) {
        if (page==1){
            mMyadpater.addData(fuli);
            sm.finishRefresh();
        }else {
            mMyadpater.resreDa(fuli);
            sm.finishLoadMore();
        }
    }

    @Override
    public void No(String error) {
        Log.d(TAG, error);
    }
}
