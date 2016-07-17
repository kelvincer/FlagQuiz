package com.home.flagquizmvp.flagmain;

import com.home.flagquizmvp.entitites.Flag;
import com.home.flagquizmvp.flagmain.events.FlagQuizEvent;
import com.home.flagquizmvp.flagmain.ui.FlagQuizView;
import com.home.flagquizmvp.lib.EventBus;

import org.greenrobot.eventbus.Subscribe;


/**
 * Created by Kelvin on 6/07/2016.
 */
public class FlagQuizPresenterImpl implements FlagQuizPresenter {

    EventBus eventBus;
    FlagQuizView flagQuizView;
    FlagQuizInteractor flagQuizInteractor;

    public FlagQuizPresenterImpl(EventBus eventBus, FlagQuizView flagQuizView, FlagQuizInteractor flagQuizInteractor) {
        this.eventBus = eventBus;
        this.flagQuizView = flagQuizView;
        this.flagQuizInteractor = flagQuizInteractor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        flagQuizView = null;
    }

    @Override
    public void getFlag() {
        flagQuizInteractor.getFlag();
    }

    @Override
    @Subscribe
    public void onEventMainThread(FlagQuizEvent flagQuizEvent) {

        if(this.flagQuizView != null){
            String error = flagQuizEvent.getError();

            if(error == null) {
                if (flagQuizEvent.getType() == FlagQuizEvent.NEXT_EVENT) {

                    flagQuizView.setFlag(flagQuizEvent.getFlag());
                    flagQuizView.setButtonText(flagQuizEvent.getFlag().getCountries());
                }
            }
        }
    }
}
