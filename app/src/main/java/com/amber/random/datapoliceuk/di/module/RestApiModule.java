package com.amber.random.datapoliceuk.di.module;

import com.amber.random.datapoliceuk.api.BackendServiceApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RestApiModule {

    @Provides
    @Singleton
    BackendServiceApi provideRestApi(Retrofit retrofit) {
        return retrofit.create(BackendServiceApi.class);
    }
}
