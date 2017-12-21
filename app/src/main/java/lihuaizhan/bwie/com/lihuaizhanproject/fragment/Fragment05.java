package lihuaizhan.bwie.com.lihuaizhanproject.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.io.Serializable;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.LoginBean;
import lihuaizhan.bwie.com.lihuaizhanproject.view.DulefActivity;
import lihuaizhan.bwie.com.lihuaizhanproject.view.NewsActivity;
import lihuaizhan.bwie.com.lihuaizhanproject.view.PersonageActivity;
import lihuaizhan.bwie.com.lihuaizhanproject.view.SetActivity;


/**
 * Created by Administrator on 2017/11/11.
 */

public class Fragment05 extends Fragment implements View.OnClickListener {

    private View view;
    private SimpleDraweeView mTouXiang;
    /**
     * 登录/注册>
     */
    private TextView mLogin;
    private ImageView mSz;
    private ImageView mXiaoxi;
    private ImageView mTz;
    private RelativeLayout mLl;
    private LoginBean loginBean;
    private Intent szIntent;
    private Bundle bundl;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment05, container, false);
        initView(view);
//     loginBean = new LoginBean();
        setArgument();
        return view;
    }

    private void setArgument() {
        
    }

    private void initView(View view) {
        mTouXiang = (SimpleDraweeView) view.findViewById(R.id.tou_xiang);
        mLogin = (TextView) view.findViewById(R.id.login);
        mSz = (ImageView) view.findViewById(R.id.sz);
        mXiaoxi = (ImageView) view.findViewById(R.id.xiaoxi);
        mTz = (ImageView) view.findViewById(R.id.tz);
        mSz.setOnClickListener(this);
        mXiaoxi.setOnClickListener(this);
        mTz.setOnClickListener(this);
        mLl = (RelativeLayout) view.findViewById(R.id.ll);
        mLl.setOnClickListener(this);
        szIntent = new Intent(getActivity().getApplicationContext(), SetActivity.class);
         bundl = new Bundle();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.sz:

                startActivityForResult(szIntent,2);
                break;
            case R.id.xiaoxi:

                Intent xiaoxi = new Intent(getActivity().getApplicationContext(), NewsActivity.class);
                startActivityForResult(xiaoxi,3);
                break;
            case R.id.tz:
                Intent intent1 = new Intent(getActivity().getApplicationContext(), DulefActivity.class);
                startActivity(intent1);
                 break;
            case R.id.ll:
                if(loginBean==null)
                {
                    Intent intent = new Intent(getActivity().getApplicationContext(), PersonageActivity.class);
                    Bundle bundle = new Bundle();
                    intent.putExtras(bundle);
                    startActivityForResult(intent,1);

                }
                else {
                    startActivityForResult(szIntent,2);
                }
                break;
        }
    }


        @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode ==Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
          //  String aaa = bundle.getString("aaa");
            loginBean = (LoginBean) bundle.getSerializable("lo");
            LoginBean.DataBean data1 = loginBean.getData();
            int uid = data1.getUid();
            Toast.makeText(getActivity().getApplicationContext(),loginBean.getCode(),Toast.LENGTH_SHORT).show();
            if(data1.getIcon()==null||data1.getIcon()=="")
            {    mLogin.setText("用户:"+data1.getUsername());
                return;
            }
            Uri parse = Uri.parse(data1.getIcon());
             mTouXiang.setImageURI(parse);
             mLogin.setText("用户:"+data1.getUsername());
             bundl.putString("uid",data1.getUid()+"");
             bundl.putString("token",data1.getToken());
             szIntent.putExtras(bundl);
        }
    }
}
