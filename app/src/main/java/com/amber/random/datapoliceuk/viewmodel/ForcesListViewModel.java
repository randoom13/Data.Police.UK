package com.amber.random.datapoliceuk.viewmodel;

import android.text.TextUtils;

import com.amber.random.datapoliceuk.api.BackendServiceApi;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class ForcesListViewModel extends BaseViewModel<ForcesListFragmentView> {
    private final BackendServiceApi mBackendServiceApi;

    public ForcesListViewModel(BackendServiceApi backendServiceApi) {
        super();
        mBackendServiceApi = backendServiceApi;
    }

    public void loadData(String filter) {
        clearSubscriptions();
        try {
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
                        ForcesListFragmentView forcesListFragment = mViewWR.get();
                        if (null != forcesListFragment)
                            forcesListFragment.error(ex);
                    });

            mCompositeDisposable.add(disposable);
        } catch (Exception ex) {
            ForcesListFragmentView forcesListFragment = mViewWR.get();
            if (null != forcesListFragment)
                forcesListFragment.error(ex);
        }
    }
}
