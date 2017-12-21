package lihuaizhan.bwie.com.lihuaizhanproject.presenter;

import lihuaizhan.bwie.com.lihuaizhanproject.bean.ClassifyBean;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.SubClass;
import lihuaizhan.bwie.com.lihuaizhanproject.model.ClassifyModel;
import lihuaizhan.bwie.com.lihuaizhanproject.model.HeadModel;
import lihuaizhan.bwie.com.lihuaizhanproject.model.IClassifyModel;
import lihuaizhan.bwie.com.lihuaizhanproject.model.IHeadModel;
import lihuaizhan.bwie.com.lihuaizhanproject.model.ISubClassModel;
import lihuaizhan.bwie.com.lihuaizhanproject.model.SubClassModel;
import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.view.IClassifyFragment;
import lihuaizhan.bwie.com.lihuaizhanproject.view.IHeadFragment;

/**
 * Created by Administrator on 2017/12/12.
 */

public class SubClassPresenter {
    private ISubClassModel iSubClassModel;
    private IClassifyFragment iClassifyFragment;
    private IClassifyModel iClassifyModel;


    public SubClassPresenter(IClassifyFragment iClassifyFragment) {
        this.iClassifyFragment = iClassifyFragment;
        iClassifyModel = new ClassifyModel();
        iSubClassModel = new SubClassModel();
    }
    public void getSubClassDatas( String cid)
    {
       iSubClassModel.getSubClass(cid,new OnListiner() {
           @Override
           public void onSuccess(Object o) {
               iClassifyFragment.onSubShow((SubClass) o);

           }

           @Override
           public void onFailure(Throwable throwable) {
              throwable.getMessage();
           }
       });
    }
}
