package com.amber.random.datapoliceuk;

import android.app.Application;

import com.amber.random.datapoliceuk.di.component.AppComponent;
import com.amber.random.datapoliceuk.di.component.DaggerAppComponent;
import com.amber.random.datapoliceuk.di.module.NetworkModule;
import com.amber.random.datapoliceuk.di.module.RestApiModule;
import com.amber.random.datapoliceuk.di.module.ViewModelModule;

public class App extends Application {
    private static AppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
      mComponent = DaggerAppComponent.builder()
              .networkModule(new NetworkModule())
              .restApiModule(new RestApiModule())
              .viewModelModule(new ViewModelModule())
              .build();
    }

    public static AppComponent getComponent() {
        return mComponent;
    }
}
