package com.javapapers.renderertoy.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Qualification for renderer map, provides a Class-Renderer binding.
 */
@Qualifier
@Retention(RetentionPolicy.CLASS)
public @interface RendererMap {
}
