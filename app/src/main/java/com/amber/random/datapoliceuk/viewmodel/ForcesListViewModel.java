package com.amber.random.datapoliceuk.viewmodel;

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

    public void loadData() {
        clearSubscriptions();
        try {
            Disposable disposable = mBackendServiceApi.getAllForces()
                    .subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(res -> {
                        if (mViewWR.isEnqueued())
                            mViewWR.get().load(res);
                    }, ex -> {
                        if (mViewWR.isEnqueued())
                            mViewWR.get().error(ex);
                    });

            mCompositeDisposable.add(disposable);
        } catch (Exception ex) {
            if (mViewWR.isEnqueued())
                mViewWR.get().error(ex);
        }
    }
}
