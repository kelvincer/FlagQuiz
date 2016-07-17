package com.home.flagquizmvp.flagmain.ui;

import com.home.flagquizmvp.entitites.Flag;

import java.util.List;

/**
 * Created by Kelvin on 5/07/2016.
 */
public interface FlagQuizView {

    void showButtons();
    void hideButtons();
    void showAnswer();
    void showIncorrectAnswer();

    void setFlag(Flag flag);
    void setButtonText(List<String> names);
    void onGetFlagError(String error);
}
