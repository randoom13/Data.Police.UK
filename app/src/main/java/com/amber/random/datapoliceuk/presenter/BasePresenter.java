package com.amber.random.datapoliceuk.presenter;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;


public class BasePresenter<T extends BaseView> {
    protected final CompositeDisposable mCompositeDisposable;
    protected WeakReference<T> mViewWR;

    public BasePresenter() {
        mCompositeDisposable = new CompositeDisposable();
    }

    public void attach(T view) {
        mViewWR = new WeakReference<T>(view);
    }

    public void detach() {
        mViewWR = new WeakReference<T>(null);
    }

    public void clearSubscriptions() {
        mCompositeDisposable.clear();
    }
}
