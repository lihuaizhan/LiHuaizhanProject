package lihuaizhan.bwie.com.lihuaizhanproject.view;


import lihuaizhan.bwie.com.lihuaizhanproject.bean.GoodsBean;

public interface ISearchActivity {
    public String getKeyWords();
    public void toast(String str);
    public void showGoods(GoodsBean goodsBean);

    void loadMore(GoodsBean goodsBean);
}
