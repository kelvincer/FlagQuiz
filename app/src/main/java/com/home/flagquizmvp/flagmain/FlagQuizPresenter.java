package com.home.flagquizmvp.flagmain;

import com.home.flagquizmvp.entitites.Flag;
import com.home.flagquizmvp.flagmain.events.FlagQuizEvent;

/**
 * Created by Kelvin on 5/07/2016.
 */
public interface FlagQuizPresenter {

    void onCreate();
    void onDestroy();

    void getFlag();
    void onEventMainThread(FlagQuizEvent flagQuizEvent);
}
