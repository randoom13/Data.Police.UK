package com.amber.random.datapoliceuk.ui.fragments;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;

import com.amber.random.datapoliceuk.viewmodel.BaseViewModel;
import com.amber.random.datapoliceuk.viewmodel.IView;

import javax.inject.Inject;

public abstract class BaseFragment<B extends ViewDataBinding, T extends BaseViewModel>
        extends Fragment implements IView {

    @Inject
    protected T mViewModel;
    protected B mBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    protected final void bindView(int layout) {
        if (mViewModel == null)
            throw new IllegalStateException("mViewModel must not be null and should be injected via fragmentComponent.inject(this);");

        mBinding = DataBindingUtil.setContentView(this.getActivity(), layout);
    }

    @Override
    public void onStop() {
        mViewModel.clearSubscriptions();
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        mBinding = null;
        mViewModel.detach();
        super.onDestroyView();
    }

    @Override
    public void error(Throwable e) {
        Snackbar snackbar = Snackbar.make(mBinding.getRoot(), e.getMessage(), Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
