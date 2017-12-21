package lihuaizhan.bwie.com.lihuaizhanproject.model;

import android.util.Log;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.ClassifyBean;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.HeadBean;
import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.network.RetrofitHelper;
import lihuaizhan.bwie.com.lihuaizhanproject.network.ServiceApi;


/**
 * Created by Administrator on 2017/12/12.
 * 分类请求数据
 */

public class ClassifyModel implements IClassifyModel {
    @Override
    public void getClassifyDatas(final OnListiner onListiner) {
        ServiceApi api = RetrofitHelper.getApi();
        Flowable<ClassifyBean> getAd = api.getClassify();
        getAd.doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {
                Log.i("hhhhhhhhhhhhhhhhhhh","开始请求数据");
            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<ClassifyBean>() {
            @Override
            public void accept(ClassifyBean classifyBean) throws Exception {
                onListiner.onSuccess(classifyBean);
            }
        });
    }
}
