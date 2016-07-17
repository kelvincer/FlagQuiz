package com.home.flagquizmvp.lib.di;

import com.home.flagquizmvp.lib.ImageLoader;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Kelvin on 5/07/2016.
 */
@Singleton
@Component(modules = LibsModule.class)
public interface LibsComponent {

    ImageLoader getImageLoader();
}
