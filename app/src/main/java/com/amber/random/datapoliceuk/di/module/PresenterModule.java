package com.amber.random.datapoliceuk.di.module;

import com.amber.random.datapoliceuk.api.BackendServiceApi;
import com.amber.random.datapoliceuk.presenter.ForcesListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @Provides
    @Singleton
    public ForcesListPresenter providePresenter(BackendServiceApi backendServiceApi) {
        return new ForcesListPresenter(backendServiceApi);
    }
}
