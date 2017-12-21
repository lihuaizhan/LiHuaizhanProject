package lihuaizhan.bwie.com.lihuaizhanproject.fragment;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.adapter.MiaoShaAdapter;
import lihuaizhan.bwie.com.lihuaizhanproject.adapter.TuiJianAdapter;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.HeadBean;
import lihuaizhan.bwie.com.lihuaizhanproject.network.GlideImageLoader;
import lihuaizhan.bwie.com.lihuaizhanproject.presenter.HeadPresenter;
import lihuaizhan.bwie.com.lihuaizhanproject.view.IHeadFragment;
import lihuaizhan.bwie.com.lihuaizhanproject.view.MipcaActivityCapture;
import lihuaizhan.bwie.com.lihuaizhanproject.view.SearchActivity;


/**
 * Created by Administrator on 2017/11/11.
 */

public class Fragment01 extends Fragment implements IHeadFragment {
    private HeadPresenter presenter;

    private Banner banner;
    private RecyclerView rc;
    private RecyclerView hroRc;
    private Toolbar toolbar;
    private ViewPager headFen;
    private LinearLayout headCircle;
    private View headPage;
    private List<Fragment> list;
    private List<ImageView> ilist;
    private View view ;
    private TextView houre;
    private TextView minnet;
    private TextView second;
    private int h =2;
    private int m =15;
    private int s =30;
    private EditText ed;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1)
            {
                s--;
                   if(s==0)
                   {
                       s=60;
                       m--;
                       if(m==0)
                       {
                           h--;
                       }
                   }


            }
            if (h<10){
                houre.setText("0"+h+"");
            }else {
                houre.setText(h+"");
            }
            if (m<10){
                minnet.setText("0"+m+"");
            }else {
                minnet.setText(m+"");
            }
            if (s<10){
                second.setText("0"+s+"");
            }else {
                second.setText(s+"");
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment01, container, false);
        ImageView sao = view.findViewById(R.id.home_ivsao);
        sao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //扫描二维码
                Intent intent = new Intent(getActivity(), MipcaActivityCapture.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent, 1);
            }
        });
        banner = view.findViewById(R.id.banner);
        headFen = view.findViewById(R.id.head_fen02);
        headCircle = view.findViewById(R.id.head_circle);
         ed = view.findViewById(R.id.ed_sousuo);
        initId();
        rc = view.findViewById(R.id.rc);
        list = new ArrayList<>();
        ilist = new ArrayList<>();
        HeadFragment01 headFragment01 = new HeadFragment01();
        HeadFragment02 headFragment02 = new HeadFragment02();
        list.add(headFragment01);
        list.add(headFragment02);
        presenter = new HeadPresenter(this);
        presenter.getHeadDatas();

        setFenlei();
        reFresh();
        //搜索框点击事件
        ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void reFresh() {
        RefreshLayout refreshLayout = view.findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
            }
        });
    }

    private void initId() {
       houre = view.findViewById(R.id.houre);
       minnet = view.findViewById(R.id.minnet);
       second = view.findViewById(R.id.second);
        hroRc= view.findViewById(R.id.hro_rc);
       new Thread(new Runnable() {
           @Override
           public void run() {
               while (s>0)
               {
                   try {
                       Thread.sleep(1000);
                       Message message = Message.obtain();
                       message.what = 1;
                       handler.sendMessage(message);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       }).start();

    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        list.clear();
//        ilist.clear();
//    }

    private void setFenlei() {


        addDian();
        vplistener();
        headFen.setAdapter(new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });


    }

    @Override
    public void getDatas(HeadBean headBean) {
        Toast.makeText(getActivity(), headBean.getCode(), Toast.LENGTH_SHORT).show();
        List<String> images = new ArrayList<>();
        List<HeadBean.DataBean> data = headBean.getData();
        for (int i = 0; i < data.size(); i++) {
            images.add(data.get(i).getIcon());
        }
        banner.setImageLoader(new GlideImageLoader());
        banner.isAutoPlay(true);

//设置轮播的时间间隔
        banner.setDelayTime(3000);
        banner.setImages(images);
        banner.start();
        List<HeadBean.MiaoshaBean.ListBeanX> list = headBean.getMiaosha().getList();
        MiaoShaAdapter miaoShaAdapter = new MiaoShaAdapter(getActivity(),list);
        LinearLayoutManager linmar = new LinearLayoutManager(getActivity());
        linmar.setOrientation(LinearLayoutManager.HORIZONTAL);
        hroRc.setLayoutManager(linmar);
        hroRc.setAdapter(miaoShaAdapter);
        List<HeadBean.TuijianBean.ListBean> list1 = headBean.getTuijian().getList();
        rc.setLayoutManager(new GridLayoutManager(getActivity(),2));
        TuiJianAdapter tuiJianAdapter = new TuiJianAdapter(getActivity(),list1);
        rc.setAdapter(tuiJianAdapter);
    }

    private void addDian() {
        for (int i = 0; i < list.size(); i++) {
            ImageView iv = new ImageView(getActivity());
            if (i == 0) {
                iv.setImageResource(R.drawable.select);
            } else {
                iv.setImageResource(R.drawable.nomorle);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10, 10);
            params.setMargins(5, 0, 5, 0);
            headCircle.addView(iv, params);
            ilist.add(iv);
        }

    }

    private void vplistener() {
        headFen.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < ilist.size(); i++) {
                    if (position == i) {
                        ilist.get(i).setImageResource(R.drawable.select);
                    } else {
                        ilist.get(i).setImageResource(R.drawable.nomorle);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}