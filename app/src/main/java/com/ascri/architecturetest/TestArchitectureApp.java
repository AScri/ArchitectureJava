package com.ascri.architecturetest;

import com.ascri.architecturetest.utils.di.AppComponent;
import com.ascri.architecturetest.utils.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class TestArchitectureApp extends DaggerApplication {
    public static AppComponent appComponent;
    public static final String TAG = "TEST_ARCHITECTURE_APP";

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        appComponent = DaggerAppComponent.builder().application(this).build();
        return appComponent;
    }
}
