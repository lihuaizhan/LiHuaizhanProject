package lihuaizhan.bwie.com.lihuaizhanproject.model;


import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;

/**
 * Created by Administrator on 2017/12/19.
 */

public interface IGetCardModel<T> {
    public void getCard(String uid, OnListiner onListiner);
}
