package lihuaizhan.bwie.com.lihuaizhanproject.model;


import android.util.Log;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.RegisBean;
import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.network.RetrofitHelper;
import lihuaizhan.bwie.com.lihuaizhanproject.network.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/12/12.
 */

public class RegisModel implements IRegisModel {


    @Override
    public void getRegis(String name, String pass, final OnListiner onLinister) {
        ServiceApi api = RetrofitHelper.getApi();
        Flowable<RegisBean> regisBeanFlowable = api.onRegis(name, pass);
        regisBeanFlowable.doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {
                Log.d("ssss","开始请求数据");
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegisBean>() {
                    @Override
                    public void accept(RegisBean regisBean) throws Exception {
                        onLinister.onSuccess(regisBean);
                    }
                });
//        reg.enqueue(new Callback<RegisBean>() {
//            @Override
//            public void onResponse(Call<RegisBean> call, Response<RegisBean> response) {
//                RegisBean body = response.body();
//                onLinister.onSuccess(body);
//            }
//
//            @Override
//            public void onFailure(Call<RegisBean> call, Throwable t) {
//                onLinister.onFailure(t);
//            }
//        });
    }
}
