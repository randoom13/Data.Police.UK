package com.amber.random.datapoliceuk.viewmodel;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by akhlivnyuk on 7/11/2017.
 */

public class BaseViewModel<T extends IView> {
    protected final CompositeDisposable mCompositeDisposable;
    protected T mView;

    public BaseViewModel() {
        mCompositeDisposable = new CompositeDisposable();
    }

    public void attach(T view) {
        mView = view;
    }

    public void detach() {
        mView = null;
    }

    public void clearSubscriptions() {
        mCompositeDisposable.clear();
    }
}
