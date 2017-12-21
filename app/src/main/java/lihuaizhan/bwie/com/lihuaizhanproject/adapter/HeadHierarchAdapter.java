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
import lihuaizhan.bwie.com.lihuaizhanproject.bean.ClassifyBean;

/**
 * Created by Administrator on 2017/12/15.
 */

public class HeadHierarchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ClassifyBean.DataBean> list;
    private LayoutInflater inflater;

    public HeadHierarchAdapter(Context context, List<ClassifyBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.head_fenlei_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ClassifyBean.DataBean dataBean = list.get(position);
        MyViewHolder holder1 = (MyViewHolder) holder;
        Uri parse = Uri.parse(dataBean.getIcon());
        holder1.img.setImageURI(parse);
        holder1.txt.setText(dataBean.getName());
    }

    @Override
    public int getItemCount() {
        return 10;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView img;
        private TextView txt;
        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.fenlei_img);
            txt = itemView.findViewById(R.id.fenlei_txt);
        }
    }
}
