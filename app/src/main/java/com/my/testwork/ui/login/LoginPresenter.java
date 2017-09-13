package com.my.testwork.ui.login;

import com.my.testwork.data.DataManager;
import com.my.testwork.data.model.ResponseData;
import com.my.testwork.injection.ConfigPersistent;
import com.my.testwork.ui.base.BasePresenter;
import com.my.testwork.util.RxUtil;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

@ConfigPersistent
public class LoginPresenter extends BasePresenter<LoginMvpView> {

    private final DataManager mDataManager;
    private Subscription mSubscription;

    @Inject
    public LoginPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(LoginMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void getWeather() {
        checkViewAttached();
        RxUtil.unsubscribe(mSubscription);
        mSubscription = mDataManager.getWeather()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<ResponseData>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "There was an error loading weather.");
                        getMvpView().showError(e);
                    }

                    @Override
                    public void onNext(ResponseData responseData) {
                        if (responseData.getWeather() == null) {
                            getMvpView().showWeatherEmpty();
                        } else {
                            getMvpView().showWeather(responseData.getWeather().getTemp().toString());
                        }
                    }
                });
    }

}
