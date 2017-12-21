package lihuaizhan.bwie.com.lihuaizhanproject.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.RegisBean;
import lihuaizhan.bwie.com.lihuaizhanproject.presenter.RedisPresenter;

public class RegisActivity extends AppCompatActivity implements View.OnClickListener,IRegisActivity {

    /**
     * 请输入用户名
     */
    private EditText mName01;
    /**
     * 请输入密码
     */
    private EditText mPass01;
    /**
     * 立即注册
     */
    private Button mResgin01;
    private String names ;
    private String pass ;
    private RedisPresenter redisPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        redisPresenter = new RedisPresenter(this);
        initView();

    }

    private void initView() {
        mName01 = (EditText) findViewById(R.id.name01);
        mPass01 = (EditText) findViewById(R.id.pass01);
        mResgin01 = (Button) findViewById(R.id.resgin01);
        mResgin01.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.resgin01:

                redisPresenter.onLog();
                break;
        }
    }

    @Override
    public String getNames() {
        String trim = mName01.getText().toString().trim();
        return trim;
    }

    @Override
    public String getPass() {
        String trim = mPass01.getText().toString().trim();
        return trim;
    }

    @Override
    public void onSucc(RegisBean regisBean) {
        Toast.makeText(getApplicationContext(),regisBean.getMsg(),Toast.LENGTH_SHORT).show();
         names = getNames();
         pass = getPass();
        if(regisBean.getCode().equals("0"))
        { Intent intent = this.getIntent();
            Bundle extras = intent.getExtras();
            extras.putString("name",names);
            extras.putString("pass",pass);
            intent.putExtras(extras);
            RegisActivity.this.setResult(Activity.RESULT_OK,intent);
            RegisActivity.this.finish();
        }
        else {

            return;
        }

    }
}
