package com.example.dell.xiangmueraaa.model;


import com.example.dell.xiangmueraaa.ApiService;
import com.example.dell.xiangmueraaa.Fulibean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DELL on 2019/5/29.
 */

public class Modelmpl implements IModel{
    @Override
    public void chun(final ICallback iCallback, int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.fuliurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofit.create(ApiService.class).fuliinit(page).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Fulibean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Fulibean fulibean) {
                        List<Fulibean.ResultsBean> results = fulibean.getResults();
                        iCallback.Yes(results);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iCallback.No(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
