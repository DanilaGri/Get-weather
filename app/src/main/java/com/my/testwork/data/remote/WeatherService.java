package com.my.testwork.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.my.testwork.data.model.ResponseData;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface WeatherService {
    //  http://api.openweathermap.org/data/2.5/weather?q=Taganrog&units=metric&appid=5768f2b184ee28608a18f69d3099c3ae
    String ENDPOINT = "http://api.openweathermap.org/data/2.5/";

    @GET("weather")
    Observable<ResponseData> getWeather(@Query("q") String g,
                                        @Query("units") String units,
                                        @Query("appid") String appId);

    /******** Helper class that sets up a new services *******/
    class Creator {

        public static WeatherService newWeatherService() {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(WeatherService.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(WeatherService.class);
        }
    }
}
