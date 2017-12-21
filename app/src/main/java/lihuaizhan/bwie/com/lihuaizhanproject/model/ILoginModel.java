package lihuaizhan.bwie.com.lihuaizhanproject.model;


import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;

/**
 * Created by Administrator on 2017/12/12.
 */

public interface ILoginModel<T> {
    public void getLogin(String name, String pass, OnListiner<T> onLinister);
}
