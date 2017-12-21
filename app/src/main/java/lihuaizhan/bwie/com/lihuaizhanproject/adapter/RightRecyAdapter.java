package lihuaizhan.bwie.com.lihuaizhanproject.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.SubClass;

/**
 * Created by Administrator on 2017/12/16.
 */

public class RightRecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<SubClass.DataBean> list;
    private Context context;
    private LayoutInflater inflater;
    private SubClassItemAdapyer subClassItemAdapyer;

    public RightRecyAdapter(List<SubClass.DataBean> list, Context context) {
        this.list = list;
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.subclass_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
     MyViewHolder holder1 = (MyViewHolder) holder;
        SubClass.DataBean dataBean = list.get(position);
        holder1.subName.setText(dataBean.getName());
        holder1.subRc.setLayoutManager(new GridLayoutManager(context,3));
        List<SubClass.DataBean.ListBean> list = dataBean.getList();
        subClassItemAdapyer = new SubClassItemAdapyer(context,list);
        holder1.subRc.setAdapter(subClassItemAdapyer);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView subName;
        private RecyclerView subRc;
        public MyViewHolder(View itemView) {
            super(itemView);
            subName = itemView.findViewById(R.id.sub_name);
            subRc = itemView.findViewById(R.id.sub_rc);
        }
    }
}
