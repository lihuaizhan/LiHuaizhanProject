package lihuaizhan.bwie.com.lihuaizhanproject.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.UserMessageBean;
import lihuaizhan.bwie.com.lihuaizhanproject.presenter.UserManagesPresenter;

public class SetActivity extends AppCompatActivity implements ISetActivity{
private  Intent intent;
private UserManagesPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_set);
        intent = this.getIntent();
         presenter = new UserManagesPresenter(this);
         presenter.onData();


       // Toast.makeText(getApplicationContext(),uid,Toast.LENGTH_SHORT).show();;
    }

    @Override
    public void onDatas(UserMessageBean bean) {
        String mobile = bean.getData().getMobile();
      //  Toast.makeText(getApplicationContext(),mobile,Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUid() {
        return  intent.getStringExtra("uid");
    }

    @Override
    public String getToken() {
        return intent.getStringExtra("token");

    }
}
