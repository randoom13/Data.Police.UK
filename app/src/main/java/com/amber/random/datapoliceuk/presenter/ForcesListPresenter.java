package com.amber.random.datapoliceuk.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.amber.random.datapoliceuk.api.BackendServiceApi;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class ForcesListPresenter extends BasePresenter<ForcesListFragmentView> {
    private final BackendServiceApi mBackendServiceApi;

    public ForcesListPresenter(BackendServiceApi backendServiceApi) {
        super();
        mBackendServiceApi = backendServiceApi;
    }

    public void loadData(String filter) {
        clearSubscriptions();
        boolean emptyFilter = TextUtils.isEmpty(filter);
        Disposable disposable = mBackendServiceApi.getAllForces()
                .subscribeOn(Schedulers.computation())
                .flatMapIterable(items -> items)
                .filter(it -> emptyFilter || it.name().contains(filter))
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> {
                    ForcesListFragmentView forcesListFragment = mViewWR.get();
                    if (null != forcesListFragment)
                        forcesListFragment.load(res);
                }, ex -> {
                    if (ex instanceof HttpException)
                        Log.e(getClass().getSimpleName(), "Failed to load the forcesList from internet", ex);
                    else throw (Exception) ex;
                    ForcesListFragmentView forcesListFragment = mViewWR.get();
                    if (null != forcesListFragment)
                        forcesListFragment.error(ex);
                });

        mCompositeDisposable.add(disposable);
    }
}
