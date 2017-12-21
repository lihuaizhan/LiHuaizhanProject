package lihuaizhan.bwie.com.lihuaizhanproject.presenter;

import lihuaizhan.bwie.com.lihuaizhanproject.bean.LoginBean;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.UserMessageBean;
import lihuaizhan.bwie.com.lihuaizhanproject.model.ILoginModel;
import lihuaizhan.bwie.com.lihuaizhanproject.model.IUserManagesModel;
import lihuaizhan.bwie.com.lihuaizhanproject.model.LoginModel;
import lihuaizhan.bwie.com.lihuaizhanproject.model.UserManagesModel;
import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.view.IPersonageActivity;
import lihuaizhan.bwie.com.lihuaizhanproject.view.ISetActivity;

/**
 * Created by Administrator on 2017/12/12.
 */

public class UserManagesPresenter {
    private ISetActivity iSetActivity;
    private IUserManagesModel iUserManagesModel;

    public UserManagesPresenter(ISetActivity iSetActivity) {
        this.iSetActivity = iSetActivity;
        iUserManagesModel = new UserManagesModel();
    }
    public void onData()
    {
        String uid = iSetActivity.getUid();
        String token = iSetActivity.getToken();
        iUserManagesModel.getUserMange(uid, token, new OnListiner() {
            @Override
            public void onSuccess(Object o) {
                UserMessageBean userMessageBean = (UserMessageBean) o;
                iSetActivity.onDatas(userMessageBean);
            }

            @Override
            public void onFailure(Throwable throwable) {
            throwable.getMessage();
            }
        });

    }
}
