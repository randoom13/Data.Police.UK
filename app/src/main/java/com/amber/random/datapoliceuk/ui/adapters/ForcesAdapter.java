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

    private final WeakReference<ForcesListFragmentView> mForcesListFragmentView;
    private List<ForceItem> mForces;

    public ForcesAdapter(ForcesListFragmentView forcesListFragmentView) {
        super();
        mForcesListFragmentView = new WeakReference(forcesListFragmentView);
    }

    public void setForces(List<ForceItem> forces) {
        mForces = forces;
        notifyDataSetChanged();
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
        return new ForceViewHolder(mForcesListFragmentView, binding);
    }

    @Override
    public int getItemCount() {
        return null != mForces ? mForces.size() : 0;
    }

    public static class ForceViewHolder extends BaseController {
        private final WeakReference<ForcesListFragmentView> mForcesListFragmentView;
        private ForceItemRowLayoutBinding mForceItemRowLayoutBinding;

        public ForceViewHolder(WeakReference<ForcesListFragmentView> forcesListFragmentView, ForceItemRowLayoutBinding forceItemRowLayoutBinding) {
            super(forceItemRowLayoutBinding.getRoot());
            mForcesListFragmentView = forcesListFragmentView;
            mForceItemRowLayoutBinding = forceItemRowLayoutBinding;
            mForceItemRowLayoutBinding.setController(this);
        }

        void bind(ForceItem forceItem) {
            mForceItemRowLayoutBinding.setForceItem(forceItem);
            mForceItemRowLayoutBinding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
            ForcesListFragmentView fragmentView = mForcesListFragmentView.get();
            if (null != fragmentView)
                fragmentView.onClick(mForceItemRowLayoutBinding.getForceItem());
        }
    }
}
