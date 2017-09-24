package com.amber.random.datapoliceuk.ui.fragments;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;

import com.amber.random.datapoliceuk.presenter.BasePresenter;
import com.amber.random.datapoliceuk.presenter.BaseView;

import javax.inject.Inject;

public abstract class BaseFragment<B extends ViewDataBinding, P extends BasePresenter>
        extends Fragment implements BaseView {

    @Inject
    protected P mPresenter;
    protected B mBinding;

    protected final void bindView(int layout) {
        if (mPresenter == null)
            throw new IllegalStateException("mPresenter must not be null and should be injected via fragmentComponent.inject(this);");

        mBinding = DataBindingUtil.setContentView(this.getActivity(), layout);
    }

    @Override
    public void onStop() {
        mPresenter.clearSubscriptions();
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        mBinding = null;
        mPresenter.detach();
        super.onDestroyView();
    }

    @Override
    public void error(Throwable e) {
        Snackbar snackbar = Snackbar.make(mBinding.getRoot(), e.getMessage(), Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
