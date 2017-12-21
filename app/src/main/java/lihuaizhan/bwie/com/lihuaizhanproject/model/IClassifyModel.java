package lihuaizhan.bwie.com.lihuaizhanproject.model;

import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;

/**
 * Created by Administrator on 2017/12/12.
 * 分类model接口
 */

public interface IClassifyModel<T> {
    public void getClassifyDatas(OnListiner<T> onListiner);
}

