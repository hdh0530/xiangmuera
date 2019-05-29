package com.example.dell.xiangmueraaa.presenter;


import com.example.dell.xiangmueraaa.Fulibean;
import com.example.dell.xiangmueraaa.model.ICallback;
import com.example.dell.xiangmueraaa.model.Modelmpl;
import com.example.dell.xiangmueraaa.view.IView;

import java.util.List;

/**
 * Created by DELL on 2019/5/29.
 */

public class Presentermpl implements IPresenter{
    private final Modelmpl mModelmpl;
    IView iview;

    public Presentermpl(IView iview) {
        this.iview = iview;
        mModelmpl = new Modelmpl();
    }

    @Override
    public void liu(int page) {
        if (mModelmpl!=null){
            mModelmpl.chun(new ICallback() {
                @Override
                public void Yes(List<Fulibean.ResultsBean> fuli) {
                    iview.Yes(fuli);
                }

                @Override
                public void No(String error) {
                    iview.No(error);
                }
            },page);
        }
    }
}
