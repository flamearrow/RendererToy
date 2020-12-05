package com.javapapers.renderertoy.ui;

import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

public class RecyclerViewController {

    @Inject
    RendererAdapter rendererAdapter;

    @Inject
    public RecyclerViewController() {
    }

    public void setRecyclerView(RecyclerView view) {
        view.setAdapter(rendererAdapter);
    }

    public void addItems(Object... models) {
        rendererAdapter.addModel(models);
    }

    public void clear() {
        rendererAdapter.clear();
    }

}
