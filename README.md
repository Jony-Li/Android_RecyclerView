# Android_RecyclerView
## RecyclerView的优势
  * 低耦合 高内聚
  * 自带性能优化ViewHolder
  * 弊端：比ListView技术要求更高；没有条目点击事件，需要自己实现——回调监听

## RecyclerView使用注意事项
  * LayoutManager 布局摆放管理器（线性，瀑布流,网格）
  * LinearLayoutManager/GridLayoutManager/StaggeredGridLayoutManager
  * View 绘制的流程：onMeasure(测量自身和里面的所有控件) onLayout(摆放里面所有的子控件) onDraw(绘制)
  * LinearLayoutCompat 源码分析

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
* **LayoutParams :**异常：java.lang.IllegalStateException: The specified child already has a parent. You must call removeView() on the child's parent first.
```jsx
    MyStaggeredViedHolder viewHolder = new MyStaggeredViedHolder(View.inflate(viewGroup.getContext(),android.R.layout.simple_list_item_1,viewGroup));
```