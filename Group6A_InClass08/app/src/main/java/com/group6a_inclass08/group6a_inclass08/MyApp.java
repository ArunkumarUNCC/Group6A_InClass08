package com.group6a_inclass08.group6a_inclass08;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Arunkumar's on 11/2/2015.
 */
public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        //Initialize Parse
        Parse.initialize(this, "3HaYVvf3qFMsKrCrh3AjmdfSm1J2LFtQ5ogCg94v", "CuvIH6vAsYF2Sp7zmRAKty12R1MQ2RbKFGBfeSuW");
    }
}
