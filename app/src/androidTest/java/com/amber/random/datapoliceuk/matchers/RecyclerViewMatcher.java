package com.amber.random.datapoliceuk.matchers;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class RecyclerViewMatcher {
    private final int mRecyclerViewId;

    RecyclerViewMatcher(int recyclerViewId) {
        mRecyclerViewId = recyclerViewId;
    }

    public Matcher<View> atPosition(int position) {
        return onViewAtPosition(position, -1);
    }

    public Matcher<View> onViewAtPosition(int position, int targetViewId) {
        return new TypeSafeMatcher<View>() {
            private View mTargetView;

            @Override
            public void describeTo(Description description) {
                int id = targetViewId == -1 ? mRecyclerViewId : targetViewId;
                description.appendText("with id: " + id);
            }

            @Override
            protected boolean matchesSafely(View item) {
                if (null == mTargetView) {
                    RecyclerView recyclerView = (RecyclerView) item.getRootView()
                            .findViewById(mRecyclerViewId);
                    if (null == recyclerView)
                        return false;

                    mTargetView = recyclerView.findViewHolderForAdapterPosition(position).itemView;
                }


                if (targetViewId != -1 && null != mTargetView)
                    mTargetView = mTargetView.findViewById(targetViewId);
                return item == mTargetView;
            }
        };
    }
}
