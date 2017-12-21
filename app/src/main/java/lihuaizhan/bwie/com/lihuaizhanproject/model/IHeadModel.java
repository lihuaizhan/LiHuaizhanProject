package lihuaizhan.bwie.com.lihuaizhanproject.model;

import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;

/**
 * Created by Administrator on 2017/12/12.
 * 首页model接口
 */

public interface IHeadModel<T> {
    public void getDatas(OnListiner<T> onListiner);
}

