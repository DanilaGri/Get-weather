package com.my.testwork;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.my.testwork.injection.component.ApplicationComponent;
import com.my.testwork.injection.component.DaggerApplicationComponent;
import com.my.testwork.injection.module.ApplicationModule;

import timber.log.Timber;

/**
 * Created by Danila on 13.09.2017.
 */

public class MyApplication extends Application {

    ApplicationComponent mApplicationComponent;

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
