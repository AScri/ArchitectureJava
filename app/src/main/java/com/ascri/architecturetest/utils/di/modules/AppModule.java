package com.ascri.architecturetest.utils.di.modules;

import android.app.Application;
import android.content.Context;

import com.ascri.architecturetest.TestArchitectureApp;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    Context providesContext(TestArchitectureApp app){
        return app.getApplicationContext();
    }

    @Provides
    Application providesApplication(TestArchitectureApp app){
        return app;
    }
}
