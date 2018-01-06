# Android_RecyclerView
## RecyclerView的优势
  * 低耦合 高内聚
  * 自带性能优化ViewHolder

## RecyclerView使用注意事项
  * LayoutManager 布局摆放管理器（线性，瀑布流,网格）
  * LinearLayoutManager/GridLayoutManager/StaggeredGridLayoutManager

## RecyclerView 采坑
* **LayoutParams :** 获取的params对象为null
```jsx
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
```
