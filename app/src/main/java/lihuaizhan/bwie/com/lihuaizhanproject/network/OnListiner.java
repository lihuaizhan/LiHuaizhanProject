package lihuaizhan.bwie.com.lihuaizhanproject.network;

/**
 * Created by Administrator on 2017/12/12.
 */

public interface OnListiner<T> {
    public void onSuccess(T t);
    public void onFailure(Throwable throwable);

}
