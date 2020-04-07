package com.ascri.architecturetest.utils.di.modules;

import androidx.lifecycle.ViewModel;

import com.ascri.architecturetest.ui.main.MainFragment;
import com.ascri.architecturetest.ui.main.MainViewModel;
import com.ascri.architecturetest.utils.di.factory.ViewModelKeyClass;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract MainFragment mainFragment();

    @Binds
    @IntoMap
    @ViewModelKeyClass(MainViewModel.class)
    abstract ViewModel bindViewModel(MainViewModel viewModel);
}
