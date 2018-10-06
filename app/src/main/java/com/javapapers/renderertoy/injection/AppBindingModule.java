package com.javapapers.renderertoy.injection;

import com.javapapers.renderertoy.ui.BaseRendererPool;
import com.javapapers.renderertoy.ui.RendererPool;

import dagger.Binds;
import dagger.Module;

@Module
public interface AppBindingModule {
    @Binds
    RendererPool bindsRendererPool(BaseRendererPool baseRendererPool);
}
