package com.example.dell.xiangmueraaa.model;



import com.example.dell.xiangmueraaa.Fulibean;

import java.util.List;

/**
 * Created by DELL on 2019/5/29.
 */

public interface ICallback {
    void Yes(List<Fulibean.ResultsBean> fuli);
    void No(String error);
}
