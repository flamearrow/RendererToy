package com.javapapers.renderertoy.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

/**
 * A {@link RecyclerView.Adapter} implementation to decouple Modal and {@link Renderer}.
 * <p>
 * A {@link Renderer#getView()} is called whenever the RecyclerView (re)used the ViewHolder to
 * create display an item on screen.
 */
public class RendererAdapter extends RecyclerView.Adapter<RendererViewHolder<?>> {

    @Inject
    RendererPool pool;
    
    private final List<Object> models;

    @Inject
    public RendererAdapter() {
        models = new ArrayList<>();
    }


    public void addModel(Object... newModesl) {
        models.addAll(Arrays.asList(newModesl));
        notifyDataSetChanged();
    }

    public void clear() {
        models.clear();
        notifyDataSetChanged();
    }

    /**
     * Create/retrieve an Renderer when creating the viewholder.
     */
    @NonNull
    @Override
    public RendererViewHolder<?> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RendererViewHolder(createRenderer(parent, viewType));
    }

    private Renderer<?> createRenderer(ViewGroup parent, int viewType) {
        return pool.getRenderer(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RendererViewHolder holder, int position) {
        holder.renderer.render(models.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return pool.getModelViewType(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    public void onViewRecycled(@NonNull RendererViewHolder<?> holder) {
        holder.renderer.onViewRecycled();
    }
}
