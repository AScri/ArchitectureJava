package com.ascri.architecturetest.utils.di.factory;

import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelBuilder {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(DaggerAwareViewModelFactory factory);
}
