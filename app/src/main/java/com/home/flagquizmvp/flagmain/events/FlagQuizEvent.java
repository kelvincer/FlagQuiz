package com.home.flagquizmvp.flagmain.events;

import com.home.flagquizmvp.entitites.Flag;

/**
 * Created by Kelvin on 6/07/2016.
 */
public class FlagQuizEvent {

    private int type;
    private String error;
    private Flag flag;

    public final static int SAVE_EVENT = 0;
    public final static int NEXT_EVENT = 1;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }
}
