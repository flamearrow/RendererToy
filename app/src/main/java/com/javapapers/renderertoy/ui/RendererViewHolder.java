package com.javapapers.renderertoy.ui;

import android.support.v7.widget.RecyclerView;

public class RendererViewHolder<T> extends RecyclerView.ViewHolder {
    Renderer<T> renderer;
    public RendererViewHolder(Renderer<T> renderer) {
        super(renderer.getView());
        this.renderer = renderer;
    }
}
