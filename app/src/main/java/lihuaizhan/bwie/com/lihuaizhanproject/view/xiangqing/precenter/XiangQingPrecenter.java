package lihuaizhan.bwie.com.lihuaizhanproject.view.xiangqing.precenter;


import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.view.xiangqing.IXiangQingActivity;
import lihuaizhan.bwie.com.lihuaizhanproject.view.xiangqing.IXiangQingModel;
import lihuaizhan.bwie.com.lihuaizhanproject.view.xiangqing.IsAddBean;
import lihuaizhan.bwie.com.lihuaizhanproject.view.xiangqing.XiangQingBean;
import lihuaizhan.bwie.com.lihuaizhanproject.view.xiangqing.XiangQingModel;

/**
 * Created by 我走路带风 on 2017/12/15.
 */

public class XiangQingPrecenter implements IXiangQingPrecenter{
    private IXiangQingModel xiangQingModel;
    private IXiangQingActivity xiangQingActivity;
    private String pid;

    public XiangQingPrecenter(IXiangQingActivity xiangQingActivity) {
        this.xiangQingActivity = xiangQingActivity;
        xiangQingModel = new XiangQingModel();
    }

    @Override
    public void getGood() {
        pid = xiangQingActivity.getPid();
        xiangQingModel.getGood(new OnListiner() {
            @Override
            public void onSuccess(Object o) {
                xiangQingActivity.showGood((XiangQingBean) o);
            }

            @Override
            public void onFailure(Throwable throwable) {
                xiangQingActivity.toast(throwable.getMessage());
            }
        }, pid);
    }


    @Override
    public void isAdd() {
        xiangQingModel.addCar(new OnListiner<IsAddBean>() {
            @Override
            public void onSuccess(IsAddBean isAddBean) {
                if (isAddBean.getCode().equals("0")){
                    xiangQingActivity.toast("加购成功");
                }else{
                    xiangQingActivity.toast("加购失败");
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                xiangQingActivity.toast("加购失败");
            }
        }, pid);
    }


}
