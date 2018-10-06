package com.javapapers.renderertoy.model;

import android.support.annotation.ColorInt;

public class TextModel {
    public String text;
    public @ColorInt int color;

    public TextModel(String text, int color) {
        this.text = text;
        this.color = color;
    }
}
