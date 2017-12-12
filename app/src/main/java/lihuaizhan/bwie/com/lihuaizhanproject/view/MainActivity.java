package lihuaizhan.bwie.com.lihuaizhanproject.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.fragment.Fragment01;
import lihuaizhan.bwie.com.lihuaizhanproject.fragment.Fragment02;
import lihuaizhan.bwie.com.lihuaizhanproject.fragment.Fragment03;
import lihuaizhan.bwie.com.lihuaizhanproject.fragment.Fragment04;
import lihuaizhan.bwie.com.lihuaizhanproject.fragment.Fragment05;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> list = new ArrayList<>();
    private ViewPager mPage;
    private RadioGroup mGrp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment01 fragment01 = new Fragment01();
        Fragment02 fragment02 = new Fragment02();
        Fragment03 fragment03 = new Fragment03();
        Fragment04 fragment04 = new Fragment04();
        Fragment05 fragment05 = new Fragment05();
        list.add(fragment01);
        list.add(fragment02);
        list.add(fragment03);
        list.add(fragment04);
        list.add(fragment05);
        initView();
    }
    private void initView() {
        mPage = (ViewPager) findViewById(R.id.page);
        mGrp = (RadioGroup) findViewById(R.id.grp);
        mGrp.check(R.id.btn1);
//        mPage.setAdapter(new MyPager(getSupportFragmentManager()));
        mPage.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        mPage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mGrp.check(R.id.btn1);
                        break;
                    case 1:
                        mGrp.check(R.id.btn2);
                        break;
                    case 2:
                        mGrp.check(R.id.btn3);
                        break;
                    case 3:
                        mGrp.check(R.id.btn4);
                        break;
                    case 4:
                        mGrp.check(R.id.btn5);
                        break;


                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn1:
                        mPage.setCurrentItem(0);
                        break;

                    case R.id.btn2:
                        mPage.setCurrentItem(1);
                        break;
                    case R.id.btn3:
                        mPage.setCurrentItem(2);
                        break;
                    case R.id.btn4:
                        mPage.setCurrentItem(3);
                        break;
                    case R.id.btn5:
                        mPage.setCurrentItem(4);
                        break;


                }
            }
        });
    }
}
