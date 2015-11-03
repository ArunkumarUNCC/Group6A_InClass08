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
        Parse.initialize(this, "s6EXTtYPaqLdLzzRFH6l1Af7zs3yktlWpLsTRVPF", "eQ3uhic2wBYdZRGm5bcz5W3hwufIshc8XxJ0Y5fP");
    }
}
