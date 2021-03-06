package com.amber.random.datapoliceuk;


import com.amber.random.datapoliceuk.di.component.AppComponent;
import com.amber.random.datapoliceuk.di.module.NetworkModule;
import com.amber.random.datapoliceuk.di.module.PresenterModule;
import com.amber.random.datapoliceuk.di.module.RestApiModule;

import it.cosenonjaviste.daggermock.DaggerMockRule;

public class TestRule extends DaggerMockRule<AppComponent> {
    public TestRule() {
        super(AppComponent.class, new NetworkModule(), new RestApiModule(), new PresenterModule());
        set(App::setComponent);
    }
}
