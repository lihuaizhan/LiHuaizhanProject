package lihuaizhan.bwie.com.lihuaizhanproject.view.xiangqing;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.network.RetrofitHelper;

/**
 * Created by 我走路带风 on 2017/12/15.
 */

public class XiangQingModel implements IXiangQingModel{




    @Override
    public void getGood(final OnListiner onNetLitenner, String pid) {
        RetrofitHelper.getApi().getXiangQingData(pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<XiangQingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(XiangQingBean xiangQingBean) {
                        onNetLitenner.onSuccess(xiangQingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetLitenner.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void addCar(final OnListiner onNetLitenner, String pid) {
        RetrofitHelper.getApi().isadd(pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IsAddBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(IsAddBean isAddBean) {
                        onNetLitenner.onSuccess(isAddBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetLitenner.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
