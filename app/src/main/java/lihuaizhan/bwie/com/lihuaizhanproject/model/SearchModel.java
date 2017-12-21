package lihuaizhan.bwie.com.lihuaizhanproject.model;

import android.util.Log;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.GoodsBean;
import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.network.RetrofitHelper;


public class SearchModel implements ISearchModel {


    @Override
    public void getGoods(final OnListiner onNetLitenner, String keywords, String page) {
        Flowable<GoodsBean> goodsBeanFlowable = RetrofitHelper.getApi().searchGoods(keywords, page);
        goodsBeanFlowable.doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {
                Log.d("ssss","开始请求数据");
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoodsBean>() {
                    @Override
                    public void accept(GoodsBean goodsBean) throws Exception {
                        onNetLitenner.onSuccess(goodsBean);
                    }
                });
    }
}
