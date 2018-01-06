package recyclerview.android.jony.com.android_recyclerview;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jony on 2018/1/6 0006.
 * Email: litaocreate@gmail.com
 * Github: https://github.com/Jony-Li/
 */

public class MyStaggeredRecyclerViewAdapter extends RecyclerView.Adapter {

    private final List<String> list;
    //模拟瀑布流的随机宽高
    private List<Integer> heights;

    MyStaggeredRecyclerViewAdapter(List<String> list){
        this.list = list;
        heights = new ArrayList<>();
        for (int i=0;i< list.size();i++){
            heights.add((int) (200+Math.random()*50));
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        //创建ViewHolder
        MyStaggeredViedHolder viewHolder = new MyStaggeredViedHolder(View.inflate(viewGroup.getContext(),android.R.layout.simple_list_item_1,null));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //绑定数据
        MyStaggeredViedHolder viewHolder = (MyStaggeredViedHolder) holder;
        //获取的params对象为null
        //java.lang.NullPointerException: Attempt to write to field 'int android.view.ViewGroup$LayoutParams.height' on a null object reference
        ViewGroup.LayoutParams params = viewHolder.tv.getLayoutParams();
        params.height = heights.get(position);
        viewHolder.tv.setBackgroundColor(Color.rgb(100,(int)Math.random()*255,(int)Math.random()*255));
        viewHolder.tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyStaggeredViedHolder extends RecyclerView.ViewHolder{

        private final TextView tv;

        public MyStaggeredViedHolder(View view) {
            super(view);
            tv = view.findViewById(android.R.id.text1);
        }
    }
}
