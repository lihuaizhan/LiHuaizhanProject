package lihuaizhan.bwie.com.lihuaizhanproject.view;

import lihuaizhan.bwie.com.lihuaizhanproject.bean.UserMessageBean;

/**
 * Created by Administrator on 2017/12/18.
 */

public interface ISetActivity {
    public void onDatas(UserMessageBean bean);
    public String getUid();
    public String getToken();

}
