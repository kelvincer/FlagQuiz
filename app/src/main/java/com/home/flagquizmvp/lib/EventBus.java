package com.home.flagquizmvp.lib;

/**
 * Created by Kelvin on 6/07/2016.
 */
public interface EventBus {

    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
