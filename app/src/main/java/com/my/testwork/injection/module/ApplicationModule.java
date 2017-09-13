package com.my.testwork.injection.module;

import android.app.Application;
import android.content.Context;

import com.my.testwork.data.remote.WeatherService;
import com.my.testwork.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provide application-level dependencies.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    WeatherService provideWeatherService() {
        return WeatherService.Creator.newWeatherService();
    }

}
