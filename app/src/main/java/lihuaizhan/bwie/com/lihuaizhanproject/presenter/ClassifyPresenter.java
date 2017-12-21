package lihuaizhan.bwie.com.lihuaizhanproject.presenter;

import lihuaizhan.bwie.com.lihuaizhanproject.bean.ClassifyBean;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.HeadBean;
import lihuaizhan.bwie.com.lihuaizhanproject.model.ClassifyModel;
import lihuaizhan.bwie.com.lihuaizhanproject.model.HeadModel;
import lihuaizhan.bwie.com.lihuaizhanproject.model.IClassifyModel;
import lihuaizhan.bwie.com.lihuaizhanproject.model.IHeadModel;
import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.view.IClassifyFragment;
import lihuaizhan.bwie.com.lihuaizhanproject.view.IHeadFragment;

/**
 * Created by Administrator on 2017/12/12.
 */

public class ClassifyPresenter {
    private IHeadFragment iHeadFragment;
    private IClassifyFragment iClassifyFragment;
    private IHeadModel iHeadModel;
    private IClassifyModel iClassifyModel;

    public ClassifyPresenter(IClassifyFragment iClassifyFragment) {
        this.iClassifyFragment = iClassifyFragment;
        iHeadModel = new HeadModel();
        iClassifyModel = new ClassifyModel();
    }
    public void getClassifyDatas()
    {
        iClassifyModel.getClassifyDatas(new OnListiner() {
            @Override
            public void onSuccess(Object o) {
              iClassifyFragment.onShow((ClassifyBean) o);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }
}
