package lihuaizhan.bwie.com.lihuaizhanproject.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.ClassifyBean;

/**
 * Created by Administrator on 2017/11/10.
 */

public class LvAdapter extends BaseAdapter {
    private List<ClassifyBean.DataBean> list;
    private Context context;
    private LayoutInflater inflater;

    public LvAdapter(List<ClassifyBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public void press(int position)
    {
        for(int i = 0;i<list.size();i++){
            ClassifyBean.DataBean dataBean = list.get(i);
            dataBean.setCheck(false);
        }
        ClassifyBean.DataBean dataBeans = list.get(position);
        dataBeans.setCheck(true);
        notifyDataSetChanged();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.lv_layout, null);
             viewHolder.txt =  convertView.findViewById(R.id.txt);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ClassifyBean.DataBean dataBean = list.get(position);
        viewHolder.txt.setText(dataBean.getName());
        if(dataBean.getCheck())
        {      // viewHolder.txt.setBackgroundColor(Color.parseColor("#EEEEEE"));
               viewHolder.txt.setTextColor(Color.parseColor("#FF0000"));
        }
        else
        {  // viewHolder.txt.setBackgroundColor(Color.parseColor("#ffffff"));
            viewHolder.txt.setTextColor(Color.parseColor("#FF262426"));
        }
        return convertView;
    }

    class ViewHolder {
        TextView txt;

    }
}
