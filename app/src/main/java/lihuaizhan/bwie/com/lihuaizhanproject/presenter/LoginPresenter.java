package lihuaizhan.bwie.com.lihuaizhanproject.presenter;

import lihuaizhan.bwie.com.lihuaizhanproject.bean.LoginBean;
import lihuaizhan.bwie.com.lihuaizhanproject.model.ILoginModel;
import lihuaizhan.bwie.com.lihuaizhanproject.model.LoginModel;
import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.view.IPersonageActivity;

/**
 * Created by Administrator on 2017/12/12.
 */

public class LoginPresenter {
    private IPersonageActivity iPersonageActivity;
    private ILoginModel iLoginModel;

    public LoginPresenter(IPersonageActivity iPersonageActivity) {
        this.iPersonageActivity = iPersonageActivity;
        iLoginModel = new LoginModel();
    }
    public void onLog()
    {
        String names = iPersonageActivity.getNames();
        String pass = iPersonageActivity.getPass();
        iLoginModel.getLogin(names, pass, new OnListiner() {
            @Override
            public void onSuccess(Object o) {
                   LoginBean loginBean = (LoginBean) o;
                iPersonageActivity.onSucc(loginBean);


            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }
}
