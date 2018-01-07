package recyclerview.android.jony.com.android_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jony on 2018/1/6 0006.
 * Email: litaocreate@gmail.com
 * Github: https://github.com/Jony-Li/
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter{
    private List<String> list;
    private OnItemClickListener mOnItemClickListener;

    MyRecyclerViewAdapter(List<String> list){
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // 创建ViewHolder
        MyViewHolder viewHolder = new MyViewHolder(View.inflate(viewGroup.getContext(),android.R.layout.simple_list_item_1,null));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        //绑定数据
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.tv.setText(list.get(position));
        //将View自身的监听事件传递到自定义的监听接口中
        if (mOnItemClickListener != null){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //mOnItemClickListener.onItemClick(v,position);//position可能被复用 bug
                    mOnItemClickListener.onItemClick(v,holder.getLayoutPosition());//
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tv;
        public MyViewHolder(View view) {
            super(view);
            tv = view.findViewById(android.R.id.text1);
        }
    }

    public void addData(int position){
        list.add(position,"add item" + position);
        if (position == 0){
            //提示更新——会影响效率
            notifyDataSetChanged();
        }else {
            //局部更新
            notifyItemInserted(position);
        }
    }

    public void deleteData(int position){
        list.remove(position);
        notifyItemRemoved(position);
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener;

    }

}
