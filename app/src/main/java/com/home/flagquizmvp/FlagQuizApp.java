package com.home.flagquizmvp;

import android.app.Application;

import com.home.flagquizmvp.flagmain.di.DaggerFlagQuizComponent;
import com.home.flagquizmvp.flagmain.di.FlagQuizComponent;
import com.home.flagquizmvp.flagmain.di.FlagQuizModule;
import com.home.flagquizmvp.flagmain.ui.FlagQuizView;
import com.home.flagquizmvp.flagmain.ui.MainActivity;
import com.home.flagquizmvp.lib.di.DaggerLibsComponent;
import com.home.flagquizmvp.lib.di.LibsComponent;
import com.home.flagquizmvp.lib.di.LibsModule;


/**
 * Created by Kelvin on 5/07/2016.
 */
public class FlagQuizApp extends Application {

    @Override
    public void onCreate() {

        super.onCreate();
    }

    public FlagQuizComponent getFlagQuizComponent(MainActivity mainActivity, FlagQuizView flagQuizView){

        return DaggerFlagQuizComponent.builder()
                .libsModule(new LibsModule(mainActivity))
                .flagQuizModule(new FlagQuizModule(flagQuizView))
                .build();
    }

    public LibsComponent getLibsComponent(MainActivity mainActivity){

        return DaggerLibsComponent.builder()
                .libsModule(new LibsModule(mainActivity))
                .build();
    }
}
