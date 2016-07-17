package com.home.flagquizmvp.flagmain;

import android.util.Log;

import com.home.flagquizmvp.entitites.Flag;
import com.home.flagquizmvp.flagmain.events.FlagQuizEvent;
import com.home.flagquizmvp.lib.EventBus;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Kelvin on 6/07/2016.
 */
public class FlagQuizRepositoryImpl implements FlagQuizRepository {

    EventBus eventBus;
    String countryName;

    public FlagQuizRepositoryImpl(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void getNextFlag() {

        int rnd = getRandom(FlagQuizRepository.codes.length);
        String countryCode = FlagQuizRepository.codes[rnd];
        countryName = FlagQuizRepository.countries[rnd];
        String flagUrl = String.format(FlagQuizRepository.url, countryCode);

        Log.i("Debug repository", flagUrl);

        List<String> countries = getRandomCountries();
        countries.add(getRandom(4), countryName);

        Flag flag = new Flag();
        flag.setFlagCode(countryCode);
        flag.setSourceUrl(flagUrl);
        flag.setFlagName(countryName);
        flag.setCountries(countries);

        post(flag);
    }

    private void post(Flag flag) {

        FlagQuizEvent flagQuizEvent = new FlagQuizEvent();
        flagQuizEvent.setType(FlagQuizEvent.NEXT_EVENT);
        flagQuizEvent.setFlag(flag);
        eventBus.post(flagQuizEvent);
    }

    private void post() {

        FlagQuizEvent flagQuizEvent = new FlagQuizEvent();
        flagQuizEvent.setType(FlagQuizEvent.SAVE_EVENT);
        eventBus.post(flagQuizEvent);
    }

    public static int getRandom(int length) {
        return new Random().nextInt(length);
    }

    public List<String> getRandomCountries(){

        List<String> countries = new ArrayList<>();

        ArrayList<Integer> numbers = new ArrayList<>();

        for(int i = 0; i < 3;){
            int rnd = new Random().nextInt(FlagQuizRepository.countries.length);
            if(!numbers.contains(rnd)) {
                String country = FlagQuizRepository.countries[rnd];
                if(!country.equals(countryName)) {
                    countries.add(country);
                    i++;
                    numbers.add(rnd);
                }
            }
        }

        return countries;
    }
}
