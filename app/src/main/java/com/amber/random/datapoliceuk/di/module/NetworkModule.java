package com.amber.random.datapoliceuk.di.module;

import com.amber.random.datapoliceuk.BuildConfig;
import com.amber.random.datapoliceuk.api.AutoValueGsonFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder().serializeNulls()
                .registerTypeAdapterFactory(AutoValueGsonFactory.create()).create();
    }

    @Provides
    @Singleton
    public GsonConverterFactory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(GsonConverterFactory factory) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.END_POINT)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
