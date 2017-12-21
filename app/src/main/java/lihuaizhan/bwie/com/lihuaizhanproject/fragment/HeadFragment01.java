package lihuaizhan.bwie.com.lihuaizhanproject.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.adapter.HeadHierarchAdapter;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.ClassifyBean;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.SubClass;
import lihuaizhan.bwie.com.lihuaizhanproject.presenter.ClassifyPresenter;
import lihuaizhan.bwie.com.lihuaizhanproject.view.IClassifyFragment;

/**
 * Created by Administrator on 2017/12/15.
 */

public class HeadFragment01 extends Fragment implements IClassifyFragment {

    private RecyclerView reFen01;
    private ClassifyPresenter classifyPresenter;
    private     View inflate;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        reFen01 = inflate.findViewById(R.id.fen01);
        classifyPresenter = new ClassifyPresenter(this);
        classifyPresenter.getClassifyDatas();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         inflate = inflater.inflate(R.layout.head_fen01, container, false);


        return inflate;
    }

    @Override
    public void onShow(ClassifyBean classifyBean) {
        List<ClassifyBean.DataBean> data = classifyBean.getData();
        Log.d("sssss",data.toString());
        HeadHierarchAdapter fenAdapter = new HeadHierarchAdapter(getActivity(),data);
        reFen01.setLayoutManager(new GridLayoutManager(getContext(),5));
        reFen01.setAdapter(fenAdapter);

    }

    @Override
    public void onSubShow(SubClass subClass) {

    }
}
