package lihuaizhan.bwie.com.lihuaizhanproject.presenter;

import lihuaizhan.bwie.com.lihuaizhanproject.bean.HeadBean;
import lihuaizhan.bwie.com.lihuaizhanproject.model.HeadModel;
import lihuaizhan.bwie.com.lihuaizhanproject.model.IHeadModel;
import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.view.IHeadFragment;

/**
 * Created by Administrator on 2017/12/12.
 */

public class HeadPresenter {
    private IHeadFragment iHeadFragment;
    private IHeadModel iHeadModel;

    public HeadPresenter(IHeadFragment iHeadFragment) {
        this.iHeadFragment = iHeadFragment;
        iHeadModel = new HeadModel();
    }
    public void getHeadDatas()
    {
        iHeadModel.getDatas(new OnListiner() {
            @Override
            public void onSuccess(Object o) {
                iHeadFragment.getDatas((HeadBean) o);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

}
