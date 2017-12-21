package lihuaizhan.bwie.com.lihuaizhanproject.model;

import android.util.Log;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.CartBean;
import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.network.RetrofitHelper;

/**
 * Created by Administrator on 2017/12/19.
 */

public class GetCardModel implements IGetCardModel {
    @Override
    public void getCard( String uid, final OnListiner onListiner) {
        Flowable<CartBean> cart = RetrofitHelper.getApi().getCart(uid);
        cart.doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {
                Log.d("ssss","开始请求数据");
            }
        }).subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(new Consumer<CartBean>() {
              @Override
              public void accept(CartBean cartBean) throws Exception {
                  onListiner.onSuccess(cartBean);
              }
          })  ;
    }
}
