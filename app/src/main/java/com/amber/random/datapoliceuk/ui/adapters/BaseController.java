package com.amber.random.datapoliceuk.ui.adapters;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.amber.random.datapoliceuk.R;

public abstract class BaseController
        extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public BaseController(View itemView) {
        super(itemView);
        itemView.setOnTouchListener(ON_TOUCH);
    }

    public static final View.OnTouchListener ON_TOUCH =
            (v, event) ->
            {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    v.findViewById(R.id.row_content).getBackground()
                            .setHotspot(event.getX(), event.getY());
                return false;
            };

    public abstract void onClick(View v);
}
