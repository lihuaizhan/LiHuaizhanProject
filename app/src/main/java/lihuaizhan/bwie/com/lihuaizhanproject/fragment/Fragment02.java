package lihuaizhan.bwie.com.lihuaizhanproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.adapter.LvAdapter;
import lihuaizhan.bwie.com.lihuaizhanproject.adapter.RightRecyAdapter;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.ClassifyBean;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.SubClass;
import lihuaizhan.bwie.com.lihuaizhanproject.network.GlideImageLoader;
import lihuaizhan.bwie.com.lihuaizhanproject.presenter.ClassifyPresenter;
import lihuaizhan.bwie.com.lihuaizhanproject.presenter.SubClassPresenter;
import lihuaizhan.bwie.com.lihuaizhanproject.view.IClassifyFragment;


/**
 * Created by Administrator on 2017/11/11.
 */

public class Fragment02 extends Fragment implements IClassifyFragment {


    private View view;
    private ListView mLeftLv;
    private RecyclerView mRightRc;
    private Banner mBanner;
    private  ClassifyPresenter classifyPresenter;
    private   SubClassPresenter subClassPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment02, container, false);
        classifyPresenter = new ClassifyPresenter(this);
        classifyPresenter.getClassifyDatas();
        subClassPresenter = new SubClassPresenter(this);
        subClassPresenter.getSubClassDatas("1");
        initView(view);
        return view;
    }

    private void initView(View view) {
        mLeftLv = (ListView) view.findViewById(R.id.left_lv);
        mRightRc = (RecyclerView) view.findViewById(R.id.right_rc);
        mBanner = (Banner) view.findViewById(R.id.banner);
        List<String> images = new ArrayList<>();

        images.add("http://pic2.nipic.com/20090424/1468853_230119053_2.jpg");
        images.add("http://img3.3lian.com/2013/s1/20/d/57.jpg");
        //是否自动轮播
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.isAutoPlay(true);

//设置轮播的时间间隔
        mBanner.setDelayTime(3000);
        mBanner.setImages(images);
        mBanner.start();
    }

    @Override
    public void onShow(ClassifyBean classifyBean) {
        final List<ClassifyBean.DataBean> data = classifyBean.getData();
        final LvAdapter lvAdapter = new LvAdapter(data,getActivity());
        mLeftLv.setAdapter(lvAdapter);
        mLeftLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                lvAdapter.press(i);
                ClassifyBean.DataBean dataBean = data.get(i);
                subClassPresenter.getSubClassDatas(dataBean.getCid()+"");
                Toast.makeText(getActivity().getApplicationContext(),dataBean.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onSubShow(SubClass subClass) {
        List<SubClass.DataBean> data = subClass.getData();
        RightRecyAdapter adapter = new RightRecyAdapter(data,getActivity());
        mRightRc.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRightRc.setAdapter(adapter);
    }
}
