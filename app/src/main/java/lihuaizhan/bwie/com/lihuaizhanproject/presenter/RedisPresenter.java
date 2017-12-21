package lihuaizhan.bwie.com.lihuaizhanproject.presenter;

import lihuaizhan.bwie.com.lihuaizhanproject.bean.RegisBean;
import lihuaizhan.bwie.com.lihuaizhanproject.model.IRegisModel;
import lihuaizhan.bwie.com.lihuaizhanproject.model.RegisModel;
import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.view.IRegisActivity;


/**
 * Created by Administrator on 2017/12/12.
 */

public class RedisPresenter {
    private IRegisActivity iRegisActivity;
    private IRegisModel iLoginModel;

    public RedisPresenter(IRegisActivity iRegisActivity) {
        this.iRegisActivity = iRegisActivity;
        iLoginModel = new RegisModel();
    }
    public void onLog()
    {
        String names = iRegisActivity.getNames();
        String pass = iRegisActivity.getPass();
        iLoginModel.getRegis(names, pass, new OnListiner() {
            @Override
            public void onSuccess(Object o) {
                RegisBean regisBean = (RegisBean) o;
                iRegisActivity.onSucc(regisBean);

            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }
}
