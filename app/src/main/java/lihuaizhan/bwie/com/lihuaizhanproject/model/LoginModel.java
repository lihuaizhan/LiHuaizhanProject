package lihuaizhan.bwie.com.lihuaizhanproject.model;


import android.util.Log;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.LoginBean;
import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.network.RetrofitHelper;
import lihuaizhan.bwie.com.lihuaizhanproject.network.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/12/12.
 */

public class LoginModel implements ILoginModel {




    @Override
    public void getLogin(String name, String pass, final OnListiner onLinister) {
        ServiceApi api = RetrofitHelper.getApi();
        Flowable<LoginBean> loginBeanFlowable = api.onLogin(name, pass);
        loginBeanFlowable.doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {
                Log.d("ssss","开始请求数据");
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        onLinister.onSuccess(loginBean);
                    }
                });

//        loginBeanCall.enqueue(new Callback<LoginBean>() {
//            @Override
//            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
//                LoginBean body = response.body();
//                onLinister.onSuccess(body);
//            }
//
//            @Override
//            public void onFailure(Call<LoginBean> call, Throwable t) {
//                t.getMessage();
//                onLinister.onFailure(t);
//            }
//        });
    }
}
