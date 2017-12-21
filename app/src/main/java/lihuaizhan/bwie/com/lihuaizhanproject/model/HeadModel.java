package lihuaizhan.bwie.com.lihuaizhanproject.model;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.HeadBean;
import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.network.RetrofitHelper;
import lihuaizhan.bwie.com.lihuaizhanproject.network.ServiceApi;


/**
 * Created by Administrator on 2017/12/12.
 * 首页请求数据
 */

public class HeadModel implements IHeadModel {
    @Override
    public void getDatas(final OnListiner onListiner) {
        ServiceApi api = RetrofitHelper.getApi();
        Flowable<HeadBean> getAd = api.getHeads();
        getAd.doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {
                Log.i("hhhhhhhhhhhhhhhhhhh","开始请求数据");
            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<HeadBean>() {
            @Override
            public void accept(HeadBean headBean) throws Exception {
                onListiner.onSuccess(headBean);
            }
        });
    }
}
