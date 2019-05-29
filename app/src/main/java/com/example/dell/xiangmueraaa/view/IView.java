package com.example.dell.xiangmueraaa.view;


import com.example.dell.xiangmueraaa.Fulibean;

import java.util.List;

/**
 * Created by DELL on 2019/5/29.
 */

public interface IView {
    void Yes(List<Fulibean.ResultsBean> fuli);
    void No(String error);
}
