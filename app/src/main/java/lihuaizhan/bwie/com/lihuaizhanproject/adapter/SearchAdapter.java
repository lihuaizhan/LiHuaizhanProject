package lihuaizhan.bwie.com.lihuaizhanproject.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.GoodsBean;

public class SearchAdapter extends RecyclerView.Adapter {
    private List<GoodsBean.DataBean> list;
    private Context context;

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }


    public SearchAdapter(List<GoodsBean.DataBean> list, Context context) {
        this.list = list;
        //Log.e("tag", "SearchAdapter: "+list.size() );
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.home_rv_item,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        MyHolder holder1 = (MyHolder) holder;
        String[] split = list.get(position).getImages().split("\\|");
        holder1.item_sim.setImageURI(Uri.parse(split[0]));
        holder1.item_title.setText(list.get(position).getTitle());
        holder1.item_price.setText("¥"+list.get(position).getPrice());
        holder1.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(holder.itemView,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size()==0||list==null?0:list.size();
    }
    class MyHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView item_sim;
        TextView item_title;
        TextView item_price;
        LinearLayout ll;
        public MyHolder(View itemView) {
            super(itemView);

            item_sim = itemView.findViewById(R.id.item_sim);
            item_title = itemView.findViewById(R.id.item_title);
            item_price = itemView.findViewById(R.id.item_price);
            ll = itemView.findViewById(R.id.lll);
        }
    }
}
