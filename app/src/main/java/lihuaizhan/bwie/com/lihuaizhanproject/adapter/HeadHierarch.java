package lihuaizhan.bwie.com.lihuaizhanproject.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import lihuaizhan.bwie.com.lihuaizhanproject.R;
import lihuaizhan.bwie.com.lihuaizhanproject.bean.ClassifyBean;

/**
 * Created by Administrator on 2017/12/14.
 */

public class HeadHierarch extends PagerAdapter {
     private Context context;
     private List<ClassifyBean.DataBean> list;
    private RecyclerView re01;
    private RecyclerView re02;

    public HeadHierarch(Context context, List<ClassifyBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v;

     if(position==0)
     {
         v=View.inflate(context, R.layout.head_fen01,null);
         re01=v.findViewById(R.id.fen01);
     }
     else{
         v=View.inflate(context, R.layout.head_fen02,null);
         re02=v.findViewById(R.id.fen02);
     }
      container.addView(v);
        return v;
    }

//    private void setMyPageAdapter(int position) {
//        MyAdapter adapter = new MyAdapter(position);
//        re01.setLayoutManager(new GridLayoutManager(context,5));
//        re01.setAdapter(adapter);
//         re02.setLayoutManager(new GridLayoutManager(context,5));
//        re02.setAdapter(adapter);
//    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
//    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
//        private int position01;
//
//        public MyAdapter(int position01) {
//            this.position01 = position01;
//        }
//
//        @Override
//        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View inflate = View.inflate(context, R.layout.head_recy_item, null);
//            return new MyViewHolder(inflate);
//        }
//
//        @Override
//        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//                 if(position01==0)
//                 {
//
//                 }
//                 else{
//                     ClassifyBean.DataBean dataBean = list.get(position);
//                     MyViewHolder holder1 = (MyViewHolder) holder;
//                     Uri parse = Uri.parse(dataBean.getIcon());
//                     holder1.img.setImageURI(parse);
//                     holder1.txt.setText(dataBean.getName());
//                 }
//        }



}
