package com.javapapers.renderertoy.ui;

import android.view.View;

import javax.inject.Provider;

/**
 * Provides bindings for Model and {@link Renderer}s.
 * <p>
 * It keeps 1-on-1 mapping of model class type and viewType, provides the ability to retrieve a
 * Renderer from corresponding model or viewType.
 */
public interface RendererPool {
    Renderer<?> getRenderer(View parent, int viewType);

    int getModelViewType(Object model);

    /**
     * Return this renderer back to pool to reuse.
     * <p>
     * Note this is NOT called in {@link RendererAdapter#onViewRecycled(RendererViewHolder)}, it
     * should be called when an entire RecyclerView is no longer used and its {@link Renderer}s
     * recycled.
     *
     * @param renderer
     */
    void recycleRenderer(Renderer<?> renderer);
}
