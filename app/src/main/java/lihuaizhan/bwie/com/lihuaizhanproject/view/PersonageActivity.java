package lihuaizhan.bwie.com.lihuaizhanproject.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.LoginBean;
import lihuaizhan.bwie.com.lihuaizhanproject.fragment.Fragment05;
import lihuaizhan.bwie.com.lihuaizhanproject.presenter.LoginPresenter;

public class PersonageActivity extends AppCompatActivity implements View.OnClickListener,IPersonageActivity {

    /**
     * x
     */
    private TextView mFanhui;
    /**
     * 请输入用户名
     */
    private EditText mName;
    /**
     * 请输入密码
     */
    private EditText mPass;
    /**
     * 登录
     */
    private Button mLogin;
    /**
     * 手机快速注册
     */
    private TextView mResgin;
    /**
     * 忘记密码
     */
    private TextView mWj;
   private LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personage);
        loginPresenter = new LoginPresenter(this);
        initView();

    }

    private void initView() {
        mFanhui = (TextView) findViewById(R.id.fanhui);
        mFanhui.setOnClickListener(this);
        mName = (EditText) findViewById(R.id.name);
        mPass = (EditText) findViewById(R.id.pass);
        mLogin = (Button) findViewById(R.id.login);
        mLogin.setOnClickListener(this);
        mResgin = (TextView) findViewById(R.id.resgin);
        mResgin.setOnClickListener(this);
        mWj = (TextView) findViewById(R.id.wj);
        mWj.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui:
                this.finish();
                break;
            case R.id.login:
                loginPresenter.onLog();
                break;
            case R.id.resgin:
                Intent intent = new Intent(getApplicationContext(), RegisActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                startActivityForResult(intent,11);
                break;
            case R.id.wj:
                break;
        }
    }

    @Override
    public String getNames() {
        String name = mName.getText().toString().trim();
        return name;
    }

    @Override
    public String getPass() {
        String pass = mPass.getText().toString().trim();
        return pass;
    }

    @Override
    public void onSucc(LoginBean loginBean) {
        Toast.makeText(getApplicationContext(),loginBean.getMsg(),Toast.LENGTH_SHORT).show();
        if(loginBean.getCode().equals("0"))
        {
            Intent intent = this.getIntent();
            Bundle extras = intent.getExtras();
            extras.putString("aaa","111");
            extras.putSerializable("lo",loginBean);
            intent.putExtras(extras);
            PersonageActivity.this.setResult(RESULT_OK,intent);
            PersonageActivity.this.finish();

        }
        else {

            return;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11 && resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            String name = bundle.getString("name");
            String pass = bundle.getString("pass");
            mName.setText(name);
            mPass.setText(pass);

        }
    }
}
