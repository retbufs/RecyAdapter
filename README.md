# RecyAdapter
RecyclerView通用适配器
```
        recyclerAdapter = new RecyclerAdapter<String>(this, new RecyclerAdapter.RecyclerCallback<String>() {
            @Override
            public RecyclerHolder<String> creator(RecyclerAdapter<String> adapter, ViewGroup view, int position) {
                //这里加载布局文件
                return new RecyclerHolder<String>(adapter.getView(R.layout.text_layout, view)) {
                    @Override
                    public void setData(View view, String data, int position) {
                        TextView textView = view.findViewById(R.id.text);
                        textView.setText(data);
                    }
                };
            }
        });
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setAdapter(recyclerAdapter);
        //添加数据源
        recyclerAdapter.refreshData(list);
```
导入recycleryadapter模块
