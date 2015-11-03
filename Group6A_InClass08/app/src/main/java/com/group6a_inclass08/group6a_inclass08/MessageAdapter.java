package com.group6a_inclass08.group6a_inclass08;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.parse.ParseObject;

/**
 * Created by Arunkumar's on 11/2/2015.
 */
public class MessageAdapter extends ArrayAdapter<ParseObject> {
    TextView fName,fMessage,fDate;

    Context fContext;
    int resource;

    ParseObject[] messages;

    public MessageAdapter(Context context, int resource, ParseObject[] objects) {
        super(context, resource, objects);

        this.fContext = context;
        this.resource = resource;
        this.messages = objects;
    }
}
