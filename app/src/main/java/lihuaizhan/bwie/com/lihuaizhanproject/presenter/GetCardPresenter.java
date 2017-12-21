package lihuaizhan.bwie.com.lihuaizhanproject.presenter;


import lihuaizhan.bwie.com.lihuaizhanproject.bean.CartBean;
import lihuaizhan.bwie.com.lihuaizhanproject.model.GetCardModel;
import lihuaizhan.bwie.com.lihuaizhanproject.model.IGetCardModel;
import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.view.ICartFragment;

/**
 * Created by Administrator on 2017/12/19.
 */

public class GetCardPresenter {
    private ICartFragment iCartFragment;
    private IGetCardModel iGetCardModel;

    public GetCardPresenter(ICartFragment iCartFragment) {
        this.iCartFragment = iCartFragment;
        iGetCardModel = new GetCardModel();
    }

    public void getCarts() {
        iGetCardModel.getCard("71", new OnListiner() {
            @Override
            public void onSuccess(Object o) {
                iCartFragment.onShow((CartBean) o);
            }

            @Override
            public void onFailure(Throwable t) {
                t.getMessage();
            }
        });
    }
}
