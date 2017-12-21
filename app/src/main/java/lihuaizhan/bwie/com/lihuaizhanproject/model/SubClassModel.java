package lihuaizhan.bwie.com.lihuaizhanproject.model;

import android.util.Log;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.ClassifyBean;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.SubClass;
import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.network.RetrofitHelper;
import lihuaizhan.bwie.com.lihuaizhanproject.network.ServiceApi;


/**
 * Created by Administrator on 2017/12/12.
 * 子分类请求数据
 */

public class SubClassModel implements ISubClassModel {


    @Override
    public void getSubClass( String cid,final OnListiner onListiner) {
        ServiceApi api = RetrofitHelper.getApi();
        Flowable<SubClass> subClass = api.getSubClass(cid);
        subClass.doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {
                Log.d("sssss","请求数据");
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SubClass>() {
                    @Override
                    public void accept(SubClass subClass) throws Exception {
                       onListiner.onSuccess(subClass);
                    }
                });
    }
}
