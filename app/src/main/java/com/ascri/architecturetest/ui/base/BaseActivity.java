package com.ascri.architecturetest.ui.base;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;

import dagger.android.support.DaggerAppCompatActivity;

@SuppressLint("Registered")
public class BaseActivity extends DaggerAppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
