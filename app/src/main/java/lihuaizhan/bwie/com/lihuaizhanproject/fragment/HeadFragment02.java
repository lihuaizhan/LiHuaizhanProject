package lihuaizhan.bwie.com.lihuaizhanproject.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.adapter.HeadHierarchAdapter;
import lihuaizhan.bwie.com.lihuaizhanproject.adapter.HeadHierarchAdapter01;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.ClassifyBean;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.SubClass;
import lihuaizhan.bwie.com.lihuaizhanproject.presenter.ClassifyPresenter;
import lihuaizhan.bwie.com.lihuaizhanproject.view.IClassifyFragment;

/**
 * Created by Administrator on 2017/12/15.
 */

public class HeadFragment02 extends Fragment implements IClassifyFragment {

    private RecyclerView reFen02;
    private ClassifyPresenter classifyPresenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.head_fen02, container, false);
        reFen02 = inflate.findViewById(R.id.fen02);
        classifyPresenter = new ClassifyPresenter(this);
        classifyPresenter.getClassifyDatas();

        return inflate;
    }

    @Override
    public void onShow(ClassifyBean classifyBean) {
        List<ClassifyBean.DataBean> data = classifyBean.getData();
        HeadHierarchAdapter01 fenAdapter = new HeadHierarchAdapter01(getActivity(),data);
        reFen02.setLayoutManager(new GridLayoutManager(getContext(),5));

        reFen02.setAdapter(fenAdapter);
    }

    @Override
    public void onSubShow(SubClass subClass) {

    }
}
