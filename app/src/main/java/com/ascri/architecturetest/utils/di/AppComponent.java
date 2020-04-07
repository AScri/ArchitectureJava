package com.ascri.architecturetest.utils.di;

import android.content.Context;

import com.ascri.architecturetest.TestArchitectureApp;
import com.ascri.architecturetest.ui.main.MainViewModel;
import com.ascri.architecturetest.utils.di.factory.ViewModelBuilder;
import com.ascri.architecturetest.utils.di.modules.ActivityBindingModule;
import com.ascri.architecturetest.utils.di.modules.AppModule;
import com.ascri.architecturetest.utils.di.modules.DataModule;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBindingModule.class,
                ViewModelBuilder.class,
                AppModule.class,
                DataModule.class
        }
)
@Singleton
public interface AppComponent extends AndroidInjector<TestArchitectureApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(TestArchitectureApp testArchitectureApp);

        AppComponent build();
    }

    Context getAppContext();

    ObjectMapper getJackson();

    void inject(MainViewModel mainViewModel);
}
