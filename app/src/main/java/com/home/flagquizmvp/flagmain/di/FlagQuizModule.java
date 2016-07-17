package com.home.flagquizmvp.flagmain.di;


import com.home.flagquizmvp.flagmain.FlagQuizInteractor;
import com.home.flagquizmvp.flagmain.FlagQuizInteractorImpl;
import com.home.flagquizmvp.flagmain.FlagQuizPresenter;
import com.home.flagquizmvp.flagmain.FlagQuizPresenterImpl;
import com.home.flagquizmvp.flagmain.FlagQuizRepository;
import com.home.flagquizmvp.flagmain.FlagQuizRepositoryImpl;
import com.home.flagquizmvp.flagmain.ui.FlagQuizView;
import com.home.flagquizmvp.lib.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kelvin on 6/07/2016.
 */
@Module
public class FlagQuizModule {

    FlagQuizView flagQuizView;

    public FlagQuizModule(FlagQuizView flagQuizView) {
        this.flagQuizView = flagQuizView;
    }

    @Provides
    @Singleton
    FlagQuizView provideFlagQuizView() {
        return this.flagQuizView;
    }

    @Provides
    @Singleton
    FlagQuizPresenter provideFlagQuizPresenter(EventBus eventBus, FlagQuizView flagQuizView, FlagQuizInteractor flagQuizInteractor) {
        return new FlagQuizPresenterImpl(eventBus, flagQuizView, flagQuizInteractor);
    }

    @Provides
    @Singleton
    FlagQuizInteractor provideFlagQuizInteractor(FlagQuizRepository flagQuizRepository){
        return new FlagQuizInteractorImpl(flagQuizRepository);
    }

    @Provides
    @Singleton
    FlagQuizRepository provideFlagQuizRepository(EventBus eventBus){
        return new FlagQuizRepositoryImpl(eventBus);
    }

}
