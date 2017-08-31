package com.amber.random.datapoliceuk;

import android.app.Application;
import android.support.annotation.VisibleForTesting;

import com.amber.random.datapoliceuk.di.component.AppComponent;
import com.amber.random.datapoliceuk.di.component.DaggerAppComponent;
import com.amber.random.datapoliceuk.di.module.NetworkModule;
import com.amber.random.datapoliceuk.di.module.RestApiModule;
import com.amber.random.datapoliceuk.di.module.ViewModelModule;

public class App extends Application {
    private static AppComponent sComponent;

    public static AppComponent getComponent() {
        return sComponent;
    }

    @VisibleForTesting(otherwise = VisibleForTesting.NONE)
    public static void setComponent(AppComponent component) {
        sComponent = component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sComponent = DaggerAppComponent.builder()
                .networkModule(new NetworkModule())
                .restApiModule(new RestApiModule())
                .viewModelModule(new ViewModelModule())
                .build();
    }
}
