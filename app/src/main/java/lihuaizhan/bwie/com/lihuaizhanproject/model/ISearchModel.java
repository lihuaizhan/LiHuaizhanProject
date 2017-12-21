package lihuaizhan.bwie.com.lihuaizhanproject.model;


import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;

/**
 * Created by 我走路带风 on 2017/12/16.
 */

public interface ISearchModel<T> {
    public void getGoods(OnListiner<T> onNetLitenner, String keywords, String page);
}
