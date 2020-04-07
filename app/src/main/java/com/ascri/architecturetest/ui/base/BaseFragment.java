package com.ascri.architecturetest.ui.base;

import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class BaseFragment extends DaggerFragment {
    @Inject
    protected ViewModelProvider.Factory viewModelFactory;
}
