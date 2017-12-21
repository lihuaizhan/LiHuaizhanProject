package lihuaizhan.bwie.com.lihuaizhanproject.view.xiangqing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.youth.banner.Banner;

import java.util.ArrayList;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.network.GlideImageLoader;
import lihuaizhan.bwie.com.lihuaizhanproject.view.xiangqing.precenter.IXiangQingPrecenter;
import lihuaizhan.bwie.com.lihuaizhanproject.view.xiangqing.precenter.XiangQingPrecenter;

public class XiangQingActivity extends AppCompatActivity implements IXiangQingActivity, View.OnClickListener  {
    private String pid;
    private TextView mXiangqingTitle;
    private TextView mXiangqingHead;
    private TextView mXiangqingPrice;
    /**
     * 加入购物车
     */
    private Button mAddCarshop;
    /**
     * 立即购买
     */
    private Button mBuy;
    private Banner mXiangqingBanner;
    private IXiangQingPrecenter iXiangQingPrecenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        initView();
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        iXiangQingPrecenter = new XiangQingPrecenter(this);
        iXiangQingPrecenter.getGood();
    }

    @Override
    public void showGood(XiangQingBean xiangQingBean) {
        XiangQingBean.DataBean data = xiangQingBean.getData();
        String[] split = data.getImages().split("\\|");
        ArrayList<String> images = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            images.add(split[i]);
        }
        mXiangqingBanner.setImageLoader(new GlideImageLoader());
        mXiangqingBanner.setImages(images);
        mXiangqingBanner.start();

        mXiangqingTitle.setText(data.getTitle());
        mXiangqingHead.setText(data.getSubhead());
        mXiangqingPrice.setText("¥"+data.getPrice());

    }

    @Override
    public void toast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getPid() {
        return pid;
    }

    private void initView() {
        mXiangqingTitle = (TextView) findViewById(R.id.xiangqing_title);
        mXiangqingHead = (TextView) findViewById(R.id.xiangqing_head);
        mXiangqingPrice = (TextView) findViewById(R.id.xiangqing_price);
        mAddCarshop = (Button) findViewById(R.id.add_carshop);
        mAddCarshop.setOnClickListener(this);
        mBuy = (Button) findViewById(R.id.buy);
        mBuy.setOnClickListener(this);
        mXiangqingBanner = (Banner) findViewById(R.id.xiangqing_banner);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.add_carshop:
                iXiangQingPrecenter.isAdd();
                break;
            case R.id.buy:
                break;
        }
    }
}
