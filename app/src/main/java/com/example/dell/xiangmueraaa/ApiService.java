package com.example.dell.xiangmueraaa;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by DELL on 2019/5/29.
 */

public interface ApiService {
    String fuliurl="http://gank.io/api/";
    @GET("data/%E7%A6%8F%E5%88%A9/10/{page}")
    Observable<Fulibean> fuliinit(@Path("page") int page);
}
