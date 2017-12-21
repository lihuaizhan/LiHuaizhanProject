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

public class MiaoShaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<HeadBean.MiaoshaBean.ListBeanX> list;
    private LayoutInflater inflater;

    public MiaoShaAdapter(Context context, List<HeadBean.MiaoshaBean.ListBeanX> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.miaosha_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HeadBean.MiaoshaBean.ListBeanX listBeanX = list.get(position);
        MyViewHolder holder1 = (MyViewHolder) holder;
        String images = listBeanX.getImages();
        String[] split = images.split("\\|");
        Uri parse = Uri.parse(split[0]);
        holder1.miaoIv.setImageURI(parse);
        holder1.miaoTv.setText(listBeanX.getPrice()+"");
        holder1.maioPointIv.setText(listBeanX.getBargainPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
      private SimpleDraweeView miaoIv;
      private TextView miaoTv;
      private TextView maioPointIv;
        public MyViewHolder(View itemView) {
            super(itemView);
            miaoIv = itemView.findViewById(R.id.miao_iv);
            miaoTv = itemView.findViewById(R.id.miao_tv);
            maioPointIv = itemView.findViewById(R.id.miao_paint_tv);
            maioPointIv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
