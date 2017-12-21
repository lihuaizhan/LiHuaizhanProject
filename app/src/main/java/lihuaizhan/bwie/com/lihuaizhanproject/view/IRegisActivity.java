package lihuaizhan.bwie.com.lihuaizhanproject.view;


import lihuaizhan.bwie.com.lihuaizhanproject.bean.RegisBean;

/**
 * Created by Administrator on 2017/12/12.
 */

public interface IRegisActivity {
    public String getNames();
    public String getPass();
    public void onSucc(RegisBean loginBean);

}
