package lihuaizhan.bwie.com.lihuaizhanproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

import lihuaizhan.bwie.com.lihuaizhanproject.R;


/**
 * Created by Administrator on 2017/11/11.
 */

public class Fragment02 extends Fragment{
//    private ClassPresenter classPresenter;
//    private View view;
//    private ListView mLeftLv;
//    private Banner mBanner;
//    private ExpandableListView mElv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment02, container, false);
//         initView(view);
//        classPresenter = new ClassPresenter(this);
//        classPresenter.getCatagory();

        return view;
    }

//    @Override
//    public void showData(List<ProductClass.DataBean> list) {
//       LvAdapter lvAdapter = new LvAdapter(list,getActivity());
//        mLeftLv.setAdapter(lvAdapter);
//    }
//
//    @Override
//    public void show(List<ProductCatagory.DataBean.ListBean> list) {
//
//    }
//
//    private void initView(View view) {
//        mLeftLv = (ListView) view.findViewById(R.id.left_lv);
//        mBanner = (Banner) view.findViewById(R.id.banner);
//        mElv = (ExpandableListView) view.findViewById(R.id.elv);
//        mBanner.setImageLoader(new GlideImageLoader());
//        List<String> images = new ArrayList<>();
//
//        images.add("http://pic2.nipic.com/20090424/1468853_230119053_2.jpg");
//        images.add("http://img3.3lian.com/2013/s1/20/d/57.jpg");
//        //是否自动轮播
//        mBanner.isAutoPlay(true);
//
////设置轮播的时间间隔
//        mBanner.setDelayTime(3000);
//        mBanner.setImages(images);
//        mBanner.start();
//    }
}
