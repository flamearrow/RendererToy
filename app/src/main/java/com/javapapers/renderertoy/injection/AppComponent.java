package com.javapapers.renderertoy.injection;

import com.javapapers.renderertoy.RendererToyActivity;

import dagger.Component;

@Component(modules = {AppModule.class, AppBindingModule.class, RendererBindingModule.class})
public interface AppComponent {
    void inject(RendererToyActivity activity);
}
