package lihuaizhan.bwie.com.lihuaizhanproject.app;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import lihuaizhan.bwie.com.lihuaizhanproject.R;

public class BaseActivity extends AppCompatActivity {
    private List<Activity> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        list = new ArrayList<Activity>();
        list.add(this);

    }
    public void onFinishAll()
    {
        if(list!=null)
        {
            for(int i = 0;i<list.size();i++)
            {
                list.get(i).finish();
            }
        }
        list.clear();
    }
}
