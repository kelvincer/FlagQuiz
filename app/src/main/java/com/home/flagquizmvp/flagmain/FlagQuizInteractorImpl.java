package com.home.flagquizmvp.flagmain;

import com.home.flagquizmvp.entitites.Flag;

/**
 * Created by Kelvin on 6/07/2016.
 */
public class FlagQuizInteractorImpl implements FlagQuizInteractor {

    FlagQuizRepository flagQuizRepository;

    public FlagQuizInteractorImpl(FlagQuizRepository flagQuizRepository) {
        this.flagQuizRepository = flagQuizRepository;
    }

    @Override
    public void getFlag() {

        flagQuizRepository.getNextFlag();
    }
}
