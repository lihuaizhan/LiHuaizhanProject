package lihuaizhan.bwie.com.lihuaizhanproject.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.adapter.SearchAdapter;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.GoodsBean;
import lihuaizhan.bwie.com.lihuaizhanproject.presenter.ISearchPrecenter;
import lihuaizhan.bwie.com.lihuaizhanproject.presenter.SearchPrecenter;
import lihuaizhan.bwie.com.lihuaizhanproject.view.xiangqing.XiangQingActivity;

public class SearchActivity extends AppCompatActivity implements ISearchActivity, View.OnClickListener {
    private RecyclerView mSearchRv;
    private SmartRefreshLayout mSmartlayout;
    private LinearLayout mSaoyisao;
    private RelativeLayout mSousuo;
    private LinearLayout mSearch;
    /**
     * 笔记本电脑
     */
    private EditText mSearchEt;
    /**
     * 搜索
     */
    private TextView mStartSearch;
    private List<GoodsBean.DataBean> data;
    private SearchAdapter searchAdapter;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        freshAndLoadMore();
    }
    @Override
    public String getKeyWords() {
        return mSearchEt.getText().toString();
    }

    @Override
    public void toast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGoods(GoodsBean goodsBean) {
        data = goodsBean.getData();
        searchAdapter = new SearchAdapter(data, this);
        mSearchRv.setLayoutManager(new GridLayoutManager(this, 2));
        mSearchRv.setAdapter(searchAdapter);
        searchAdapter.setOnItemClickListener(new SearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int pid = data.get(position).getPid();
                Intent intent = new Intent(SearchActivity.this, XiangQingActivity.class);
                intent.putExtra("pid",pid+"");
                startActivity(intent);
            }
        });
    }

    @Override
    public void loadMore(GoodsBean goodsBean) {
        List<GoodsBean.DataBean> newdata = goodsBean.getData();
        data.addAll(newdata);
        searchAdapter.notifyDataSetChanged();
    }

    private void initView() {
        mSearchRv = (RecyclerView) findViewById(R.id.search_rv);
        mSmartlayout = (SmartRefreshLayout) findViewById(R.id.smartlayout);
        mSaoyisao = (LinearLayout) findViewById(R.id.saoyisao);
        mSousuo = (RelativeLayout) findViewById(R.id.sousuo);
        mSearch = (LinearLayout) findViewById(R.id.search);
        mSearchRv.setOnClickListener(this);
        mSmartlayout.setOnClickListener(this);
        mSaoyisao.setOnClickListener(this);
        mSearchEt = (EditText) findViewById(R.id.search_et);
        mSousuo.setOnClickListener(this);
        mSearch.setOnClickListener(this);
        mSearchEt.setOnClickListener(this);
        mStartSearch = (TextView) findViewById(R.id.start_search);
        mStartSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.search_rv:
                break;
            case R.id.smartlayout:
                break;
            case R.id.saoyisao:
                break;
            case R.id.sousuo:
                break;
            case R.id.search:
                break;
            case R.id.search_et:
                break;
            case R.id.start_search:
                ISearchPrecenter searchPrecenter = new SearchPrecenter(this);
                searchPrecenter.getGoodByKeyWords();
                break;
        }
    }
    //刷新加载更多
    private void freshAndLoadMore() {
        mSmartlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                ISearchPrecenter searchPrecenter = new SearchPrecenter(SearchActivity.this);
                searchPrecenter.getGoodByKeyWords();
                refreshlayout.finishRefresh();//传入false表示刷新失败
            }
        });
        mSmartlayout.setOnLoadmoreListener(new OnLoadmoreListener() {

            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                Log.e("tag", "onLoadmore: "+page );
                ISearchPrecenter searchPrecenter = new SearchPrecenter(SearchActivity.this);
                searchPrecenter.loadMore(page+"");
                refreshlayout.finishLoadmore();//传入false表示加载失败
            }
        });
    }
}
