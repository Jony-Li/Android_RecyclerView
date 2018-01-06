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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //绑定数据
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.tv.setText(list.get(position));
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
}
