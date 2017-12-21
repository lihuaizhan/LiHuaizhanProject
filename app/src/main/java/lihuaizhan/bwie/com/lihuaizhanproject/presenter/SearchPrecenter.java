package lihuaizhan.bwie.com.lihuaizhanproject.presenter;


import lihuaizhan.bwie.com.lihuaizhanproject.bean.GoodsBean;
import lihuaizhan.bwie.com.lihuaizhanproject.model.ISearchModel;
import lihuaizhan.bwie.com.lihuaizhanproject.model.SearchModel;
import lihuaizhan.bwie.com.lihuaizhanproject.network.OnListiner;
import lihuaizhan.bwie.com.lihuaizhanproject.view.ISearchActivity;

/**
 * Created by 我走路带风 on 2017/12/16.
 */

public class SearchPrecenter implements ISearchPrecenter {
    private ISearchModel searchModel;
    private ISearchActivity searchActivity;
    private String keyWords;
    public SearchPrecenter(ISearchActivity searchActivity) {
        this.searchActivity = searchActivity;
        searchModel = new SearchModel();
    }

    @Override
    public void getGoodByKeyWords() {
        keyWords = searchActivity.getKeyWords();
        searchModel.getGoods(new OnListiner() {
            @Override
            public void onSuccess(Object o) {
                searchActivity.showGoods((GoodsBean) o);
            }

            @Override
            public void onFailure(Throwable throwable) {
                searchActivity.toast("搜索失败!");
            }
        },keyWords,"1");

    }
    @Override
    public void loadMore(String page) {

        keyWords = searchActivity.getKeyWords();
        searchModel.getGoods(new OnListiner() {
            @Override
            public void onSuccess(Object o) {
                searchActivity.loadMore((GoodsBean) o);
            }

            @Override
            public void onFailure(Throwable throwable) {
                searchActivity.toast("加载失败!");
            }
        }, keyWords, page + "");

    }
}
