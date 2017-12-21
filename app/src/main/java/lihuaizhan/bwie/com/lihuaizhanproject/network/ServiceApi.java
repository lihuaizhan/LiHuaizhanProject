package lihuaizhan.bwie.com.lihuaizhanproject.network;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.BaseBean;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.CartBean;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.ClassifyBean;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.GoodsBean;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.HeadBean;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.LoginBean;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.RegisBean;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.SubClass;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.UserMessageBean;
import lihuaizhan.bwie.com.lihuaizhanproject.view.xiangqing.IsAddBean;
import lihuaizhan.bwie.com.lihuaizhanproject.view.xiangqing.XiangQingBean;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/12/12.
 */

public interface ServiceApi {
   //首页请求
   @GET(UrlUtils.HEAD_PATH)
   public Flowable<HeadBean> getHeads();
   //分类请求
   @GET(UrlUtils.HEAD_FEN)
   public Flowable<ClassifyBean> getClassify();
   //子分类请求
   @GET(UrlUtils.SUBCLASS)
   public Flowable<SubClass> getSubClass(@Query("cid") String cid);
   //登录请求
   @GET(UrlUtils.LOGIN)
   public Flowable<LoginBean> onLogin(@Query("mobile") String mobile, @Query("password") String pass);
   @GET(UrlUtils.REGIN)
   public Flowable<RegisBean> onRegis(@Query("mobile") String mobile, @Query("password") String pass);
   @GET(UrlUtils.USER_MENAGES)
   public Flowable<UserMessageBean> getUserMenages(@Query("uid") String uid, @Query("token") String token);
   //商品详情
   @GET(UrlUtils.DETAIL_PATH_URL)
   Observable<XiangQingBean> getXiangQingData(@Query("pid") String pid);
   //关键词查找
   @GET(UrlUtils.SEARCH_PATH_URL)
   public Flowable<GoodsBean> searchGoods(@Query("keywords") String pid, @Query("page") String page);
   //添加购物车
   @GET(UrlUtils.ADDCAR_PATH_URL)
   Observable<IsAddBean> isadd(@Query("pid") String pid);
   //查询购物车
   @GET(UrlUtils.SELECTCAR_PATH_URL)
   public Flowable<CartBean> getCart( @Query("uid") String uid);

   //删除购物车
   @GET(UrlUtils.DELETECAR_PATH_URL)
   Observable<BaseBean> deleteGoodCar(@Query("uid") String uid, @Query("pid") String pid);
}
