package com.amber.random.datapoliceuk.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.amber.random.datapoliceuk.App;
import com.amber.random.datapoliceuk.R;
import com.amber.random.datapoliceuk.databinding.ForcesListFragmentBinding;
import com.amber.random.datapoliceuk.model.force.ForceItem;
import com.amber.random.datapoliceuk.ui.adapters.ForcesAdapter;
import com.amber.random.datapoliceuk.viewmodel.ForcesListFragmentView;
import com.amber.random.datapoliceuk.viewmodel.ForcesListViewModel;

import java.util.List;

public class ForcesListFragment extends BaseFragment<ForcesListFragmentBinding, ForcesListViewModel>
        implements ForcesListFragmentView {
    private ForcesAdapter mForcesAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);
        mViewModel.attach(this);
        bindView(R.layout.forces_list_fragment);
        mBinding.setIsLoading(true);
        setHasOptionsMenu(true);
        Toolbar toolbar = mBinding.toolbar;
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.loadData();
    }

    @Override
    public void onClick(ForceItem forceItem) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void load(List<ForceItem> forces) {
        mBinding.setIsLoading(false);
        mForcesAdapter = new ForcesAdapter(forces, this);
        mBinding.forces.setAdapter(mForcesAdapter);
    }

    @Override
    public void error(Throwable e) {
        super.error(e);
        mBinding.setIsLoading(false);
    }
}
