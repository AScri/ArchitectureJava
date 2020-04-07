package com.ascri.architecturetest.ui;

import android.os.Bundle;

import com.ascri.architecturetest.R;
import com.ascri.architecturetest.ui.base.BaseActivity;
import com.ascri.architecturetest.ui.main.MainFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new MainFragment())
                    .commitNow();
        }
    }
}
