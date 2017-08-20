package com.amber.random.datapoliceuk.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
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
        implements ForcesListFragmentView,
        SearchView.OnCloseListener, SearchView.OnQueryTextListener {
    private static final String sStateQuery = "sq";
    private ForcesAdapter mForcesAdapter;
    private SearchView mSearchView;
    private CharSequence mInitialQuery;
    //region searchView interfaces implementation

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d(getClass().getSimpleName(), query);
        mViewModel.loadData(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public boolean onClose() {
        return true;
    }

    //endregion searchView interfaces implementation
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);
        mViewModel.attach(this);
        bindView(R.layout.forces_list_fragment);
        mBinding.setIsLoading(true);
        mForcesAdapter = new ForcesAdapter(this);
        mBinding.forces.setAdapter(mForcesAdapter);
        setHasOptionsMenu(true);
        Toolbar toolbar = mBinding.toolbar;
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        if (null != savedInstanceState) {
            mInitialQuery = savedInstanceState.getCharSequence(sStateQuery);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        String filter = (null != mSearchView && !mSearchView.isIconified()) ? mSearchView.getQuery().toString() : "";
        mViewModel.loadData(filter);
    }

    @Override
    public void onClick(ForceItem forceItem) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
        configureSearchView(menu);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (!mSearchView.isIconified()) {
            outState.putCharSequence(sStateQuery, mSearchView.getQuery());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void load(List<ForceItem> forces) {
        mBinding.setIsLoading(false);
        mForcesAdapter.setForces(forces);
    }

    @Override
    public void error(Throwable e) {
        super.error(e);
        mBinding.setIsLoading(false);
    }

    private void configureSearchView(Menu menu) {
        MenuItem search = menu.findItem(R.id.search);
        mSearchView = (SearchView) search.getActionView();
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setOnCloseListener(this);
        mSearchView.setSubmitButtonEnabled(false);
        mSearchView.setIconifiedByDefault(true);
        if (!TextUtils.isEmpty(mInitialQuery)) {
            mSearchView.setIconified(false);
            MenuItemCompat.expandActionView(search);
            mSearchView.setQuery(mInitialQuery, true);
        }
    }
}
