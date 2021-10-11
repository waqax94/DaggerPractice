package com.waqas.daggerpractice.di;

import com.waqas.daggerpractice.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();

}
