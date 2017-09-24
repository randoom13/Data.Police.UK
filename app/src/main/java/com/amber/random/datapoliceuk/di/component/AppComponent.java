package com.amber.random.datapoliceuk.di.component;

import com.amber.random.datapoliceuk.di.module.NetworkModule;
import com.amber.random.datapoliceuk.di.module.PresenterModule;
import com.amber.random.datapoliceuk.di.module.RestApiModule;
import com.amber.random.datapoliceuk.ui.fragments.ForcesListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, RestApiModule.class, PresenterModule.class})
public interface AppComponent {
    void inject(ForcesListFragment forcesListFragment);
}
