package com.my.testwork.data;

import com.my.testwork.data.model.ResponseData;
import com.my.testwork.data.remote.WeatherService;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;


@Singleton
public class DataManager {

    private final WeatherService mWeatherService;
//    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public DataManager(WeatherService weatherService) {
        mWeatherService = weatherService;
    }

    public Observable<ResponseData> getWeather() {
        return mWeatherService.getWeather("Taganrog", "metric", "5768f2b184ee28608a18f69d3099c3ae");
    }

}
