package lihuaizhan.bwie.com.lihuaizhanproject.network;

/**
 * Created by Administrator on 2017/12/12.
 */

public class UrlUtils {
    public static final String BASE_URL="https://www.zhaoapi.cn/";
    public static final String HEAD_PATH="ad/getAd";
    public static final String HEAD_FEN="product/getCatagory";
    public static final String SUBCLASS="product/getProductCatagory";
    public static final String LOGIN="user/login";
    public static final String REGIN="user/reg";
    public static final String USER_MENAGES="user/getUserInfo";
    //上传头像 file/upload(file为路径)
    public static final String HEAD_PATH_URL = "/upload";
    //商品详情
    public static final String DETAIL_PATH_URL = "product/getProductDetail";
    //当前子分类下的商品列表（分页）
    public static final String CLASSIFY_GOODS_PATH_URL = "product/getProducts";
    //根据关键词搜索商品
    public static final String SEARCH_PATH_URL = "product/searchProducts";
    //修改昵称
    public static final String UPDATENAME_PATH_URL = "product/updateNickName";
    //添加购物车
    public static final String ADDCAR_PATH_URL = "product/addCart?uid=71";
    //查询购物车
    public static final String SELECTCAR_PATH_URL = "product/getCarts";
    //更新购物车
    public static final String UPDATECAR_PATH_URL = "product/updateCarts";
    //删除购物车（新增）
    public static final String DELETECAR_PATH_URL = "product/deleteCart";
    //修改订单状态
    public static final String UPDATEDINGDAN_PATH_URL = "product/updateOrder";
    //创建订单（为了开发方便，只做简单功能）
    public static final String NEWDINGDAN_PATH_URL = "product/createOrder";
    //订单列表
    public static final String DINGDANLIST_PATH_URL = "product/getOrders";
    //常用收货地址列表
    public static final String GETADDR_PATH_URL = "product/getAddrs";

    //添加常用收获地址
    public static final String ADDADDR_PATH_URL = "product/addAddr";

    //修改收货地址列表
    public static final String UPDATEADDR_PATH_URL = "product/updateAddr";

}
