package com.javapapers.renderertoy;

import android.app.Application;

import com.javapapers.renderertoy.injection.AppComponent;
import com.javapapers.renderertoy.injection.AppModule;
import com.javapapers.renderertoy.injection.DaggerAppComponent;

public class BaseApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
