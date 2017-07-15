package com.amber.random.datapoliceuk.viewmodel;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;


public class BaseViewModel<T extends IView> {
    protected final CompositeDisposable mCompositeDisposable;
    protected WeakReference<T> mViewWR;

    public BaseViewModel() {
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
