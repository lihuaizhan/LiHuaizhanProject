package lihuaizhan.bwie.com.lihuaizhanproject.view;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.hjm.bottomtabbar.BottomTabBar;

import java.util.ArrayList;
import java.util.List;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.app.BaseActivity;
import lihuaizhan.bwie.com.lihuaizhanproject.fragment.Fragment01;
import lihuaizhan.bwie.com.lihuaizhanproject.fragment.Fragment02;
import lihuaizhan.bwie.com.lihuaizhanproject.fragment.Fragment03;
import lihuaizhan.bwie.com.lihuaizhanproject.fragment.Fragment04;
import lihuaizhan.bwie.com.lihuaizhanproject.fragment.Fragment05;

public class MainActivity extends BaseActivity {
    private BottomTabBar mb;
   // private List<Fragment> list = new ArrayList<>();
//    private ViewPager mPage;
//    private RadioGroup mGrp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
//        Fragment01 fragment01 = new Fragment01();
//        Fragment02 fragment02 = new Fragment02();
//        Fragment03 fragment03 = new Fragment03();
//        Fragment04 fragment04 = new Fragment04();
//        Fragment05 fragment05 = new Fragment05();
//        list.add(fragment01);
//        list.add(fragment02);
//        list.add(fragment03);
//        list.add(fragment04);
//        list.add(fragment05);
       // initView();
        mb=(BottomTabBar)findViewById(R.id.bottom_tab_bar);

        mb.init(getSupportFragmentManager())
                .setImgSize(100,100)
                .setFontSize(0)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("首页",R.drawable.shouye, Fragment01.class)
                .addTabItem("分类",R.drawable.fenlei, Fragment02.class)
                .addTabItem("发现",R.drawable.faxian, Fragment03.class)
                .addTabItem("购物车",R.drawable.gouwu, Fragment04.class)
                .addTabItem("我的",R.drawable.wode, Fragment05.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }

//    private void initView() {
//        mPage = (ViewPager) findViewById(R.id.page);
//        mGrp = (RadioGroup) findViewById(R.id.grp);
//        mGrp.check(R.id.btn1);
////        mPage.setAdapter(new MyPager(getSupportFragmentManager()));
//        mPage.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
//            @Override
//            public Fragment getItem(int position) {
//                return list.get(position);
//            }
//
//            @Override
//            public int getCount() {
//                return list.size();
//            }
//        });
//        mPage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                switch (position) {
//                    case 0:
//                        mGrp.check(R.id.btn1);
//                        break;
//                    case 1:
//                        mGrp.check(R.id.btn2);
//                        break;
//                    case 2:
//                        mGrp.check(R.id.btn3);
//                        break;
//                    case 3:
//                        mGrp.check(R.id.btn4);
//                        break;
//                    case 4:
//                        mGrp.check(R.id.btn5);
//                        break;
//
//
//                }
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//        mGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//                    case R.id.btn1:
//                        mPage.setCurrentItem(0);
//                        break;
//
//                    case R.id.btn2:
//                        mPage.setCurrentItem(1);
//                        break;
//                    case R.id.btn3:
//                        mPage.setCurrentItem(2);
//                        break;
//                    case R.id.btn4:
//                        mPage.setCurrentItem(3);
//                        break;
//                    case R.id.btn5:
//                        mPage.setCurrentItem(4);
//                        break;
//
//
//                }
//            }
//        });
    //}
}
