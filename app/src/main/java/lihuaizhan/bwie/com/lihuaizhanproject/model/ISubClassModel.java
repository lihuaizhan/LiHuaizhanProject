package lihuaizhan.bwie.com.lihuaizhanproject.model;

import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;

/**
 * Created by Administrator on 2017/12/12.
 * 子分类model接口
 */

public interface ISubClassModel<T> {
    public void getSubClass(String cid,OnListiner<T> onListiner);
}

