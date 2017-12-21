package lihuaizhan.bwie.com.lihuaizhanproject.view.xiangqing;


import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;

/**
 * Created by 我走路带风 on 2017/12/15.
 */

public interface IXiangQingModel<T> {
    public void getGood(OnListiner<T> onNetLitenner, String pid);
    public void addCar(OnListiner<IsAddBean> onNetLitenner, String pid);
}
