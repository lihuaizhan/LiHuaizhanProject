package lihuaizhan.bwie.com.lihuaizhanproject.model;


import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;

/**
 * Created by Administrator on 2017/12/12.
 */

public interface IUserManagesModel<T> {
    public void getUserMange(String uid, String token, OnListiner<T> onLinister);
}
