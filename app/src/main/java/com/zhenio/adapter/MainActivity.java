package com.zhenio.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenio.recycleryadapter.RecyclerAdapter;
import com.zhenio.recycleryadapter.RecyclerHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecycler;
    private RecyclerAdapter<String> recyclerAdapter;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycler = findViewById(R.id.rec_content);
        initData();
        //第一种使用方式
//        recyclerAdapter = new RecyclerAdapter<String>(this, new RecyclerAdapter.RecyclerCallback<String>() {
//            @Override
//            public RecyclerHolder<String> creator(RecyclerAdapter<String> adapter, ViewGroup view, int position) {
//                //这里加载布局文件
//                return new RecyclerHolder<String>(adapter.getView(R.layout.text_layout, view)) {
//                    @Override
//                    public void setData(View view, String data, int position) {
//                        TextView textView = view.findViewById(R.id.text);
//                        textView.setText(data);
//                    }
//                };
//            }
//        });
//        mRecycler.setLayoutManager(new LinearLayoutManager(this));
//        mRecycler.setAdapter(recyclerAdapter);
//        //添加数据源
//        recyclerAdapter.refreshData(list);

        //第二种使用方式：通过继承来实现

    }

    private void initData() {
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("深圳");
        list.add("武汉");
        list.add("杭州");
    }

    class TextRecyclerViewHolder extends RecyclerHolder<String> {
        public TextRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void setData(View view, String data, int position) {
            TextView viewById = view.findViewById(R.id.text);
            viewById.setText(data);

            viewById.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "点击了text内容", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
