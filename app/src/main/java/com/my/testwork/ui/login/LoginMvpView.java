package com.my.testwork.ui.login;

import com.my.testwork.ui.base.MvpView;

/**
 * Created by Danila on 13.09.2017.
 */

public interface LoginMvpView extends MvpView {
    void showWeather(String weather);

    void showError(Throwable e);

    void showWeatherEmpty();
}
