package lihuaizhan.bwie.com.lihuaizhanproject.model;


import android.util.Log;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.LoginBean;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.RegisBean;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.UserMessageBean;
import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.network.RetrofitHelper;
import lihuaizhan.bwie.com.lihuaizhanproject.network.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/12/12.
 */

public class UserManagesModel implements IUserManagesModel {


    @Override
    public void getUserMange(String uid, String token, final OnListiner onLinister) {
        ServiceApi api = RetrofitHelper.getApi();
        final Flowable<UserMessageBean> userMenages = api.getUserMenages(uid, token);
       userMenages.doOnSubscribe(new Consumer<Subscription>() {
           @Override
           public void accept(Subscription subscription) throws Exception {
               Log.d("ssss","开始请求数据");
           }
       }).subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Consumer<UserMessageBean>() {
                   @Override
                   public void accept(UserMessageBean userMessageBean) throws Exception {
                       onLinister.onSuccess(userMessageBean);
                   }
               });
    }
}
