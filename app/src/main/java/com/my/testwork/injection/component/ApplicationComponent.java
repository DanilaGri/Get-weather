package com.my.testwork.injection.component;

import android.app.Application;
import android.content.Context;

import com.my.testwork.data.DataManager;
import com.my.testwork.data.remote.WeatherService;
import com.my.testwork.injection.ApplicationContext;
import com.my.testwork.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

//    void inject(SyncService syncService);

    @ApplicationContext
    Context context();

    Application application();

    DataManager dataManager();

    WeatherService weatherService();

    /*RibotsService ribotsService();
    PreferencesHelper preferencesHelper();
    DatabaseHelper databaseHelper();
    DataManager dataManager();
    RxEventBus eventBus();*/

}
