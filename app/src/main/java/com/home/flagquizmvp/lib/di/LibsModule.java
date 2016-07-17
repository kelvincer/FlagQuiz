package com.home.flagquizmvp.lib.di;

import android.app.Activity;

import com.home.flagquizmvp.lib.EventBus;
import com.home.flagquizmvp.lib.GlideImageLoader;
import com.home.flagquizmvp.lib.GreenRobotEventBus;
import com.home.flagquizmvp.lib.ImageLoader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ykro.
 */
@Module
public class LibsModule {
    Activity activity;

    public LibsModule() {
    }
    public LibsModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @Singleton
    EventBus provideEventBus() {
        return new GreenRobotEventBus();
    }

    @Provides
    @Singleton
    ImageLoader provideImageLoader(Activity activity) {
        GlideImageLoader imageLoader = new GlideImageLoader();
        if (activity != null) {
            imageLoader.setLoaderContext(activity);
        }
        return imageLoader;
    }

    @Provides
    @Singleton
    Activity provideActivity(){
        return this.activity;
    }
}
