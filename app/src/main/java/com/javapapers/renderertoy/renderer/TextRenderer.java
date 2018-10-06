package com.javapapers.renderertoy.renderer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.javapapers.renderertoy.model.TextModel;
import com.javapapers.renderertoy.ui.Renderer;

import javax.inject.Inject;

public class TextRenderer implements Renderer<TextModel> {
    TextView textView;

    @Inject
    public TextRenderer(Context context) {
        textView = new TextView(context);
        textView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams
                .MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT));
    }

    @Override
    public View getView() {
        return textView;
    }

    @Override
    public void render(TextModel model) {
        textView.setText(model.text);
        textView.setTextColor(model.color);
    }

    @Override
    public void onViewRecycled() {

    }
}
