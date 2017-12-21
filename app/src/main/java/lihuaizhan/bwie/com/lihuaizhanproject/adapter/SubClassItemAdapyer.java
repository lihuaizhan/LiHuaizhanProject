package lihuaizhan.bwie.com.lihuaizhanproject.adapter;

import android.content.Context;
import android.net.Uri;
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

public class SubClassItemAdapyer extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<SubClass.DataBean.ListBean> itemList;
    private LayoutInflater inflater;

    public SubClassItemAdapyer(Context context, List<SubClass.DataBean.ListBean> itemList) {
        this.context = context;
        this.itemList = itemList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.subclass_item_recy_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        SubClass.DataBean.ListBean listBean = itemList.get(position);
        Uri parse = Uri.parse(listBean.getIcon());
        holder1.itemIv.setImageURI(parse);
        holder1.itemName.setText(listBean.getName());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
       private SimpleDraweeView itemIv;
       private TextView itemName;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemIv = itemView.findViewById(R.id.sub_item_item_iv);
            itemName = itemView.findViewById(R.id.sub_item_item_name);
        }
    }
}
