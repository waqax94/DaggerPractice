package com.waqas.daggerpractice.di;

import com.waqas.daggerpractice.di.auth.AuthModule;
import com.waqas.daggerpractice.di.auth.AuthViewModelsModule;
import com.waqas.daggerpractice.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector (
        modules = {AuthViewModelsModule.class,
                AuthModule.class}
    )
    abstract AuthActivity contributeAuthActivity();

}
