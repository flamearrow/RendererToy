package com.javapapers.renderertoy.renderer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.javapapers.renderertoy.model.ButtonModel;
import com.javapapers.renderertoy.ui.Renderer;

import javax.inject.Inject;

public class ButtonRenderer implements Renderer<ButtonModel> {
    Button button;
    @Inject
    public ButtonRenderer(Context context) {
        button = new Button(context);
        button.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    @Override
    public View getView() {
        return button;
    }

    @Override
    public void render(ButtonModel model) {
        button.setText(model.buttonText);
    }

    @Override
    public void onViewRecycled() {

    }
}
