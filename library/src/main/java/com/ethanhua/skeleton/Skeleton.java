package com.ethanhua.skeleton;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fnconn.code.XRecyclerView;

/**
 * Created by ethanhua on 2017/7/29.
 */

public class Skeleton {

    public static RecyclerViewSkeletonScreen.Builder bind(XRecyclerView recyclerView) {
        return new RecyclerViewSkeletonScreen.Builder(recyclerView);
    }

    public static ViewSkeletonScreen.Builder bind(View view) {
        return new ViewSkeletonScreen.Builder(view);
    }

}
