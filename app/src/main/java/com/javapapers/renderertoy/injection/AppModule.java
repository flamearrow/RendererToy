package com.javapapers.renderertoy.injection;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public  class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    Context provideContext() {
        return application.getApplicationContext();
    }

}
