package lihuaizhan.bwie.com.lihuaizhanproject.view;


import lihuaizhan.bwie.com.lihuaizhanproject.bean.LoginBean;

/**
 * Created by Administrator on 2017/12/12.
 */

public interface IPersonageActivity {
    public String getNames();
    public String getPass();
    public void onSucc(LoginBean loginBean);

}
