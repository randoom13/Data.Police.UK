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
                    .subscribe(res -> mView.load(res), ex -> mView.error(ex));

            mCompositeDisposable.add(disposable);
        } catch (Exception ex) {
            mView.error(ex);
        }
    }
}
