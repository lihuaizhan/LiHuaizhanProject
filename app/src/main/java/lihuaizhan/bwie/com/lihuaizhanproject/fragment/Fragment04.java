package lihuaizhan.bwie.com.lihuaizhanproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.adapter.MyAdapter;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.CartBean;
import lihuaizhan.bwie.com.lihuaizhanproject.eventbus.Datas;
import lihuaizhan.bwie.com.lihuaizhanproject.eventbus.MessageEvent;
import lihuaizhan.bwie.com.lihuaizhanproject.eventbus.PriceAndCountEvent;
import lihuaizhan.bwie.com.lihuaizhanproject.presenter.GetCardPresenter;
import lihuaizhan.bwie.com.lihuaizhanproject.view.ICartFragment;


/**
 * Created by Administrator on 2017/11/11.
 */

public class Fragment04 extends Fragment implements View.OnClickListener,ICartFragment {
    private GetCardPresenter presenter;
    private MyAdapter adapter;
    private View view;
    /**
     * c
     */
    private TextView mFan;
    /**
     * 编辑
     */
    private TextView mBj;
    private ExpandableListView mElv;
    /**
     * 全选
     */
    private CheckBox mCheckAll;
    /**
     * 分享宝贝
     */
    private Button mShare;
    /**
     * 移到收藏栏
     */
    private Button mFile;
    /**
     * 删除
     */
    private Button mDele;
    private LinearLayout mCaozuo;
    /**
     * 价钱
     */
    private TextView mPriceAll;
    /**
     * 结算
     */
    private Button mJs;
    private RelativeLayout mJiesuan;
    private   List<List<CartBean.DataBean.ListBean>> lists = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment04, container, false);
        EventBus.getDefault().register(this);
        initView(view);
        presenter = new GetCardPresenter(this);
        presenter.getCarts();
        mCaozuo.setVisibility(View.GONE);

        return view;
    }
    @Subscribe
    public void onDatas(Datas datas)
    {
//        presenter1.onData(datas);
//        presenter2.onData(datas);

    }
    private void initView(View view) {
        mFan = (TextView) view.findViewById(R.id.fan);
        mBj = (TextView) view.findViewById(R.id.bj);
        mBj.setOnClickListener(this);
        mElv = (ExpandableListView) view.findViewById(R.id.elv);
        mCheckAll = (CheckBox) view.findViewById(R.id.check_all);
        mShare = (Button) view.findViewById(R.id.share);
        mShare.setOnClickListener(this);
        mFile = (Button) view.findViewById(R.id.file);
        mFile.setOnClickListener(this);
        mDele = (Button) view.findViewById(R.id.dele);
        mDele.setOnClickListener(this);
        mCaozuo = (LinearLayout) view.findViewById(R.id.caozuo);
        mPriceAll = (TextView) view.findViewById(R.id.price_all);
        mJs = (Button) view.findViewById(R.id.js);
        mJs.setOnClickListener(this);
        mJiesuan = (RelativeLayout) view.findViewById(R.id.jiesuan);
        mCheckAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.changeAllListCbState(mCheckAll.isChecked());
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bj:
                mCaozuo.setVisibility(View.VISIBLE);
                mJiesuan.setVisibility(View.GONE);
                break;
            case R.id.share:
                break;
            case R.id.file:
                break;
            case R.id.dele:
                break;
            case R.id.js:
                break;
        }
    }

    @Override
    public void onShow(CartBean cartBean) {
        Toast.makeText(getActivity().getApplicationContext(),cartBean.getCode(),Toast.LENGTH_SHORT).show();
        List<CartBean.DataBean> data = cartBean.getData();

        for (int i = 0; i < data.size(); i++) {
            data.get(i).setBj("编辑");
            data.get(i).setWc("完成");
            List<CartBean.DataBean.ListBean> list = data.get(i).getList();
            lists.add(list);
        }
         adapter = new MyAdapter(getActivity(), data, lists);
        mElv.setAdapter(adapter);
        for (int i=0; i<data.size(); i++)
        {
            mElv.expandGroup(i);
        }
    }

    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        mCheckAll.setChecked(event.isChecked());
    }

    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event) {
        mPriceAll.setText("结算(" + event.getCount() + ")"+event.getPrice() + "");

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
