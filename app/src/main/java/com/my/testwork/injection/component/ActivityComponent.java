package com.my.testwork.injection.component;

import com.my.testwork.injection.PerActivity;
import com.my.testwork.injection.module.ActivityModule;
import com.my.testwork.ui.login.LoginActivity;
import com.my.testwork.ui.main.MainActivity;

import dagger.Subcomponent;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity loginActivity);

    void inject(MainActivity mainActivity);
}
