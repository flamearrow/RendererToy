package com.javapapers.renderertoy.injection;

import com.javapapers.renderertoy.model.ButtonModel;
import com.javapapers.renderertoy.model.TextModel;
import com.javapapers.renderertoy.renderer.ButtonRenderer;
import com.javapapers.renderertoy.renderer.TextRenderer;
import com.javapapers.renderertoy.ui.Renderer;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

/**
 * Binds model's corresponding Providers into {@link RendererMap}.
 */
@Module
public interface RendererBindingModule {
    @Binds
    @IntoMap
    @RendererMap
    @ClassKey(ButtonModel.class)
    Renderer<?> provideButtonRenderer(ButtonRenderer buttonRenderer);

    @Binds
    @IntoMap
    @RendererMap
    @ClassKey(TextModel.class)
    Renderer<?> provideTextRenderer(TextRenderer textRenderer);
}
