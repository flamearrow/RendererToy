package com.javapapers.renderertoy.ui;

import android.view.View;

/**
 * The util to bind data model into view.
 *
 * @param <T> data model type.
 */
public interface Renderer<T extends Object> {
    View getView();

    /**
     * Bind data to the view.
     *
     * @param model
     */
    void render(T model);

    /**
     * Called when the view is recycled. Used to release resources.
     */
    void onViewRecycled();
}
