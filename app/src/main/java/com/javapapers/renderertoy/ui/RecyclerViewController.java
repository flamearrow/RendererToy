package com.javapapers.renderertoy.ui;

import android.support.v7.widget.RecyclerView;

public class RecyclerViewController {

    private RendererAdapter rendererAdapter;

    public RecyclerViewController(RecyclerView recyclerView, RendererPool rendererPool) {
        rendererAdapter = new RendererAdapter(rendererPool);
        recyclerView.setAdapter(rendererAdapter);
    }

    public void addItems(Object... models) {
        rendererAdapter.addModel(models);
    }

    public void clear() {
        rendererAdapter.clear();
    }

}
