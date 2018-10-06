package com.javapapers.renderertoy.ui;

import android.view.View;

import com.javapapers.renderertoy.injection.RendererMap;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Base implementation of {@link RendererPool}.
 */
public class BaseRendererPool implements RendererPool {
    private Map<Class<?>, Provider<Renderer<?>>> rendererMap;

    private Map<Integer, Class<?>> typeToModelMap;
    private Map<Class<?>, Integer> modelToTypeMap;

    @Inject
    public BaseRendererPool(@RendererMap  Map<Class<?>, Provider<Renderer<?>>> rendererMap) {
        this.rendererMap = rendererMap;
        initializeTypeModelMaps();
    }

    private void initializeTypeModelMaps() {
        typeToModelMap = new HashMap<>();
        modelToTypeMap = new HashMap<>();

        for (Map.Entry<Class<?>, Provider<Renderer<?>>> entry : rendererMap.entrySet()) {
            Class<?> clazz = entry.getKey();
            int currentViewType = typeToModelMap.size();
            typeToModelMap.put(currentViewType, clazz);
            modelToTypeMap.put(clazz, currentViewType);
        }
    }

    @Override
    public Renderer<?> getRenderer(View parent, int viewType) {
        return rendererMap.get(typeToModelMap.get(viewType)).get();
    }

    @Override
    public int getModelViewType(Object model) {
        return modelToTypeMap.get(model.getClass());
    }

    @Override
    public void recycleRenderer(Renderer<?> renderer) {
        // Use one of the following
        // RecyclerView.RecycledViewPool recycledViewPool = null;
        // SparseArray<Queue<Renderer<?>> recycledRenderers;
    }

}
