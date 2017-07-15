package com.amber.random.datapoliceuk.ui.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amber.random.datapoliceuk.R;
import com.amber.random.datapoliceuk.databinding.ForceItemRowLayoutBinding;
import com.amber.random.datapoliceuk.model.force.ForceItem;
import com.amber.random.datapoliceuk.viewmodel.ForcesListFragmentView;

import java.lang.ref.WeakReference;
import java.util.List;

public class ForcesAdapter extends RecyclerView.Adapter<ForcesAdapter.ForceViewHolder> {

    private final List<ForceItem> mForces;
    private final WeakReference<ForcesListFragmentView> mForcesListFragmentView;

    public ForcesAdapter(List<ForceItem> forces, ForcesListFragmentView forcesListFragmentView) {
        super();
        mForces = forces;
        mForcesListFragmentView = new WeakReference(forcesListFragmentView);
    }

    @Override
    public void onBindViewHolder(ForceViewHolder holder, int position) {
        holder.bind(mForces.get(position));
    }

    @Override
    public ForceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ForceItemRowLayoutBinding binding = DataBindingUtil.
                inflate(inflater, R.layout.force_item_row_layout, parent, false);
        return new ForceViewHolder(mForcesListFragmentView.get(), binding);
    }

    @Override
    public int getItemCount() {
        return mForces.size();
    }

    public static class ForceViewHolder extends BaseController {
        private final WeakReference<ForcesListFragmentView> mForcesListFragmentView;
        private ForceItemRowLayoutBinding mForceItemRowLayoutBinding;

        public ForceViewHolder(ForcesListFragmentView fragment, ForceItemRowLayoutBinding forceItemRowLayoutBinding) {
            super(forceItemRowLayoutBinding.getRoot());
            mForcesListFragmentView = new WeakReference(fragment);
            mForceItemRowLayoutBinding = forceItemRowLayoutBinding;
            mForceItemRowLayoutBinding.setController(this);
        }

        void bind(ForceItem forceItem) {
            mForceItemRowLayoutBinding.setForceItem(forceItem);
            mForceItemRowLayoutBinding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
            if (!mForcesListFragmentView.isEnqueued())
                mForcesListFragmentView.get().onClick(mForceItemRowLayoutBinding.getForceItem());
        }
    }
}
