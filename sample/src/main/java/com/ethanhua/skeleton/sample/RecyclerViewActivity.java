package com.ethanhua.skeleton.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.sample.adapter.NewsAdapter;
import com.ethanhua.skeleton.sample.adapter.PersonAdapter;

/**
 * Created by ethanhua on 2017/7/27.
 */

public class RecyclerViewActivity extends AppCompatActivity {


    private static final String PARAMS_TYPE = "params_type";
    public static final String TYPE_LINEAR = "type_linear";
    public static final String TYPE_GRID = "type_grid";
    private String mType;
    private RecyclerView recyclerView;
    private Button mButton;
    private RecyclerViewSkeletonScreen skeletonScreen;
    private NewsAdapter adapter;

    public static void start(Context context, String type) {
        Intent intent = new Intent(context, RecyclerViewActivity.class);
        intent.putExtra(PARAMS_TYPE, type);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        mType = getIntent().getStringExtra(PARAMS_TYPE);
        init();
    }


    private void init() {

        adapter = new NewsAdapter();

        mButton = findViewById(R.id.btn_click);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showSkeleton();

                hideSkeleton();

            }
        });
    }


    private void  showSkeleton(){

        if (skeletonScreen == null){

            skeletonScreen = Skeleton.bind(recyclerView)
                    .adapter(adapter)
                    .shimmer(true)
                    .angle(20)
                    .frozen(false)
                    .duration(1200)
                    .count(10)
                    .load(R.layout.item_skeleton_news)
                    .build();
        }

        skeletonScreen.show();
    }


   private void hideSkeleton(){

       recyclerView.postDelayed(new Runnable() {
           @Override
           public void run() {
               skeletonScreen.hide();
           }
       }, 3000);
    }


}
