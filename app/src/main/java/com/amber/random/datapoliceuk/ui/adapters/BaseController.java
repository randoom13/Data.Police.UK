package com.amber.random.datapoliceuk.ui.adapters;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import com.amber.random.datapoliceuk.R;

public abstract class BaseController
        extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public static final View.OnTouchListener ON_TOUCH =
            (v, event) ->
            {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.performClick();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                        v.findViewById(R.id.row_content).getBackground()
                                .setHotspot(event.getX(), event.getY());
                    return false;
                }
                return true;
            };

    public BaseController(View itemView) {
        super(itemView);
        itemView.setOnTouchListener(ON_TOUCH);
    }

    public abstract void onClick(View v);
}
