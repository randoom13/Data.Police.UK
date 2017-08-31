package com.amber.random.datapoliceuk.di.module;

import com.amber.random.datapoliceuk.api.BackendServiceApi;
import com.amber.random.datapoliceuk.viewmodel.ForcesListViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {
    @Provides
    @Singleton
    public ForcesListViewModel provideMainViewModel(BackendServiceApi backendServiceApi) {
        return new ForcesListViewModel(backendServiceApi);
    }
}
