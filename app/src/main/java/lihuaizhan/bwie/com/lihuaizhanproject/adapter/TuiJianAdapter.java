package lihuaizhan.bwie.com.lihuaizhanproject.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.HeadBean;

/**
 * Created by Administrator on 2017/12/15.
 */

public class TuiJianAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<HeadBean.TuijianBean.ListBean> list;
    private LayoutInflater inflater;

    public TuiJianAdapter(Context context, List<HeadBean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.tuijian_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HeadBean.TuijianBean.ListBean listBean = list.get(position);
        MyViewHolder holder1 = (MyViewHolder) holder;
        Uri parse = Uri.parse(listBean.getImages());
        holder1.tuijianIv.setImageURI(parse);
        holder1.tuijianTv.setText(listBean.getPrice()+"");
        holder1.tuijianName.setText(listBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
      private SimpleDraweeView tuijianIv;
      private TextView tuijianName;
      private TextView tuijianTv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tuijianIv = itemView.findViewById(R.id.tuijian_iv);
            tuijianName = itemView.findViewById(R.id.tujian_name);
            tuijianTv = itemView.findViewById(R.id.tuijian_tv);

        }
    }
}
