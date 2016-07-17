package com.home.flagquizmvp.flagmain.di;

import com.home.flagquizmvp.flagmain.FlagQuizPresenter;
import com.home.flagquizmvp.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Kelvin on 6/07/2016.
 */
@Singleton
@Component(modules = {FlagQuizModule.class, LibsModule.class})
public interface FlagQuizComponent {

    FlagQuizPresenter getPresenter();
}
